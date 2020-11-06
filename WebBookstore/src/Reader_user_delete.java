//管理员登陆界面

import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.*;
public class Reader_user_delete
{
	  static    PreparedStatement ps=null;  
	  static	Connection ct=null;
	  static    ResultSet rs=null;
	  static    Statement	 state=null;
		
	public Reader_user_delete(String name)
	{
		
		
		
			try
			 {
				 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				 String url="jdbc:sqlserver://localhost:1433;databaseName=sdjw2";
				 String user="s2";
				 String password="123";
				 ct=DriverManager.getConnection( url,user,password);
				 state=ct.createStatement();				 			
				 String sql="delete  from 读者 where 登录名='"+name+"';";
				 int result=state.executeUpdate(sql);
				 System.out.println(result);
				 System.exit(-1);
				 
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
	
	public static void main(String[] args)
	{
	    new Reader_user_delete("1235");

	}

	
}
