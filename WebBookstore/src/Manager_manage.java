import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.*;

public class Manager_manage extends JFrame {
    private final int COLUMN = 7;
    private final List<String> TITLES = Arrays.asList(
            "ISBN", "书名", "主编", "价格", "出版社", "简介", "试读内容");
    private Vector<Vector<String>> dataModel = new Vector<Vector<String>>();
    private QueryItem id = new QueryItem("ISBN：", 10);
    private QueryItem name = new QueryItem("书名：", 10);
    private QueryItem sex = new QueryItem("主编：", 5);
    private QueryItem2 age = new QueryItem2("价格自：", "到", 5);
    private QueryItem class_ = new QueryItem("出版社：", 5);
    private QueryItem dept = new QueryItem("简介：", 10);
    private QueryItem addr = new QueryItem("试读内容：", 10);
    private JButton queryBtn = new JButton("查询");
    private JButton saveBtn = new JButton("修改");
   // private JButton insertBtn = new JButton("添加");
    private JButton deleteBtn = new JButton("删除");
    private JTextArea textarea = new JTextArea(5, 5);
    private MyTable table;
    private Connection conn;

    //构造函数，负责创建用户界面
    public Manager_manage(String title) {
        super(title);
        setBounds(((Toolkit.getDefaultToolkit().getScreenSize().width)/2)-300, ((Toolkit.getDefaultToolkit().getScreenSize().height)/2)-300,600,600);
        Vector<String> titles = new Vector<String>(TITLES);
        table = new MyTable(dataModel, titles);
        table.getColumnModel().getColumn(2).setPreferredWidth(30);
        table.getColumnModel().getColumn(3).setPreferredWidth(30);
        table.getColumnModel().getColumn(5).setPreferredWidth(30);
        table.getColumnModel().getColumn(6).setPreferredWidth(150);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        controlPanel.add(id);
        controlPanel.add(name);
        controlPanel.add(sex);
        controlPanel.add(age);
        controlPanel.add(class_);
        controlPanel.add(dept);
        controlPanel.add(addr);
        controlPanel.add(queryBtn);
        controlPanel.add(saveBtn);
       // controlPanel.add(insertBtn);
        controlPanel.add(deleteBtn);
        controlPanel.setPreferredSize(new Dimension(0, 130));

        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new BoxLayout(tablePanel, BoxLayout.Y_AXIS));
        tablePanel.add(Box.createRigidArea(new Dimension(0, 20)));
        tablePanel.add(table.getTableHeader());
        tablePanel.add(new JScrollPane(table));

        JPanel container = new JPanel();
        container.setLayout(new BorderLayout());
        container.add(textarea, BorderLayout.NORTH);
        container.add(tablePanel, BorderLayout.CENTER);

        this.add(controlPanel, BorderLayout.NORTH);
        this.add(container, BorderLayout.CENTER);
        this.add(Box.createRigidArea(new Dimension(20, 0)), BorderLayout.WEST);
        this.add(Box.createRigidArea(new Dimension(20, 0)), BorderLayout.EAST);
        this.add(Box.createRigidArea(new Dimension(0, 20)), BorderLayout.SOUTH);
        setActionListener();
    }

    //程序启动时，需调用该方法连接到数据库
    //之所以不放在构造函数中，是因为这些操作可能抛出异常，需要单独处理
    public void connectToDB() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        final String URL="jdbc:mysql://localhost:3306/Bookstore?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        conn = DriverManager.getConnection(URL, "root", "itcast");
    }

    private void setActionListener() {
        //根据指定条件，列出数据库中满足条件的记录
        queryBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> conditions = new ArrayList<String>();
                if (id.isSelected()) conditions.add("(ISBN = '" + id.getText() + "')");//前面按钮被选择，则对其进行查询。
                if (name.isSelected()) conditions.add("(书名 like '" + name.getText() + "')");
                if (sex.isSelected()) conditions.add("(主编 = '" + sex.getText() + "')");
                if (age.isSelected()) conditions.add("(价格 >= " + age.getText() + " AND " + "价格 <= " + age.getText2() + ")");
                if (class_.isSelected()) conditions.add("(出版社 = '" + class_.getText() + "')");
                if (dept.isSelected()) conditions.add("(简介 = '" + dept.getText() + "')");
                if (addr.isSelected()) conditions.add("(试读内容 like '" + addr.getText() + "')");

                StringBuilder sb = new StringBuilder();
                sb.append("select * from student");
                int length = conditions.size();
                if (length != 0) sb.append(" where ");
                for (int i = 0; i < length; i++) {
                    sb.append(conditions.get(i));
                    if (i != length - 1) sb.append(" AND ");
                }
                sb.append(";");
                String queryString = sb.toString();
                textarea.setText(queryString);

                dataModel.clear();
                Statement stmt;
                try {
                    stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(queryString);
                    Vector<String> record;
                    while (rs.next()) {
                        record = new Vector<String>();
                        for (int i = 0; i < COLUMN; i++) {
                            record.add(rs.getString(i + 1));
                        }
                        dataModel.add(record);
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

                //更新表格
                table.validate();
                table.updateUI();
            }

        });

        //根据用户当前选中的单元格，修改数据库中对应记录的对应字段
        saveBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                int column = table.getSelectedColumn();//从表格中得到
                if (row == -1 || column == 0) return;

                String val = dataModel.get(row).get(column);
                String ISBN = dataModel.get(row).get(0);
                String sql = "update student set " + TITLES.get(column) + " = ? where ISBN = ?;";

                //在文本框显示 SQL 命令
                String cmd = "update student set " + TITLES.get(column) + " = ";
                cmd += (TITLES.get(column) == "价格") ? val : "'" + val + "'";
                cmd += " where ISBN = '" + ISBN + "';";
                textarea.setText(cmd);

                PreparedStatement ps;
                try {
                    ps = conn.prepareStatement(sql);
                    if (TITLES.get(column) == "价格") ps.setInt(1, Integer.valueOf(val));
                    else ps.setString(1, val);
                    ps.setString(2, ISBN);
                    ps.executeUpdate();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        //往数据库中插入一条新的记录
       /* insertBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	new Manager_add();      
            }

        });*/

        //将用户当前选中的记录从数据库中删除
        deleteBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                String ISBN = dataModel.get(row).get(0);
                String sql = "delete from student where ISBN = '" + ISBN + "';";

                //在文本框显示 SQL 命令
                textarea.setText(sql);

                Statement stmt;
                try {
                    stmt = conn.createStatement();
                    if (stmt.executeUpdate(sql) == 0) return;
                    dataModel.remove(row);

                    //更新表格
                    table.validate();
                    table.updateUI();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }

        });
    }

}

/* 查询项目
 * 将复选框、标签、文本框组合成一个组件
 * 对外提供获取文本和选中状态的两个方法
 */
class QueryItem extends JPanel {
    private JCheckBox checkbox;
    private JLabel label;
    private JTextField textfield;

    public QueryItem(String labelText, int textWidth) {
        checkbox = new JCheckBox();
        label = new JLabel(labelText);
        textfield = new JTextField(textWidth);
        this.add(checkbox);
        this.add(label);
        this.add(textfield);
    }

    public boolean isSelected() {
        return checkbox.isSelected();
    }

    public String getText() {
        return textfield.getText();
    }
}

/* 同样是查询项目
 * 这是用于查询价格范围的组件，包含了两个文本框
 * 因此特殊处理，并增加了获取第二个文本框内容的方法
 */
class QueryItem2 extends QueryItem {
    private JLabel label2;
    private JTextField textfield2;

    public QueryItem2(String labelText, String labelText2, int textWidth) {
        super(labelText, textWidth);
        label2 = new JLabel(labelText2);
        textfield2 = new JTextField(textWidth);
        this.add(label2);
        this.add(textfield2);
    }

    public String getText2() {
        return textfield2.getText();
    }
}

/* 表格组件
 * 重载了 JTable 的 isCellEditable 方法
 * 目的是防止编辑 ISBN 字段，禁止修改主键
 */
class MyTable extends JTable {
    public MyTable(Vector data, Vector title) {
        super(data, title);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        if (column == 0) return false;
        else return true;}}