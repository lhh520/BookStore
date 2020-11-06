
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.*;
import java.awt.event.*;

public class number extends JFrame  implements ActionListener
{
	  static    PreparedStatement ps=null;  
	  static	Connection ct=null;
	  static    ResultSet rs=null;
	  static    Statement	 state=null;
		
		
	public number(String kk,String ll)
	{
		try
		 {
			 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			 String url="jdbc:sqlserver://localhost:1433;databaseName=sdjw2";
			 String user="s2";
			 String password="123";
			 ct=DriverManager.getConnection( url,user,password);				
			 state=ct.createStatement();
			 String sql1="update student  set ¿â´æ ='"+kk+"'where ISBN='"+ll+"';";
			 System.out.println(sql1);
				
			 
			 state.executeUpdate(sql1);
			 JOptionPane.showMessageDialog(null, "ÃÜÂëÐÞ¸Ä³É¹¦");
			
			
			 
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
	
	
	
			
	
	//}
	public static void main(String[] args)
	{
	    new number("50","1112");

	}

}
