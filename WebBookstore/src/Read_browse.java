

import javax.swing.*;
import javax.swing.table.JTableHeader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Read_browse extends JFrame
{
// �������
private JScrollPane scpDemo;
private JTableHeader jth;
private JTable tabDemo;
private JButton btnShow;
// ���췽��
public Read_browse(){
// �����������ԵĶ���
super("ͼ����Ϣ���");
this.setSize(1500,800);
this.setLayout(null);
this.setLocation(100,50);
// �������
this.scpDemo = new JScrollPane();
this.scpDemo.setBounds(10,50,1500,500);
this.btnShow = new JButton("��ʼ���");
this.btnShow.setBounds(10,10,300,30);
// ����ťע�����
this.btnShow.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
btnShow_ActionPerformed(ae);
}
});
// ��������뵽������
add(this.scpDemo);
add(this.btnShow);
// ��ʾ����
this.setVisible(true);
}
// �����ťʱ���¼�����
public void btnShow_ActionPerformed(ActionEvent ae)
{
// ��������������Դ����ʾ���ݵľ��崦��������ע����
try
{
// �������
//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=sdjw2","s2","123");
Class.forName("com.mysql.jdbc.Driver");
final String URL="jdbc:mysql://localhost:3306/Bookstore?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
Connection conn = DriverManager.getConnection(URL, "root", "itcast");
// ������ѯ����
String sql = "select * from student"; 
PreparedStatement pstm = conn.prepareStatement(sql);
// ִ�в�ѯ
ResultSet rs = pstm.executeQuery();
// �����ж�������¼
int count = 0;
while(rs.next()){
count++;
}
rs = pstm.executeQuery();
// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
Object[][] info = new Object[count][10];
count = 0;
while(rs.next())
{
info[count][0] = rs.getString("ISBN");
//System.out.println(info[count][0]);
info[count][1] = rs.getString("����");
info[count][2] = rs.getString("����");
info[count][3] = rs.getString("�۸�") ;
info[count][4] = rs.getString("������");
info[count][5] = rs.getString("���");
info[count][6] = rs.getString("�Զ�����");
info[count][7] = rs.getString("��������") ;
info[count][8] = rs.getString("����");
info[count][9] = rs.getString("����ͼƬ");

count++;
}
// �����ͷ
String[] title = {"ISBN","����","����","�۸�","������","���","�Զ�����","����","��������"};
// ����JTable
this.tabDemo = new JTable(info,title);
// ��ʾ��ͷ
//this.tabDemo.getRowHeight(50);
this.tabDemo.getColumn("���").setMaxWidth(100);
this.tabDemo.setRowHeight(40);
this.jth = this.tabDemo.getTableHeader();
// ��JTable���뵽���������������
this.scpDemo.getViewport().add(tabDemo); 
}
catch(ClassNotFoundException cnfe){
JOptionPane.showMessageDialog(null,"����Դ����","����",JOptionPane.ERROR_MESSAGE);
}
catch(SQLException sqle){
JOptionPane.showMessageDialog(null,"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
}
}

public static void main(String[] args)
{
new Read_browse();
}
}