import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

 

public class Manage_menu extends JFrame  implements ActionListener
{


	private static final long serialVersionUID = 1L;
//管理员添加
	JMenuItem menuItem = new JMenuItem("添加管理员");// 创建菜单项对象
	JMenu menu = new JMenu("管理员管理");// 创建菜单对象
	JMenuBar menuBar = new JMenuBar();// 创建菜单栏对象
	JMenuItem menuItem12 = new JMenuItem("修改密码");// 创建菜单项对象
	JMenuItem menuItem31 = new JMenuItem("添加用户");// 创建菜单项对象
	JMenuItem menuItem32 = new JMenuItem("删除用户");// 创建菜单项对象
	JMenuItem menuItem33 = new JMenuItem("用户密码管理");// 创建菜单项对象
	JMenuItem menuItem34= new JMenuItem("客服服务");// 创建菜单项对象
	JMenuItem menuItem41 = new JMenuItem("添加书籍");// 创建菜单项对象
	JMenu menu4 = new JMenu("书籍管理");// 创建菜单对象
	JMenuItem menuItem42 = new JMenuItem("书籍信息管理");// 创建菜单项对象
	JMenu menu5 = new JMenu("订单管理");// 创建菜单对象
	JMenuItem menuItem5 = new JMenuItem("用户订单管理");// 创建菜单项对象
	JMenuItem menuItem6 = new JMenuItem("版本信息");// 创建菜单项对象
	JMenuItem menuItem61 = new JMenuItem("网页版测试");
	//JMenu menu6 = new JMenu("关于");// 创建菜单对象
	JMenu menu6 = new JMenu("关于");// 创建菜单对象
	JMenu sonMenu6= new JMenu("帮助");// 创建菜单的子菜单对象
	JMenuItem sonMenuItem6 = new JMenuItem("管理员管理");// 创建子菜单的菜单项对象

	JMenuItem sonMenuItem61 = new JMenuItem("用户管理");// 创建子菜单的菜单项对象

	
	JMenuItem sonMenuItem62 = new JMenuItem("书籍管理");// 创建子菜单的菜单项对象

	JMenuItem sonMenuItem63 = new JMenuItem("订单管理");// 创建子菜单的菜单项对象
	JTextArea J1=new JTextArea(1,10);
	private MyJJPanel panel = new MyJJPanel();
	private Container contentPane = this.getContentPane();
	
	public static void main(String args[]) {

	}
//管理员删除
	JMenuItem menuItem11 = new JMenuItem("删除管理员");// 创建菜单项对象	

	public Manage_menu(String ming1)
	{

		super("管理员: "+ming1);

		

		//setBounds(100, 100, 500, 375);
		setBounds(((Toolkit.getDefaultToolkit().getScreenSize().width)/2)-300, 10,1024,1000);
		//JMenuBar menuBar = new JMenuBar();// 创建菜单栏对象

		setJMenuBar(menuBar);// 将菜单栏对象添加到窗体的菜单栏中

		menuBar.add(menu);// 将菜单对象添加到菜单栏对象中
        menuBar.setSize(100,50);
		

		//JMenuItem menuItem = new JMenuItem("添加管理员");// 创建菜单项对象

		menuItem.addActionListener((ActionListener) this);// 为菜单项添加事件监听器

		menu.add(menuItem);// 将菜单项对象添加到菜单对象中

		//JMenuItem menuItem11 = new JMenuItem("删除管理员");// 创建菜单项对象

		menuItem11.addActionListener(this);// 为菜单项添加事件监听器

		menu.add(menuItem11);// 将菜单项对象添加到菜单对象中
		
		//JMenuItem menuItem12 = new JMenuItem("修改密码");// 创建菜单项对象

		menuItem12.addActionListener(this);// 为菜单项添加事件监听器

		menu.add(menuItem12);// 将菜单项对象添加到菜单对象中
		

	
		JMenu menu3 = new JMenu("用户管理");// 创建菜单对象

		menuBar.add(menu3);// 将菜单对象添加到菜单栏对象中

		

		//JMenuItem menuItem31 = new JMenuItem("添加用户");// 创建菜单项对象

		menuItem31.addActionListener(this);// 为菜单项添加事件监听器

		menu3.add(menuItem31);// 将菜单项对象添加到菜单对象中

		

		menuItem32.addActionListener(this);// 为菜单项添加事件监听器

		menu3.add(menuItem32);// 将菜单项对象添加到菜单对象中
		
		

		menuItem33.addActionListener(this);// 为菜单项添加事件监听器

		menu3.add(menuItem33);// 将菜单项对象添加到菜单对象中
		menuItem34.addActionListener(this);// 为菜单项添加事件监听器

		menu3.add(menuItem34);// 将菜单项对象添加到菜单对象中

		//
		

		menuBar.add(menu4);// 将菜单对象添加到菜单栏对象中

		

		

		menuItem41.addActionListener(this);// 为菜单项添加事件监听器

		menu4.add(menuItem41);// 将菜单项对象添加到菜单对象中

		

		menuItem42.addActionListener(this);// 为菜单项添加事件监听器

		menu4.add(menuItem42);// 将菜单项对象添加到菜单对象中
		
		
		
		
		

		menuBar.add(menu5);// 将菜单对象添加到菜单栏对象中

		

		

		menuItem5.addActionListener(this);// 为菜单项添加事件监听器

		menu5.add(menuItem5);// 将菜单项对象添加到菜单对象中		
		
		

		menuBar.add(menu6);// 将菜单对象添加到菜单栏对象中

		

		menuItem6.addActionListener(this);// 为菜单项添加事件监听器

		menu6.add(menuItem6);// 将菜单项对象添加到菜单对象中
		menuItem61.addActionListener(this);// 为菜单项添加事件监听器

		menu6.add(menuItem61);// 将菜单项对象添加到菜单对象中

		

		

		menu6.add(sonMenu6);// 将子菜单对象添加到上级菜单对象中

		

		
		sonMenuItem6.addActionListener(this);// 为菜单项添加事件监听器
		sonMenuItem61.addActionListener(this);
		sonMenuItem62.addActionListener(this);
		sonMenuItem63.addActionListener(this);

		//sonMenuItem63.addActionListener(new ItemListener());// 为菜单项添加事件监听器
        sonMenu6.add(sonMenuItem6);// 将子菜单的菜单项对象添加到子菜单对象中
        sonMenu6.add(sonMenuItem61);
        sonMenu6.add(sonMenuItem62);
		sonMenu6.add(sonMenuItem63);// 将子菜单的菜单项对象添加到子菜单对象中
		J1.setText("state: ");
		getContentPane().add(panel,BorderLayout.CENTER);
		this.add(J1,BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==menuItem)//添加管理员
		{
			new Manager_registe();
			String m1=menuItem.getText();
			J1.setText("state: "+m1);
			this.add(J1,BorderLayout.SOUTH);
		}
		if(e.getSource()==menuItem11)//删除管理员
		{
			String m1=menuItem11.getText();
			J1.setText("state: "+m1);
			this.add(J1,BorderLayout.SOUTH);
			new Manager_delete();
			
		}
		
		if(e.getSource()==menuItem12)//管理员修改密码
		{
			String m1=menuItem12.getText();
			J1.setText("state: "+m1);
			this.add(J1,BorderLayout.SOUTH);
			new Manager_change_password();
			
		}
		
		if(e.getSource()==menuItem31)//管理员添加用户
		{  String m1=menuItem31.getText();
			J1.setText("state: "+m1);
			this.add(J1,BorderLayout.SOUTH);
			new Manager_user_add();
			
		}
		if(e.getSource()==menuItem32)//管理员添加用户
		{  String m1=menuItem32.getText();
			J1.setText("state: "+m1);
			this.add(J1,BorderLayout.SOUTH);
			new Manager_user_delete();
			
		}
		if(e.getSource()==menuItem33)//管理员添加用户
		{   String m1=menuItem33.getText();
			J1.setText("state: "+m1);
			this.add(J1,BorderLayout.SOUTH);
			new Manager_change_user_password();
			
		}
		if(e.getSource()==menuItem34)//管理员添加用户
		{    String m1=menuItem34.getText();
		    J1.setText("state: "+m1);
		    this.add(J1,BorderLayout.SOUTH);
			 server ts = new server();
		        ts.createUI();
		        ts.connect();
		        ts.createThread();
			
		}
		if(e.getSource()==menuItem41)//管理员添加用户
		{   String m1=menuItem41.getText();
	        J1.setText("state: "+m1);
	       this.add(J1,BorderLayout.SOUTH);
			new Manager_add();
			
		}
		if(e.getSource()==menuItem42)//管理员添加用户
		{   String m1=menuItem42.getText();
	    J1.setText("state: "+m1);
	    this.add(J1,BorderLayout.SOUTH);
			Manager_manage frame = new Manager_manage("书籍信息管理");
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
		if(e.getSource()==menuItem5)//管理员添加用户
		{    String m1=menuItem5.getText();
	    J1.setText("state: "+m1);
	    this.add(J1,BorderLayout.SOUTH);
			Manager_handle frame = new Manager_handle("用户订单管理");
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
		if(e.getSource()==menuItem6)//管理员添加用户
		{   String m1=menuItem6.getText();
	    J1.setText("state: "+m1);
	    this.add(J1,BorderLayout.SOUTH);
			JOptionPane.showMessageDialog(null,"版本:网上书店系统V2.0"+"\n"+"作者:张克成,李合会");
			
		}
		if(e.getSource()==menuItem61)//管理员添加用户
		{   String m1=menuItem61.getText();
		   J1.setText("state:帮助: "+m1);
		   this.add(J1,BorderLayout.SOUTH);
		
		String url="http://localhost:8080/BookShop/manage/Login_M.jsp";
		Webpage w1=new Webpage(url);
		w1.openURL(url); 
			
		}
		
		if(e.getSource()==sonMenuItem6)//管理员添加用户
		{   String m1=sonMenuItem6.getText();
	        J1.setText("state: 帮助"+m1);
	        this.add(J1,BorderLayout.SOUTH);
			JOptionPane.showMessageDialog(null,"添加管理员:输入账号和密码，点击添加按钮"+"\n"+"删除管理员:输入账号，点击删除按钮"+"\n"+"修改管理员密码:输入账号新密码，点击修改按钮"+"\n","管理员管理",JOptionPane.PLAIN_MESSAGE);
			
		}
		if(e.getSource()==sonMenuItem61)//管理员添加用户
		{  String m1=sonMenuItem61.getText();
        J1.setText("state: 帮助"+m1);
        this.add(J1,BorderLayout.SOUTH);
			JOptionPane.showMessageDialog(null,"添加用户:输入账号和密码，点击添加按钮"+"\n"+"删除用户:输入账号，点击删除按钮"+"\n"+"修改用户密码:输入账号新密码，点击修改按钮"+"\n","用户管理",JOptionPane.PLAIN_MESSAGE);
			
		}
		if(e.getSource()==sonMenuItem62)//管理员添加用户
		{   String m1=sonMenuItem62.getText();
        J1.setText("state: 帮助"+m1);
        this.add(J1,BorderLayout.SOUTH);
			JOptionPane.showMessageDialog(null,"添加书籍:将书籍信息录入"+"\n"+"点击上传按钮实现图片上传，图片地址C:\\Users\\DELL\\Documents\\李合会\\"+"\n"+"查询：当用户点击查询按钮时，根据查询条件构造出 SQL 语句，显示在中间的文本框中，将查询的结果展示在 JTable 中。"+"\n"+"修改：用户可编辑某个单元格，编辑完毕后，保持该单元格的选中状态，然后点击修改按钮，就可以将数据库中对应记录的对应字段更新为当前单元格的值。"+"\n"+
					"删除：用户可选中某一行，点击删除按钮，便可从数据库中删除该条记录，同时更新显示框。"+"\n","图书管理",JOptionPane.PLAIN_MESSAGE);
			
			
		}
		if(e.getSource()==sonMenuItem63)//管理员添加用户
		{   String m1=sonMenuItem63.getText();
            J1.setText("state: 帮助"+m1);
            this.add(J1,BorderLayout.SOUTH);
			JOptionPane.showMessageDialog(null,"添加：添加新记录时，将每个字段输入到对应的查询框中，复选框是否勾选没有关系，点击添加按钮，就会将该记录添加到数据库中，同时更新 JTable。"+"\n"+"查询：当管理员点击查询按钮时，根据查询条件构造出 SQL 语句，显示在中间的文本框中，将查询的结果展示在 JTable 中。"+"\n"+"修改：管理员可编辑某个单元格，编辑完毕后，保持该单元格的选中状态，然后点击修改按钮，就可以将数据库中对应记录的对应字段更新为当前单元格的值。"+"\n"+
					"删除：管理员可选中某一行，点击处理按钮，本条订单将被处理，同时更新显示框。"+"\n","订单管理",JOptionPane.PLAIN_MESSAGE);
			
		}
	}

	

	

}
class MyJJPanel extends JPanel{

    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Image image = new ImageIcon("C:/Users/DELL/Documents/李合会/bb.jpg").getImage();

        g.drawImage(image, 10, 10, this);

    }

}