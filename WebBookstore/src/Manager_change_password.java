
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.*;
import java.awt.event.*;

public class Manager_change_password extends JFrame  implements ActionListener
{
	  static    PreparedStatement ps=null;  
	  static	Connection ct=null;
	  static    ResultSet rs=null;
	  static    Statement	 state=null;
		Button b1=new Button("�޸�");
		
		Label l1=new Label("�û�����");
		Label l2=new Label("������ ��");
		Label l3=new Label("������ ��");
		TextField t1=new TextField(20);
		TextField t2=new TextField(20);
		TextField t3=new TextField(20);
		Panel a0=new Panel();
	    Panel a1=new Panel();
	    Panel a2=new Panel();
	    Panel a3=new Panel();
	    Panel a4=new Panel();
	public Manager_change_password()
	{
		super("����Ա�޸�����");
		this.setSize(400,400);
		this.setLocation(600,300);
		this.setBackground(Color.LIGHT_GRAY);
		this.setLayout(new GridLayout(5,1));
		this.add(a0);
		this.add(a1);
		this.add(a2);
		
		this.add(a4);
		this.add(a3);
		a1.setLayout(new FlowLayout());
		a2.setLayout(new FlowLayout());
		a3.setLayout(new FlowLayout());
		a4.setLayout(new FlowLayout());
		t2.setEchoChar('*');
		t3.setEchoChar('*');
		a1.add(l1);
		a1.add(t1);
		a2.add(l2);
		a2.add(t2);
		a4.add(l3);
		a4.add(t3);
		a3.add(b1);
		
		b1.addActionListener(this);
		
	
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{	
		
		String ming1=t1.getText();
		String mima1=t2.getText(); 
		String m=t3.getText();
		if(e.getSource()==b1)
		{
			try
			 {
				 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				 String url="jdbc:sqlserver://localhost:1433;databaseName=sdjw2";
				 String user="s2";
				 String password="123";
				 ct=DriverManager.getConnection( url,user,password);				
				 state=ct.createStatement();
				 
				 String sql="select ��¼��  ����  from �û� where ��¼��='"+ming1+"' and ����='"+mima1+"';";
				 rs=state.executeQuery(sql);
				 System.out.println(rs);
				
				 if (rs.next())
				 {   
					 String sql1="update �û�  set ���� ='"+m+"'where ��¼��='"+ming1+"';";
					
					 state.executeUpdate(sql1);
					 JOptionPane.showMessageDialog(null, "�����޸ĳɹ�");
					
					 
				 }
				 else
				 {
					 JOptionPane.showMessageDialog(null,"�����޸�ʧ�ܣ�����˺������Ƿ���ȷ����ɾ��",null,JOptionPane.ERROR_MESSAGE, null);
				 }
				 
				 
				 
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
	    new Manager_change_password();

	}

}
