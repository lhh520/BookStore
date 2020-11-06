
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.io.BufferedReader;

import java.io.BufferedWriter;

import java.io.File;

import java.io.FileReader;

import java.io.FileWriter;

import java.io.IOException;

import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import javax.swing.JTextField;

import javax.swing.UIManager;

import javax.swing.UnsupportedLookAndFeelException;

 

public class Manager_Login_in extends JFrame 
{

    //设置一个含有背景图片的面板
	 static    PreparedStatement ps=null;  
	  static	Connection ct=null;
	  static    ResultSet rs=null;
	  static    Statement	 state=null;
    private MyPanel panel;

    private JLabel lab_zhanghao = new JLabel("账号:");

    private JTextField jta_text = new JTextField();

    Font lab = new Font("楷体",1,30);

    private JLabel lat_password = new JLabel("密码:");

    Font lat  = new Font("楷体",1,30);

    private JPasswordField jtb_text = new JPasswordField();

    private JButton btn_register = new JButton("注册");

    private JButton btn_land = new JButton("登陆");

    Font btn = new Font("黑体",2,30);

    public static  int pd = 0;

    private Container contentPane = this.getContentPane();
    public Manager_Login_in () {

        this.setSize(800,500);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       this.setLocationRelativeTo(null);

        this.setTitle("管理员登陆");

        this.setResizable(false);       

		btn_register.addActionListener(new ActionListener() {

            @SuppressWarnings("deprecation")
            
			public void actionPerformed(ActionEvent e) {
            	try
   			 {String ming1=jta_text.getText();
    		  String mima1=jtb_text.getText();
   				 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
   				 String url="jdbc:sqlserver://localhost:1433;databaseName=sdjw2";
   				 String user="s2";
   				 String password="123";
   				 ct=DriverManager.getConnection( url,user,password);
   				 state=ct.createStatement();				 
   				 String sql="insert into 用户 (登录名,密码) values ('"+ming1+"','"+mima1+"');";
   				 int result=state.executeUpdate(sql);
   				 System.out.println(result);
   				 //JOptionPane.showMessageDialog(null, "注册成功");
   				 JOptionPane.showMessageDialog(null,"注册成功！ 您的用户名是："+ming1+"密码是："+ mima1);
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

        });

		btn_land.addActionListener(new ActionListener()//登陆
        {    
            @SuppressWarnings("deprecation")

			public void actionPerformed(ActionEvent e) {
            	try
   			 { String ming1=jta_text.getText();
		       String mima1=jtb_text.getText();

   				 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
   				 String url="jdbc:sqlserver://localhost:1433;databaseName=sdjw2";
   				 String user="s2";
   				 String password="123";
   				 ct=DriverManager.getConnection( url,user,password);   				 
   				 state=ct.createStatement();
   				 
   				 String sql="select 登录名  密码  from 用户 where 登录名='"+ming1+"' and 密码='"+mima1+"';";
   				 rs=state.executeQuery(sql);
   				 System.out.println(rs);
   				
   				 if (rs.next())
   				 {
   					 
   					JOptionPane.showMessageDialog(null, "登录成功！");
   					 
   					Manage_menu frame = new Manage_menu(ming1);

   					frame.setVisible(true);
   				      
   				 }
   				 else
   				 {
   					JOptionPane.showMessageDialog(null,"登陆失败！检查账号密码是否正确或请注册后登录",null,JOptionPane.ERROR_MESSAGE, null);
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
        }});

         

        init();

         

        panel = new MyPanel();

        //将所有的组件添加到panel面板中

        panel.add(lab_zhanghao,BorderLayout.CENTER);

        panel.add(lat_password);

        panel.add(jta_text);

        panel.add(jtb_text);

        panel.add(btn_register);

        panel.add(btn_land);

        panel.setLayout(null);
        

        getContentPane().add(panel,BorderLayout.CENTER);

    }

    private void init() {

        lab_zhanghao.setSize(200,100);

        lab_zhanghao. setLocation(250,120);

        lab_zhanghao.setFont(lab);

        lat_password.setSize(200,100);

        lat_password.setLocation(250,180);

        lat_password.setFont(lat);

        jta_text.setSize(190,30);

        jta_text.setLocation(360,155);

        jtb_text.setSize(190,30);

        jtb_text.setLocation(360,215);

        btn_register.setSize(120, 40);

        btn_register.setLocation(260, 280);

        btn_land.setSize(120, 40);

        btn_land.setLocation(430, 280);

        btn_register.setFont(btn);

        btn_land.setFont(btn);

    }
   

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");

        new Manager_Login_in().setVisible(true);

    }

}

class MyPanel extends JPanel{

    public void paintComponent(Graphics g){

        super.paintComponent(g);

        //绘制一张背景图片  2.jpg是图片的路径  自己设定为自己想要添加的图片

        Image image = new ImageIcon("C:/Users/DELL/Documents/李合会/2.jpg").getImage();

        g.drawImage(image, 0, 0, this);

    }

}

 

