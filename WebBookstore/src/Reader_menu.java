
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

public class Reader_menu extends JFrame implements ActionListener
{
	JTextArea t1 = new JTextArea(1,15);
JMenuBar menuBar = new JMenuBar();// 创建菜单栏对象
JMenu menu = new JMenu("书籍服务");// 创建菜单对象
JMenuItem menuItem11 = new JMenuItem("书籍浏览");
JMenu menu3 = new JMenu("订单查询");// 创建菜单对象
JMenuItem menuItem31 = new JMenuItem("未完成订单");// 创建菜单项对象
//JMenuItem menuItem31 = new JMenuItem("未完成订单");// 创建菜单项对象
JMenuItem menuItem32 = new JMenuItem("已完成订单");// 创建菜单项对象
JMenu menu4 = new JMenu("账户服务");// 创建菜单对象
JMenuItem menuItem41 = new JMenuItem("修改密码");// 创建菜单项对象

JMenuItem menuItem42 = new JMenuItem("联系客服");// 创建菜单项对象
JMenuItem menuItem43 = new JMenuItem("账户注销");// 创建菜单项对象
JMenu menu6 = new JMenu("关于");// 创建菜单对象
JMenu sonMenu6= new JMenu("帮助");// 创建菜单的子菜单对象
JMenuItem sonMenuItem6 = new JMenuItem("书籍服务");// 创建子菜单的菜单项对象
JMenuItem sonMenuItem61 = new JMenuItem("订单查询");// 创建子菜单的菜单项对象

JMenuItem menuItem6 = new JMenuItem("版本信息");// 创建菜单项对象
JMenuItem menuItem63 = new JMenuItem("网页版测试");// 创建菜单项对象
JMenuItem sonMenuItem62 = new JMenuItem("账户服务");// 创建子菜单的菜单项对象

JMenuItem menuItem7 = new JMenuItem("站外连接");// 创建子菜单的菜单项对象
JMenuItem sonMenuItem71 = new JMenuItem("当当网");// 创建子菜单的菜单项对象

JMenuItem sonMenuItem72 = new JMenuItem("淘宝");// 创建菜单项对象
JMenuItem sonMenuItem73 = new JMenuItem("京东");// 创建菜单项对象
JTextArea J1=new JTextArea(1,10);
private MyJJJPanel panel = new MyJJJPanel();
private Container contentPane = this.getContentPane();

	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {

		Reader_menu frame = new Reader_menu("123");

		frame.setVisible(true);

	}

	

	public Reader_menu(String name)
	{

		super("用户:"+name+",欢迎您");

		t1.setText(name);

		setBounds(300, 90,1240,900);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		

		

		setJMenuBar(menuBar);// 将菜单栏对象添加到窗体的菜单栏中

		

		

		menuBar.add(menu);// 将菜单对象添加到菜单栏对象中


		// 创建菜单项对象

		menuItem11.addActionListener(this);// 为菜单项添加事件监听器

		menu.add(menuItem11);// 将菜单项对象添加到菜单对象中

		menuBar.add(menu3);// 将菜单对象添加到菜单栏对象中

		menuItem31.addActionListener(this);// 为菜单项添加事件监听器

		menu3.add(menuItem31);// 将菜单项对象添加到菜单对象中

		

		menuItem32.addActionListener(this);// 为菜单项添加事件监听器

		menu3.add(menuItem32);// 将菜单项对象添加到菜单对象中
		
	
		//
		

		menuBar.add(menu4);// 将菜单对象添加到菜单栏对象中

		

		

		menuItem41.addActionListener(this);// 为菜单项添加事件监听器

		menu4.add(menuItem41);// 将菜单项对象添加到菜单对象中


		menuItem42.addActionListener(this);// 为菜单项添加事件监听器

		menu4.add(menuItem42);// 将菜单项对象添加到菜单对象中
		

		menuItem43.addActionListener(this);// 为菜单项添加事件监听器

		menu4.add(menuItem43);// 将菜单项对象添加到菜单对象中
		
		
		
		
		menuBar.add(menu6);// 将菜单对象添加到菜单栏对象中

		menuItem6.addActionListener( this);// 为菜单项添加事件监听器

		menu6.add(menuItem6);// 将菜单项对象添加到菜单对象中
		menuItem63.addActionListener( this);// 为菜单项添加事件监听器

		menu6.add(menuItem63);// 将菜单项对象添加到菜单对象中
		

		

		menu6.add(sonMenu6);// 将子菜单对象添加到上级菜单对象中

		

		

		sonMenuItem6.addActionListener(this);// 为菜单项添加事件监听器

		sonMenu6.add(sonMenuItem6);// 将子菜单的菜单项对象添加到子菜单对象中
		
		

		sonMenuItem61.addActionListener(this);// 为菜单项添加事件监听器

		sonMenu6.add(sonMenuItem61);// 将子菜单的菜单项对象添加到子菜单对象中
		

		sonMenuItem62.addActionListener(this);// 为菜单项添加事件监听器

		sonMenu6.add(sonMenuItem62);// 将子菜单的菜单项对象添加到子菜单对象中
		J1.setText("state: ");
		getContentPane().add(panel,BorderLayout.CENTER);
		this.add(J1,BorderLayout.SOUTH);
		
}


	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==menuItem11)//添加管理员
		{   String m1=menuItem11.getText();
		   J1.setText("state: "+m1);
		   this.add(J1,BorderLayout.SOUTH);
			
			Reader_query frame = new Reader_query(t1.getText());
		        try {
					frame.connectToDB();
				} catch (ClassNotFoundException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
		        
		        frame.setMinimumSize(new Dimension(750, 500));
		        frame.setVisible(true);
		        frame.setResizable(false);
			
		}
		if(e.getSource()==menuItem31)//添加管理员
		{   String m1=menuItem31.getText();
		   J1.setText("state: "+m1);
		   this.add(J1,BorderLayout.SOUTH);
			new Reader_unfinished(t1.getText());
			
		}
		if(e.getSource()==menuItem32)//添加管理员
		{   String m1=menuItem32.getText();
		   J1.setText("state: "+m1);
		   this.add(J1,BorderLayout.SOUTH);
			new Reader_finished(t1.getText());
			
		}
		if(e.getSource()==menuItem41)//添加管理员
		{    String m1=menuItem41.getText();
		   J1.setText("state: "+m1);
		   this.add(J1,BorderLayout.SOUTH);
			 new Manager_change_user_password();
			
		}
		if(e.getSource()==menuItem42)//添加管理员
		{    String m1=menuItem42.getText();
		   J1.setText("state: "+m1);
		   this.add(J1,BorderLayout.SOUTH);
			 System.out.println("客服");
			  Client tc = new Client();
		        tc.createUI();
		        tc.connect();
		        tc.createThread();
		}
		if(e.getSource()==menuItem43)//添加管理员
		{   String m1=menuItem43.getText();
		   J1.setText("state: "+m1);
		   this.add(J1,BorderLayout.SOUTH);
			new Reader_user_delete(t1.getText());
		}
		if(e.getSource()==menuItem6)//管理员添加用户
		{   String m1=menuItem6.getText();
		   J1.setText("state: "+m1);
		   this.add(J1,BorderLayout.SOUTH);
			JOptionPane.showMessageDialog(null,"版本:网上书店系统V2.0"+"\n"+"作者:张克成,李合会");
			
		}
		if(e.getSource()==menuItem63)//管理员添加用户
		{
			//JOptionPane.showMessageDialog(null,"版本:网上书店系统V2.0"+"\n"+"作者:张克成,李合会");
			String m1=menuItem63.getText();
			   J1.setText("state:帮助: "+m1);
			   this.add(J1,BorderLayout.SOUTH);
			   String url="http://localhost:8080/BookShop/front/index.jsp";
			Webpage w1=new Webpage(url);
			w1.openURL(url); 
		}
		if(e.getSource()==sonMenuItem6)//管理员添加用户
		{   String m1=sonMenuItem6.getText();
		   J1.setText("state:帮助: "+m1);
		   this.add(J1,BorderLayout.SOUTH);
			JOptionPane.showMessageDialog(null,"点击可进行图书的浏览，购买"+"\n","书籍服务",JOptionPane.PLAIN_MESSAGE);
			
		}
		if(e.getSource()==sonMenuItem61)//管理员添加用户
		{   String m1=sonMenuItem61.getText();
		   J1.setText("state:帮助: "+m1);
		   this.add(J1,BorderLayout.SOUTH);
			JOptionPane.showMessageDialog(null,"未完成订单：点击查询下单但未送达的书籍"+"\n"+"已完成订单：点击查询已购买过的书籍"+"\n","订单查询",JOptionPane.PLAIN_MESSAGE);
			
		}
		if(e.getSource()==sonMenuItem62)//管理员添加用户
		{   String m1=sonMenuItem62.getText();
		   J1.setText("state:帮助: "+m1);
		   this.add(J1,BorderLayout.SOUTH);
			JOptionPane.showMessageDialog(null,"修改密码：点击可修改用户密码"+"\n"+"联系客服：点击可与客服进行联系"+"\n"+"账户注销：点击会销毁账户"+"\n","账户服务",JOptionPane.PLAIN_MESSAGE);
			
		}
		
	}
	class MyJJJPanel extends JPanel{

	    public void paintComponent(Graphics g){

	        super.paintComponent(g);

	        Image image = new ImageIcon("C:/Users/DELL/Documents/李合会/jj.jpg").getImage();

	        g.drawImage(image, 10, 10, this);

	    }

	}
	

}

