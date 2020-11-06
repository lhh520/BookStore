

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Reader_finished extends JFrame
{
// 定义组件
private JScrollPane scpDemo;
private JTableHeader jth;
private JTable tabDemo;
private JButton btnShow;
JTextArea t1 = new JTextArea(1,15);
// 构造方法
public Reader_finished(String name)
{
// 窗体的相关属性的定义
super("查询已完成订单");
setBounds(((Toolkit.getDefaultToolkit().getScreenSize().width)/2)-300, ((Toolkit.getDefaultToolkit().getScreenSize().height)/2)-300,600,600);
this.setLayout(null);
this.setLocation(100,50);
this.setSize(900, 500);
// 创建组件
this.scpDemo = new JScrollPane();
this.scpDemo.setBounds(10,50,800,500);
this.btnShow = new JButton("开始浏览");
this.btnShow.setBounds(10,10,300,30);
t1.setText(name);
System.out.println(t1.getText());
// 给按钮注册监听
this.btnShow.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
btnShow_ActionPerformed(ae);
}
});
// 将组件加入到窗体中
add(this.scpDemo);
add(this.btnShow);
// 显示窗体
this.setVisible(true);
}
// 点击按钮时的事件处理
public void btnShow_ActionPerformed(ActionEvent ae)
{
// 以下是连接数据源和显示数据的具体处理方法，请注意下
try
{
// 获得连接
//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=sdjw2","s2","123");
Class.forName("com.mysql.jdbc.Driver");
final String URL="jdbc:mysql://localhost:3306/Bookstore?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
Connection conn = DriverManager.getConnection(URL, "root", "itcast");
// 建立查询条件
String m=t1.getText();
//String m="刘小费";
String sql = "select * from 购买 where 用户名 = '"+m+"'";
System.out.println(sql);
PreparedStatement pstm = conn.prepareStatement(sql);
// 执行查询
ResultSet rs = pstm.executeQuery();
// 计算有多少条记录
int count = 0;
while(rs.next()){
count++;
}
rs = pstm.executeQuery();
// 将查询获得的记录数据，转换成适合生成JTable的数据形式
Object[][] info = new Object[count][6];
count = 0;
while(rs.next())
{
info[count][0] = rs.getString("用户名");
info[count][1] = rs.getString("ISBN");
info[count][2] = rs.getString("书名");
info[count][3] = rs.getString("数量") ;
info[count][4] = rs.getString("价格");
info[count][5] = rs.getString("地址");
count++;
}
// 定义表头
String[] title = {"用户名","ISBN","书名","数量","价格"};
// 创建JTable
this.tabDemo = new JTable(info,title);
// 显示表头


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
JOptionPane.showMessageDialog(null,"数据源错误","错误",JOptionPane.ERROR_MESSAGE);
}
catch(SQLException sqle){
JOptionPane.showMessageDialog(null,"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
}
}

public static void main(String[] args)
{
	String s="刘小费";
    new Reader_finished(s);
}
}

class Reader_unfinished extends JFrame
{
// 定义组件
private JScrollPane scpDemo;
private JTableHeader jth;
private JTable tabDemo;
private JButton btnShow;
JTextArea t1 = new JTextArea(1,5);
// 构造方法
public Reader_unfinished(String name)
{
// 窗体的相关属性的定义
super("查询未完成订单");
setBounds(((Toolkit.getDefaultToolkit().getScreenSize().width)/2)-300, ((Toolkit.getDefaultToolkit().getScreenSize().height)/2)-300,10,6);
this.setLayout(null);
this.setLocation(100,50);
this.setSize(900, 500);
// 创建组件
this.scpDemo = new JScrollPane();

this.scpDemo.setBounds(10,50,800,500);
this.btnShow = new JButton("开始浏览");
this.btnShow.setBounds(10,10,300,30);
t1.setText(name);
System.out.println(t1.getText());
// 给按钮注册监听
this.btnShow.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
btnShow_ActionPerformed(ae);
}
});
// 将组件加入到窗体中
add(this.scpDemo);
add(this.btnShow);
// 显示窗体
this.setVisible(true);
}
// 点击按钮时的事件处理
public void btnShow_ActionPerformed(ActionEvent ae)
{
// 以下是连接数据源和显示数据的具体处理方法，请注意下
try
{
// 获得连接
//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=sdjw2","s2","123");
Class.forName("com.mysql.jdbc.Driver");
final String URL="jdbc:mysql://localhost:3306/Bookstore?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
Connection conn = DriverManager.getConnection(URL, "root", "itcast");
// 建立查询条件
String m=t1.getText();
//String m="刘小费";
String sql = "select * from 图书 where 用户名 = '"+m+"'";
System.out.println(sql);
PreparedStatement pstm = conn.prepareStatement(sql);
// 执行查询
ResultSet rs = pstm.executeQuery();
// 计算有多少条记录
int count = 0;
while(rs.next()){
count++;
}
rs = pstm.executeQuery();
// 将查询获得的记录数据，转换成适合生成JTable的数据形式
Object[][] info = new Object[count][6];
count = 0;
while(rs.next())
{
info[count][0] = rs.getString("用户名");
info[count][1] = rs.getString("ISBN");
info[count][2] = rs.getString("书名");
info[count][3] = rs.getString("数量") ;
info[count][4] = rs.getString("价格");
info[count][5] = rs.getString("地址");
count++;
}

  
// 定义表头
String[] title = {"用户名","ISBN","书名","数量","价格"};
// 创建JTable
this.tabDemo = new JTable(info,title);
// 显示表头


this.tabDemo.setRowHeight(20);
this.jth = this.tabDemo.getTableHeader();
// 将JTable加入到带滚动条的面板中
this.scpDemo.getViewport().add(tabDemo); 
}
catch(ClassNotFoundException cnfe){
JOptionPane.showMessageDialog(null,"数据源错误","错误",JOptionPane.ERROR_MESSAGE);
}
catch(SQLException sqle){
JOptionPane.showMessageDialog(null,"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
}
}

}