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
//����Ա���
	JMenuItem menuItem = new JMenuItem("��ӹ���Ա");// �����˵������
	JMenu menu = new JMenu("����Ա����");// �����˵�����
	JMenuBar menuBar = new JMenuBar();// �����˵�������
	JMenuItem menuItem12 = new JMenuItem("�޸�����");// �����˵������
	JMenuItem menuItem31 = new JMenuItem("����û�");// �����˵������
	JMenuItem menuItem32 = new JMenuItem("ɾ���û�");// �����˵������
	JMenuItem menuItem33 = new JMenuItem("�û��������");// �����˵������
	JMenuItem menuItem34= new JMenuItem("�ͷ�����");// �����˵������
	JMenuItem menuItem41 = new JMenuItem("����鼮");// �����˵������
	JMenu menu4 = new JMenu("�鼮����");// �����˵�����
	JMenuItem menuItem42 = new JMenuItem("�鼮��Ϣ����");// �����˵������
	JMenu menu5 = new JMenu("��������");// �����˵�����
	JMenuItem menuItem5 = new JMenuItem("�û���������");// �����˵������
	JMenuItem menuItem6 = new JMenuItem("�汾��Ϣ");// �����˵������
	JMenuItem menuItem61 = new JMenuItem("��ҳ�����");
	//JMenu menu6 = new JMenu("����");// �����˵�����
	JMenu menu6 = new JMenu("����");// �����˵�����
	JMenu sonMenu6= new JMenu("����");// �����˵����Ӳ˵�����
	JMenuItem sonMenuItem6 = new JMenuItem("����Ա����");// �����Ӳ˵��Ĳ˵������

	JMenuItem sonMenuItem61 = new JMenuItem("�û�����");// �����Ӳ˵��Ĳ˵������

	
	JMenuItem sonMenuItem62 = new JMenuItem("�鼮����");// �����Ӳ˵��Ĳ˵������

	JMenuItem sonMenuItem63 = new JMenuItem("��������");// �����Ӳ˵��Ĳ˵������
	JTextArea J1=new JTextArea(1,10);
	private MyJJPanel panel = new MyJJPanel();
	private Container contentPane = this.getContentPane();
	
	public static void main(String args[]) {

	}
//����Աɾ��
	JMenuItem menuItem11 = new JMenuItem("ɾ������Ա");// �����˵������	

	public Manage_menu(String ming1)
	{

		super("����Ա: "+ming1);

		

		//setBounds(100, 100, 500, 375);
		setBounds(((Toolkit.getDefaultToolkit().getScreenSize().width)/2)-300, 10,1024,1000);
		//JMenuBar menuBar = new JMenuBar();// �����˵�������

		setJMenuBar(menuBar);// ���˵���������ӵ�����Ĳ˵�����

		menuBar.add(menu);// ���˵�������ӵ��˵���������
        menuBar.setSize(100,50);
		

		//JMenuItem menuItem = new JMenuItem("��ӹ���Ա");// �����˵������

		menuItem.addActionListener((ActionListener) this);// Ϊ�˵�������¼�������

		menu.add(menuItem);// ���˵��������ӵ��˵�������

		//JMenuItem menuItem11 = new JMenuItem("ɾ������Ա");// �����˵������

		menuItem11.addActionListener(this);// Ϊ�˵�������¼�������

		menu.add(menuItem11);// ���˵��������ӵ��˵�������
		
		//JMenuItem menuItem12 = new JMenuItem("�޸�����");// �����˵������

		menuItem12.addActionListener(this);// Ϊ�˵�������¼�������

		menu.add(menuItem12);// ���˵��������ӵ��˵�������
		

	
		JMenu menu3 = new JMenu("�û�����");// �����˵�����

		menuBar.add(menu3);// ���˵�������ӵ��˵���������

		

		//JMenuItem menuItem31 = new JMenuItem("����û�");// �����˵������

		menuItem31.addActionListener(this);// Ϊ�˵�������¼�������

		menu3.add(menuItem31);// ���˵��������ӵ��˵�������

		

		menuItem32.addActionListener(this);// Ϊ�˵�������¼�������

		menu3.add(menuItem32);// ���˵��������ӵ��˵�������
		
		

		menuItem33.addActionListener(this);// Ϊ�˵�������¼�������

		menu3.add(menuItem33);// ���˵��������ӵ��˵�������
		menuItem34.addActionListener(this);// Ϊ�˵�������¼�������

		menu3.add(menuItem34);// ���˵��������ӵ��˵�������

		//
		

		menuBar.add(menu4);// ���˵�������ӵ��˵���������

		

		

		menuItem41.addActionListener(this);// Ϊ�˵�������¼�������

		menu4.add(menuItem41);// ���˵��������ӵ��˵�������

		

		menuItem42.addActionListener(this);// Ϊ�˵�������¼�������

		menu4.add(menuItem42);// ���˵��������ӵ��˵�������
		
		
		
		
		

		menuBar.add(menu5);// ���˵�������ӵ��˵���������

		

		

		menuItem5.addActionListener(this);// Ϊ�˵�������¼�������

		menu5.add(menuItem5);// ���˵��������ӵ��˵�������		
		
		

		menuBar.add(menu6);// ���˵�������ӵ��˵���������

		

		menuItem6.addActionListener(this);// Ϊ�˵�������¼�������

		menu6.add(menuItem6);// ���˵��������ӵ��˵�������
		menuItem61.addActionListener(this);// Ϊ�˵�������¼�������

		menu6.add(menuItem61);// ���˵��������ӵ��˵�������

		

		

		menu6.add(sonMenu6);// ���Ӳ˵�������ӵ��ϼ��˵�������

		

		
		sonMenuItem6.addActionListener(this);// Ϊ�˵�������¼�������
		sonMenuItem61.addActionListener(this);
		sonMenuItem62.addActionListener(this);
		sonMenuItem63.addActionListener(this);

		//sonMenuItem63.addActionListener(new ItemListener());// Ϊ�˵�������¼�������
        sonMenu6.add(sonMenuItem6);// ���Ӳ˵��Ĳ˵��������ӵ��Ӳ˵�������
        sonMenu6.add(sonMenuItem61);
        sonMenu6.add(sonMenuItem62);
		sonMenu6.add(sonMenuItem63);// ���Ӳ˵��Ĳ˵��������ӵ��Ӳ˵�������
		J1.setText("state: ");
		getContentPane().add(panel,BorderLayout.CENTER);
		this.add(J1,BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==menuItem)//��ӹ���Ա
		{
			new Manager_registe();
			String m1=menuItem.getText();
			J1.setText("state: "+m1);
			this.add(J1,BorderLayout.SOUTH);
		}
		if(e.getSource()==menuItem11)//ɾ������Ա
		{
			String m1=menuItem11.getText();
			J1.setText("state: "+m1);
			this.add(J1,BorderLayout.SOUTH);
			new Manager_delete();
			
		}
		
		if(e.getSource()==menuItem12)//����Ա�޸�����
		{
			String m1=menuItem12.getText();
			J1.setText("state: "+m1);
			this.add(J1,BorderLayout.SOUTH);
			new Manager_change_password();
			
		}
		
		if(e.getSource()==menuItem31)//����Ա����û�
		{  String m1=menuItem31.getText();
			J1.setText("state: "+m1);
			this.add(J1,BorderLayout.SOUTH);
			new Manager_user_add();
			
		}
		if(e.getSource()==menuItem32)//����Ա����û�
		{  String m1=menuItem32.getText();
			J1.setText("state: "+m1);
			this.add(J1,BorderLayout.SOUTH);
			new Manager_user_delete();
			
		}
		if(e.getSource()==menuItem33)//����Ա����û�
		{   String m1=menuItem33.getText();
			J1.setText("state: "+m1);
			this.add(J1,BorderLayout.SOUTH);
			new Manager_change_user_password();
			
		}
		if(e.getSource()==menuItem34)//����Ա����û�
		{    String m1=menuItem34.getText();
		    J1.setText("state: "+m1);
		    this.add(J1,BorderLayout.SOUTH);
			 server ts = new server();
		        ts.createUI();
		        ts.connect();
		        ts.createThread();
			
		}
		if(e.getSource()==menuItem41)//����Ա����û�
		{   String m1=menuItem41.getText();
	        J1.setText("state: "+m1);
	       this.add(J1,BorderLayout.SOUTH);
			new Manager_add();
			
		}
		if(e.getSource()==menuItem42)//����Ա����û�
		{   String m1=menuItem42.getText();
	    J1.setText("state: "+m1);
	    this.add(J1,BorderLayout.SOUTH);
			Manager_manage frame = new Manager_manage("�鼮��Ϣ����");
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
		if(e.getSource()==menuItem5)//����Ա����û�
		{    String m1=menuItem5.getText();
	    J1.setText("state: "+m1);
	    this.add(J1,BorderLayout.SOUTH);
			Manager_handle frame = new Manager_handle("�û���������");
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
		if(e.getSource()==menuItem6)//����Ա����û�
		{   String m1=menuItem6.getText();
	    J1.setText("state: "+m1);
	    this.add(J1,BorderLayout.SOUTH);
			JOptionPane.showMessageDialog(null,"�汾:�������ϵͳV2.0"+"\n"+"����:�ſ˳�,��ϻ�");
			
		}
		if(e.getSource()==menuItem61)//����Ա����û�
		{   String m1=menuItem61.getText();
		   J1.setText("state:����: "+m1);
		   this.add(J1,BorderLayout.SOUTH);
		
		String url="http://localhost:8080/BookShop/manage/Login_M.jsp";
		Webpage w1=new Webpage(url);
		w1.openURL(url); 
			
		}
		
		if(e.getSource()==sonMenuItem6)//����Ա����û�
		{   String m1=sonMenuItem6.getText();
	        J1.setText("state: ����"+m1);
	        this.add(J1,BorderLayout.SOUTH);
			JOptionPane.showMessageDialog(null,"��ӹ���Ա:�����˺ź����룬�����Ӱ�ť"+"\n"+"ɾ������Ա:�����˺ţ����ɾ����ť"+"\n"+"�޸Ĺ���Ա����:�����˺������룬����޸İ�ť"+"\n","����Ա����",JOptionPane.PLAIN_MESSAGE);
			
		}
		if(e.getSource()==sonMenuItem61)//����Ա����û�
		{  String m1=sonMenuItem61.getText();
        J1.setText("state: ����"+m1);
        this.add(J1,BorderLayout.SOUTH);
			JOptionPane.showMessageDialog(null,"����û�:�����˺ź����룬�����Ӱ�ť"+"\n"+"ɾ���û�:�����˺ţ����ɾ����ť"+"\n"+"�޸��û�����:�����˺������룬����޸İ�ť"+"\n","�û�����",JOptionPane.PLAIN_MESSAGE);
			
		}
		if(e.getSource()==sonMenuItem62)//����Ա����û�
		{   String m1=sonMenuItem62.getText();
        J1.setText("state: ����"+m1);
        this.add(J1,BorderLayout.SOUTH);
			JOptionPane.showMessageDialog(null,"����鼮:���鼮��Ϣ¼��"+"\n"+"����ϴ���ťʵ��ͼƬ�ϴ���ͼƬ��ַC:\\Users\\DELL\\Documents\\��ϻ�\\"+"\n"+"��ѯ�����û������ѯ��ťʱ�����ݲ�ѯ��������� SQL ��䣬��ʾ���м���ı����У�����ѯ�Ľ��չʾ�� JTable �С�"+"\n"+"�޸ģ��û��ɱ༭ĳ����Ԫ�񣬱༭��Ϻ󣬱��ָõ�Ԫ���ѡ��״̬��Ȼ�����޸İ�ť���Ϳ��Խ����ݿ��ж�Ӧ��¼�Ķ�Ӧ�ֶθ���Ϊ��ǰ��Ԫ���ֵ��"+"\n"+
					"ɾ�����û���ѡ��ĳһ�У����ɾ����ť����ɴ����ݿ���ɾ��������¼��ͬʱ������ʾ��"+"\n","ͼ�����",JOptionPane.PLAIN_MESSAGE);
			
			
		}
		if(e.getSource()==sonMenuItem63)//����Ա����û�
		{   String m1=sonMenuItem63.getText();
            J1.setText("state: ����"+m1);
            this.add(J1,BorderLayout.SOUTH);
			JOptionPane.showMessageDialog(null,"��ӣ�����¼�¼ʱ����ÿ���ֶ����뵽��Ӧ�Ĳ�ѯ���У���ѡ���Ƿ�ѡû�й�ϵ�������Ӱ�ť���ͻὫ�ü�¼��ӵ����ݿ��У�ͬʱ���� JTable��"+"\n"+"��ѯ��������Ա�����ѯ��ťʱ�����ݲ�ѯ��������� SQL ��䣬��ʾ���м���ı����У�����ѯ�Ľ��չʾ�� JTable �С�"+"\n"+"�޸ģ�����Ա�ɱ༭ĳ����Ԫ�񣬱༭��Ϻ󣬱��ָõ�Ԫ���ѡ��״̬��Ȼ�����޸İ�ť���Ϳ��Խ����ݿ��ж�Ӧ��¼�Ķ�Ӧ�ֶθ���Ϊ��ǰ��Ԫ���ֵ��"+"\n"+
					"ɾ��������Ա��ѡ��ĳһ�У��������ť������������������ͬʱ������ʾ��"+"\n","��������",JOptionPane.PLAIN_MESSAGE);
			
		}
	}

	

	

}
class MyJJPanel extends JPanel{

    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Image image = new ImageIcon("C:/Users/DELL/Documents/��ϻ�/bb.jpg").getImage();

        g.drawImage(image, 10, 10, this);

    }

}