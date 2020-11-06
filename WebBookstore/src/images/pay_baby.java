
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

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

 

public class pay_baby extends JFrame 
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

 

    public pay_baby () {

        this.setSize(800,500);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLocationRelativeTo(null);

        this.setTitle("读者登陆");

        this.setResizable(false);
    

		

		
   			 

         

        

         

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

    private void init()
    {

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
   

    public static void main(String[] args) //throws //ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException 
    {

        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");

        new pay_baby().setVisible(true);

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

 

