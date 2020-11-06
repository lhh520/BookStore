

import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.*;
import java.awt.event.*;

public class Manager_registe extends JFrame  implements ActionListener
{
	  static    PreparedStatement ps=null;  
	  static	Connection ct=null;
	  static    ResultSet rs=null;
	  static    Statement	 state=null;		
		Button b3=new Button("添加");
		Label l1=new Label("管理员账号：");
		Label l2=new Label("密       码   ：");
		TextField t1=new TextField(20);
		TextField t2=new TextField(20);
		Panel a0=new Panel();
	    Panel a1=new Panel();
	    Panel a2=new Panel();
	    Panel a3=new Panel();
	public Manager_registe()
	{
		super("管理员注册");
		this.setSize(400,400);
		this.setLocation(600,300);
		this.setBackground(Color.LIGHT_GRAY);
		this.setLayout(new GridLayout(4,1));
		this.add(a0);
		this.add(a1);
		this.add(a2);
		this.add(a3);
		a1.setLayout(new FlowLayout());
		a2.setLayout(new FlowLayout());
		a3.setLayout(new FlowLayout());
		t2.setEchoChar('*');
		a1.add(l1);
		a1.add(t1);
		a2.add(l2);
		a2.add(t2);		
		a3.add(b3);
		b3.addActionListener(this);
		//addWindowListener(new WinClose() );
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{	
		
		String ming1=t1.getText();
		String mima1=t2.getText(); 
		if(e.getSource()==b3)
		{
			try
			 {
				 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				 String url="jdbc:sqlserver://localhost:1433;databaseName=sdjw2";
				 String user="s2";
				 String password="123";
				 ct=DriverManager.getConnection( url,user,password);				
				 state=ct.createStatement();
				 
				 String sql="insert into 用户 (登录名,密码) values ('"+ming1+"','"+mima1+"');";
				 int result=state.executeUpdate(sql);
				 System.out.println(result);
				 JOptionPane.showMessageDialog(null, "添加成功");
				 
			 }
			 catch (Exception ee)
			 {
		           
		            ee.printStackTrace();
			 }
			 finally
			 {
				 try {
		                if(rs!=null)
		                {
		                    rs.close();
		                }
		                if(ps!=null)
		                {
		                    ps.close();
		                } 
		             }
				 catch (Exception eee) 
				   {
		                
		                eee.printStackTrace();
		            }
				 
		}
			 	 
		}
		
		
		}

	public static void main(String[] args)
	{
	    new Manager_registe();

	}
	


	
}
