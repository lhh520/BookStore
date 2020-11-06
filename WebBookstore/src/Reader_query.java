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
            "ISBN", "����", "����", "�۸�", "������", "���", "�Զ�����");
    private Vector<Vector<String>> dataModel = new Vector<Vector<String>>();
    private QueryItem id = new QueryItem("ISBN��", 10);
    private QueryItem name = new QueryItem("������", 10);
    private QueryItem sex = new QueryItem("���ࣺ", 5);
    private QueryItem2 age = new QueryItem2("�۸��ԣ�", "��", 5);
    private QueryItem class_ = new QueryItem("�����磺", 5);
    private QueryItem dept = new QueryItem("��飺", 10);
    private QueryItem addr = new QueryItem("�Զ����ݣ�", 10);
    private JButton queryBtn = new JButton("��ѯ");
    private JButton detailBtn = new JButton("��ϸ��Ϣ");
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

    //���캯�������𴴽��û�����
    public Reader_query(String title) {
        super("�û�"+title+",��ӭ��");
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

    //���ӵ����ݿ�
    
    public void connectToDB() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        final String URL="jdbc:mysql://localhost:3306/Bookstore?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        conn = DriverManager.getConnection(URL, "root", "itcast");
    }

    private void setActionListener() {
        //����ָ���������г����ݿ������������ļ�¼
        queryBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> conditions = new ArrayList<String>();
                if (id.isSelected()) conditions.add("(ISBN = '" + id.getText() + "')");
                if (name.isSelected()) conditions.add("(���� like '" + name.getText() + "')");
                if (sex.isSelected()) conditions.add("(���� = '" + sex.getText() + "')");
                if (age.isSelected()) conditions.add("(�۸� >= " + age.getText() + " AND " + "�۸� <= " + age.getText2() + ")");
                if (class_.isSelected()) conditions.add("(������ = '" + class_.getText() + "')");
                if (dept.isSelected()) conditions.add("(��� = '" + dept.getText() + "')");
                if (addr.isSelected()) conditions.add("(�Զ����� like '" + addr.getText() + "')");

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

                //���±��
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

// ��ѯ��Ŀ
 
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

/* ͬ���ǲ�ѯ��Ŀ
 * �������ڲ�ѯ�۸�Χ������������������ı���
 * ������⴦���������˻�ȡ�ڶ����ı������ݵķ���
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

        //����һ�ű���ͼƬ  2.jpg��ͼƬ��·��  �Լ��趨Ϊ�Լ���Ҫ��ӵ�ͼƬ

        Image image = new ImageIcon("C:/Users/DELL/Documents/��ϻ�/2.jpg").getImage();

        g.drawImage(image, 0, 0, this);

    }

}

