

import javax.swing.*;
import javax.swing.table.JTableHeader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Read_browse extends JFrame
{
// 定义组件
private JScrollPane scpDemo;
private JTableHeader jth;
private JTable tabDemo;
private JButton btnShow;
// 构造方法
public Read_browse(){
// 窗体的相关属性的定义
super("图书信息浏览");
this.setSize(1500,800);
this.setLayout(null);
this.setLocation(100,50);
// 创建组件
this.scpDemo = new JScrollPane();
this.scpDemo.setBounds(10,50,1500,500);
this.btnShow = new JButton("开始浏览");
this.btnShow.setBounds(10,10,300,30);
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
String sql = "select * from student"; 
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
Object[][] info = new Object[count][10];
count = 0;
while(rs.next())
{
info[count][0] = rs.getString("ISBN");
//System.out.println(info[count][0]);
info[count][1] = rs.getString("书名");
info[count][2] = rs.getString("主编");
info[count][3] = rs.getString("价格") ;
info[count][4] = rs.getString("出版社");
info[count][5] = rs.getString("简介");
info[count][6] = rs.getString("试读内容");
info[count][7] = rs.getString("出版日期") ;
info[count][8] = rs.getString("分类");
info[count][9] = rs.getString("封面图片");

count++;
}
// 定义表头
String[] title = {"ISBN","书名","主编","价格","出版社","简介","试读内容","分类","出版日期"};
// 创建JTable
this.tabDemo = new JTable(info,title);
// 显示表头
//this.tabDemo.getRowHeight(50);
this.tabDemo.getColumn("简介").setMaxWidth(100);
this.tabDemo.setRowHeight(40);
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

public static void main(String[] args)
{
new Read_browse();
}
}