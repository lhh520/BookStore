
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
JMenuBar menuBar = new JMenuBar();// �����˵�������
JMenu menu = new JMenu("�鼮����");// �����˵�����
JMenuItem menuItem11 = new JMenuItem("�鼮���");
JMenu menu3 = new JMenu("������ѯ");// �����˵�����
JMenuItem menuItem31 = new JMenuItem("δ��ɶ���");// �����˵������
//JMenuItem menuItem31 = new JMenuItem("δ��ɶ���");// �����˵������
JMenuItem menuItem32 = new JMenuItem("����ɶ���");// �����˵������
JMenu menu4 = new JMenu("�˻�����");// �����˵�����
JMenuItem menuItem41 = new JMenuItem("�޸�����");// �����˵������

JMenuItem menuItem42 = new JMenuItem("��ϵ�ͷ�");// �����˵������
JMenuItem menuItem43 = new JMenuItem("�˻�ע��");// �����˵������
JMenu menu6 = new JMenu("����");// �����˵�����
JMenu sonMenu6= new JMenu("����");// �����˵����Ӳ˵�����
JMenuItem sonMenuItem6 = new JMenuItem("�鼮����");// �����Ӳ˵��Ĳ˵������
JMenuItem sonMenuItem61 = new JMenuItem("������ѯ");// �����Ӳ˵��Ĳ˵������

JMenuItem menuItem6 = new JMenuItem("�汾��Ϣ");// �����˵������
JMenuItem menuItem63 = new JMenuItem("��ҳ�����");// �����˵������
JMenuItem sonMenuItem62 = new JMenuItem("�˻�����");// �����Ӳ˵��Ĳ˵������

JMenuItem menuItem7 = new JMenuItem("վ������");// �����Ӳ˵��Ĳ˵������
JMenuItem sonMenuItem71 = new JMenuItem("������");// �����Ӳ˵��Ĳ˵������

JMenuItem sonMenuItem72 = new JMenuItem("�Ա�");// �����˵������
JMenuItem sonMenuItem73 = new JMenuItem("����");// �����˵������
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

		super("�û�:"+name+",��ӭ��");

		t1.setText(name);

		setBounds(300, 90,1240,900);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		

		

		setJMenuBar(menuBar);// ���˵���������ӵ�����Ĳ˵�����

		

		

		menuBar.add(menu);// ���˵�������ӵ��˵���������


		// �����˵������

		menuItem11.addActionListener(this);// Ϊ�˵�������¼�������

		menu.add(menuItem11);// ���˵��������ӵ��˵�������

		menuBar.add(menu3);// ���˵�������ӵ��˵���������

		menuItem31.addActionListener(this);// Ϊ�˵�������¼�������

		menu3.add(menuItem31);// ���˵��������ӵ��˵�������

		

		menuItem32.addActionListener(this);// Ϊ�˵�������¼�������

		menu3.add(menuItem32);// ���˵��������ӵ��˵�������
		
	
		//
		

		menuBar.add(menu4);// ���˵�������ӵ��˵���������

		

		

		menuItem41.addActionListener(this);// Ϊ�˵�������¼�������

		menu4.add(menuItem41);// ���˵��������ӵ��˵�������


		menuItem42.addActionListener(this);// Ϊ�˵�������¼�������

		menu4.add(menuItem42);// ���˵��������ӵ��˵�������
		

		menuItem43.addActionListener(this);// Ϊ�˵�������¼�������

		menu4.add(menuItem43);// ���˵��������ӵ��˵�������
		
		
		
		
		menuBar.add(menu6);// ���˵�������ӵ��˵���������

		menuItem6.addActionListener( this);// Ϊ�˵�������¼�������

		menu6.add(menuItem6);// ���˵��������ӵ��˵�������
		menuItem63.addActionListener( this);// Ϊ�˵�������¼�������

		menu6.add(menuItem63);// ���˵��������ӵ��˵�������
		

		

		menu6.add(sonMenu6);// ���Ӳ˵�������ӵ��ϼ��˵�������

		

		

		sonMenuItem6.addActionListener(this);// Ϊ�˵�������¼�������

		sonMenu6.add(sonMenuItem6);// ���Ӳ˵��Ĳ˵��������ӵ��Ӳ˵�������
		
		

		sonMenuItem61.addActionListener(this);// Ϊ�˵�������¼�������

		sonMenu6.add(sonMenuItem61);// ���Ӳ˵��Ĳ˵��������ӵ��Ӳ˵�������
		

		sonMenuItem62.addActionListener(this);// Ϊ�˵�������¼�������

		sonMenu6.add(sonMenuItem62);// ���Ӳ˵��Ĳ˵��������ӵ��Ӳ˵�������
		J1.setText("state: ");
		getContentPane().add(panel,BorderLayout.CENTER);
		this.add(J1,BorderLayout.SOUTH);
		
}


	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==menuItem11)//��ӹ���Ա
		{   String m1=menuItem11.getText();
		   J1.setText("state: "+m1);
		   this.add(J1,BorderLayout.SOUTH);
			
			Reader_query frame = new Reader_query(t1.getText());
		        try {
					frame.connectToDB();
				} catch (ClassNotFoundException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
		        
		        frame.setMinimumSize(new Dimension(750, 500));
		        frame.setVisible(true);
		        frame.setResizable(false);
			
		}
		if(e.getSource()==menuItem31)//��ӹ���Ա
		{   String m1=menuItem31.getText();
		   J1.setText("state: "+m1);
		   this.add(J1,BorderLayout.SOUTH);
			new Reader_unfinished(t1.getText());
			
		}
		if(e.getSource()==menuItem32)//��ӹ���Ա
		{   String m1=menuItem32.getText();
		   J1.setText("state: "+m1);
		   this.add(J1,BorderLayout.SOUTH);
			new Reader_finished(t1.getText());
			
		}
		if(e.getSource()==menuItem41)//��ӹ���Ա
		{    String m1=menuItem41.getText();
		   J1.setText("state: "+m1);
		   this.add(J1,BorderLayout.SOUTH);
			 new Manager_change_user_password();
			
		}
		if(e.getSource()==menuItem42)//��ӹ���Ա
		{    String m1=menuItem42.getText();
		   J1.setText("state: "+m1);
		   this.add(J1,BorderLayout.SOUTH);
			 System.out.println("�ͷ�");
			  Client tc = new Client();
		        tc.createUI();
		        tc.connect();
		        tc.createThread();
		}
		if(e.getSource()==menuItem43)//��ӹ���Ա
		{   String m1=menuItem43.getText();
		   J1.setText("state: "+m1);
		   this.add(J1,BorderLayout.SOUTH);
			new Reader_user_delete(t1.getText());
		}
		if(e.getSource()==menuItem6)//����Ա����û�
		{   String m1=menuItem6.getText();
		   J1.setText("state: "+m1);
		   this.add(J1,BorderLayout.SOUTH);
			JOptionPane.showMessageDialog(null,"�汾:�������ϵͳV2.0"+"\n"+"����:�ſ˳�,��ϻ�");
			
		}
		if(e.getSource()==menuItem63)//����Ա����û�
		{
			//JOptionPane.showMessageDialog(null,"�汾:�������ϵͳV2.0"+"\n"+"����:�ſ˳�,��ϻ�");
			String m1=menuItem63.getText();
			   J1.setText("state:����: "+m1);
			   this.add(J1,BorderLayout.SOUTH);
			   String url="http://localhost:8080/BookShop/front/index.jsp";
			Webpage w1=new Webpage(url);
			w1.openURL(url); 
		}
		if(e.getSource()==sonMenuItem6)//����Ա����û�
		{   String m1=sonMenuItem6.getText();
		   J1.setText("state:����: "+m1);
		   this.add(J1,BorderLayout.SOUTH);
			JOptionPane.showMessageDialog(null,"����ɽ���ͼ������������"+"\n","�鼮����",JOptionPane.PLAIN_MESSAGE);
			
		}
		if(e.getSource()==sonMenuItem61)//����Ա����û�
		{   String m1=sonMenuItem61.getText();
		   J1.setText("state:����: "+m1);
		   this.add(J1,BorderLayout.SOUTH);
			JOptionPane.showMessageDialog(null,"δ��ɶ����������ѯ�µ���δ�ʹ���鼮"+"\n"+"����ɶ����������ѯ�ѹ�������鼮"+"\n","������ѯ",JOptionPane.PLAIN_MESSAGE);
			
		}
		if(e.getSource()==sonMenuItem62)//����Ա����û�
		{   String m1=sonMenuItem62.getText();
		   J1.setText("state:����: "+m1);
		   this.add(J1,BorderLayout.SOUTH);
			JOptionPane.showMessageDialog(null,"�޸����룺������޸��û�����"+"\n"+"��ϵ�ͷ����������ͷ�������ϵ"+"\n"+"�˻�ע��������������˻�"+"\n","�˻�����",JOptionPane.PLAIN_MESSAGE);
			
		}
		
	}
	class MyJJJPanel extends JPanel{

	    public void paintComponent(Graphics g){

	        super.paintComponent(g);

	        Image image = new ImageIcon("C:/Users/DELL/Documents/��ϻ�/jj.jpg").getImage();

	        g.drawImage(image, 10, 10, this);

	    }

	}
	

}

