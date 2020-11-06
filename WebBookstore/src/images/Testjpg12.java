package images;




import java.awt.BorderLayout;

import java.awt.Color;

import java.awt.Container;
import java.awt.FlowLayout;

import java.awt.Graphics;
import java.awt.GridLayout;

import java.awt.Image;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;


import javax.swing.Icon;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JDesktopPane;

import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JOptionPane;

import javax.swing.JPanel;


public class Testjpg12 
{

public static void main(String[] args)throws Exception
 {
		JFrame jf=new JFrame("中国石油大学网上书店");
	
	    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	    jf.setSize(800, 550);
	
	    jf.setLocation(700, 300);

		jf.setVisible(true);
	
	
		Container con=jf.getContentPane();
	
	
		JPanel jp=new JPanel();

		jp.setBackground(Color.WHITE);

		jp.setLayout(new GridLayout(1,3,150,0));

		jp.setSize(800,100);
		
	
	JButton jb1=new JButton("简介");
		
    JButton jb2=new JButton("公告");
 		
    JButton jb3=new JButton("注册");
	
	JButton jb4=new JButton("登陆");

	
	jb1.setBackground(Color.orange);
	
	jb2.setBackground(Color.orange);
		
jb3.setBackground(Color.orange);
	
	jb4.setBackground(Color.orange);
	
	jp.add(jb1);
	
	jp.add(jb2);
	
	jp.add(jb3);
	
	jp.add(jb4);

	
	con.add(jp,BorderLayout.NORTH);
	
	
		jb3.addActionListener(new ActionListener()
{

			@Override
	
		
public void actionPerformed(ActionEvent e) {

	
			//new	zhuce(); 
			
	
				
				} 
		   });
		   
     String  str="C:/Users/DELL/Documents/李合会/password.jpg";
    
	
		ImageIcon img =new ImageIcon(str);
        JLabel jl=new JLabel();
		
        JPanel jp5=new JPanel();
		
        jl.setIcon(img);
	
	   jp5.add(jl);
	
	   con.add(jp5,BorderLayout.SOUTH);	 
		
 jb3.addActionListener(new ActionListener(){

		
		public void actionPerformed(ActionEvent e) {

	
					
     JOptionPane jo=new JOptionPane();		
				
		jo.showInputDialog(jf, "点了也没用", "账号");
						

					
			
		} 
			
   });


	}

}
