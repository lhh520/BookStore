import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextArea;
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


public class Reader_query extends JFrame
{   
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
    private JButton detailBtn = new JButton("详细信息");
    private JTextArea textarea = new JTextArea(5, 5);
    private MyTable table;
    private Connection conn;
    private TextArea t1=new TextArea(1,15);

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Reader_query frame = new Reader_query("Database Query");
        frame.connectToDB();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(750, 500));
        frame.setVisible(true);
        frame.setResizable(false);
    }

    //构造函数，负责创建用户界面
    public Reader_query(String title) {
        super("用户"+title+",欢迎您");
        setBounds(((Toolkit.getDefaultToolkit().getScreenSize().width)/2)-300, ((Toolkit.getDefaultToolkit().getScreenSize().height)/2)-300,600,600);
        Vector<String> titles = new Vector<String>(TITLES);
        table = new MyTable(dataModel, titles);
        table.getColumnModel().getColumn(2).setPreferredWidth(30);
        table.getColumnModel().getColumn(3).setPreferredWidth(30);
        table.getColumnModel().getColumn(5).setPreferredWidth(30);
        table.getColumnModel().getColumn(6).setPreferredWidth(150);
        t1.setText(title);
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
        controlPanel.add(detailBtn); 
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

    //连接到数据库
    
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
                if (id.isSelected()) conditions.add("(ISBN = '" + id.getText() + "')");
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
        detailBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	 int row = table.getSelectedRow();
                 int column = table.getSelectedColumn();
                 if (row == -1 || column == 0) return;

                 String val = dataModel.get(row).get(column);
                 String ISBN = dataModel.get(row).get(0);
                 String ID=t1.getText();
                 new Reader_detail(ISBN,ID);
               
                 
            }
        });
       
    }

}

// 查询项目
 
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


class MyTable extends JTable {
    public MyTable(Vector data, Vector title) {
        super(data, title);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        if (column == 0) return false;
        else return true;}}
class MyPanel extends JPanel{

    public void paintComponent(Graphics g){

        super.paintComponent(g);

        //绘制一张背景图片  2.jpg是图片的路径  自己设定为自己想要添加的图片

        Image image = new ImageIcon("C:/Users/DELL/Documents/李合会/2.jpg").getImage();

        g.drawImage(image, 0, 0, this);

    }

}

