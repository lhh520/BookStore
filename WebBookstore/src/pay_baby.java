//package test_9;

import java.awt.BorderLayout;
import java.awt.Button;
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
import java.util.concurrent.TimeUnit;

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

  
	 
    private MyJPanel panel;

    private Container contentPane = this.getContentPane();
    private Button b1;

    public pay_baby () {

        this.setSize(450,480);
        this.setLocation(1200, 300);
        
        //this.setLocationRelativeTo(null);

        this.setTitle("支付页面");

        this.setResizable(false);
        panel = new MyJPanel();
        b1=new Button("我已支付");
        b1.setSize(10,10);
        b1.addActionListener(new ActionListener()
        		{

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO 自动生成的方法存根
						//TimeUnit.SECONDS.sleep(20);//秒
				        
					      JOptionPane.showMessageDialog(null, "已成功下单");
						
					}
        	
        	
        	
        	
        		});
        
        panel.setLayout(null);
        

        getContentPane().add(panel,BorderLayout.CENTER);
        getContentPane().add(b1,BorderLayout.SOUTH);

    }
    
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");

        new pay_baby().setVisible(true);

    }

}

class MyJPanel extends JPanel{

    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Image image = new ImageIcon("C:/Users/DELL/Documents/李合会/qr.png").getImage();

        g.drawImage(image, 10, 10, this);

    }

}

 

