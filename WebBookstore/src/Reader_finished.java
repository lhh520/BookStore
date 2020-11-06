

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Reader_finished extends JFrame
{
// �������
private JScrollPane scpDemo;
private JTableHeader jth;
private JTable tabDemo;
private JButton btnShow;
JTextArea t1 = new JTextArea(1,15);
// ���췽��
public Reader_finished(String name)
{
// �����������ԵĶ���
super("��ѯ����ɶ���");
setBounds(((Toolkit.getDefaultToolkit().getScreenSize().width)/2)-300, ((Toolkit.getDefaultToolkit().getScreenSize().height)/2)-300,600,600);
this.setLayout(null);
this.setLocation(100,50);
this.setSize(900, 500);
// �������
this.scpDemo = new JScrollPane();
this.scpDemo.setBounds(10,50,800,500);
this.btnShow = new JButton("��ʼ���");
this.btnShow.setBounds(10,10,300,30);
t1.setText(name);
System.out.println(t1.getText());
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
String m=t1.getText();
//String m="��С��";
String sql = "select * from ���� where �û��� = '"+m+"'";
System.out.println(sql);
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
Object[][] info = new Object[count][6];
count = 0;
while(rs.next())
{
info[count][0] = rs.getString("�û���");
info[count][1] = rs.getString("ISBN");
info[count][2] = rs.getString("����");
info[count][3] = rs.getString("����") ;
info[count][4] = rs.getString("�۸�");
info[count][5] = rs.getString("��ַ");
count++;
}
// �����ͷ
String[] title = {"�û���","ISBN","����","����","�۸�"};
// ����JTable
this.tabDemo = new JTable(info,title);
// ��ʾ��ͷ


this.tabDemo.setRowHeight(20);
// this.tabDemo.setRowMargin(20);
tabDemo.getColumnModel().getColumn(0).setPreferredWidth(10);
tabDemo.getColumnModel().getColumn(1).setPreferredWidth(10);
tabDemo.getColumnModel().getColumn(2).setPreferredWidth(10);
tabDemo.getColumnModel().getColumn(3).setPreferredWidth(10);
this.jth = this.tabDemo.getTableHeader();
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
	String s="��С��";
    new Reader_finished(s);
}
}

class Reader_unfinished extends JFrame
{
// �������
private JScrollPane scpDemo;
private JTableHeader jth;
private JTable tabDemo;
private JButton btnShow;
JTextArea t1 = new JTextArea(1,5);
// ���췽��
public Reader_unfinished(String name)
{
// �����������ԵĶ���
super("��ѯδ��ɶ���");
setBounds(((Toolkit.getDefaultToolkit().getScreenSize().width)/2)-300, ((Toolkit.getDefaultToolkit().getScreenSize().height)/2)-300,10,6);
this.setLayout(null);
this.setLocation(100,50);
this.setSize(900, 500);
// �������
this.scpDemo = new JScrollPane();

this.scpDemo.setBounds(10,50,800,500);
this.btnShow = new JButton("��ʼ���");
this.btnShow.setBounds(10,10,300,30);
t1.setText(name);
System.out.println(t1.getText());
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
String m=t1.getText();
//String m="��С��";
String sql = "select * from ͼ�� where �û��� = '"+m+"'";
System.out.println(sql);
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
Object[][] info = new Object[count][6];
count = 0;
while(rs.next())
{
info[count][0] = rs.getString("�û���");
info[count][1] = rs.getString("ISBN");
info[count][2] = rs.getString("����");
info[count][3] = rs.getString("����") ;
info[count][4] = rs.getString("�۸�");
info[count][5] = rs.getString("��ַ");
count++;
}

  
// �����ͷ
String[] title = {"�û���","ISBN","����","����","�۸�"};
// ����JTable
this.tabDemo = new JTable(info,title);
// ��ʾ��ͷ


this.tabDemo.setRowHeight(20);
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

}