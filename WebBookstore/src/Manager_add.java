//ͼ��¼�����
import java.sql.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JOptionPane;
public class Manager_add extends JFrame implements ActionListener 
{   static    PreparedStatement ps=null;  
   static	Connection ct=null;
   static    ResultSet rs=null;
   static    Statement	 state=null;
   static String str;
	private static final long serialVersionUID = 1L;
	JPanel p1 = new JPanel();//�����пؼ�������壬���ָ�������
	JPanel p2 = new JPanel();
	JPanel p22=new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();
	JPanel p5 = new JPanel();
	JPanel p6 = new JPanel();
	JPanel p7 = new JPanel();
	JPanel p8 = new JPanel();
	JPanel p9 = new JPanel();
	JPanel p10 = new JPanel();
	JPanel p11 = new JPanel();
	JPanel p12 = new JPanel();
	String zv[] = { "������ѧ��", "��Ȼ��ѧ��", "����ѧ��","Ӧ��ѧ��","����ѧ��" };//�����˵����
	JTextField ISBN = new JTextField(15);
	JTextField name = new JTextField(15);
	JTextField editor = new JTextField(15);
	JTextField date = new JTextField(15);
	JTextField press = new JTextField(15);
	JTextField price = new JTextField(15);
	JTextField number= new JTextField(15);
	//JScrollPane jsp = new JScrollPane();
	JCheckBox box = new JCheckBox();
	JComboBox<String> pox = new JComboBox<String>(zv);
	JTextArea introduction = new JTextArea();
	JTextArea tryread = new JTextArea();
	JButton Comfir = new JButton("¼��");
	JButton Cancel = new JButton("ȡ��");
	JButton open = new JButton("�ϴ�");

	public Manager_add() 
	{
		super("ͼ����Ϣ¼�봰��");
		this.setSize(700, 800);
		this.setLocation(300, 50);
		this.setLayout(new GridLayout(15, 1));

		p1.add(new JLabel("ISBN��         "));
		p1.add(ISBN);
		p1.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(p1);

		p2.add(new JLabel("������         "));
		p2.add(name);
		p2.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(p2);
		p22.add(new JLabel("��棺         "));
		p22.add(number);
		p22.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(p22);

		p3.add(new JLabel("�������ڣ�"));
		p3.add(date);
		p3.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(p3);
		
		p4.add(new JLabel("���ࣺ         "));
		p4.add(editor);
		p4.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(p4);
		
		p5.add(new JLabel("�����磺     "));
		p5.add(press);
		p5.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(p5);

		p6.add(new JLabel("���ࣺ          "));
		p6.setLayout(new FlowLayout(FlowLayout.LEFT));
		p6.add(pox);
		this.add(p6);

		p7.add(new JLabel("�۸�         "));
		p7.add(price);
		p7.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(p7);

		p8.add(new JLabel("���"));
		p9.add(introduction);
		introduction.setLineWrap(true);  
		introduction.setWrapStyleWord(true); 
		JScrollPane logTxtScrollPane = new JScrollPane(introduction);  
		logTxtScrollPane.setPreferredSize(new Dimension(600, 500));  
		logTxtScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);  
		logTxtScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		p9.add(logTxtScrollPane);
		p8.setLayout(new FlowLayout(FlowLayout.CENTER));
		p9.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.add(p8);
		this.add(p9);
		
		p10.add(new JLabel("�Զ�����"));
		p11.add(tryread);
		tryread.setLineWrap(true); 
		tryread.setWrapStyleWord(true);
		JScrollPane logTxtScrollPane2 = new JScrollPane(tryread);  
		logTxtScrollPane2.setPreferredSize(new Dimension(600, 500));  
		logTxtScrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);  
		logTxtScrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		p11.add(logTxtScrollPane2);
		p10.setLayout(new FlowLayout(FlowLayout.CENTER));
		p11.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.add(p10);
		this.add(p11);
        
		p12.add(open);
		open.addActionListener(this);
		p12.add(Comfir);
		Comfir.addActionListener(this);
		p12.add(Cancel);
		Cancel.addActionListener(this);
		this.add(p12);

		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Comfir)
		{   
			String str1 = ISBN.getText();//
			System.out.println(str1);
			String str2 = name.getText();//����
			String str3 = date.getText();//����
			String str4 = str;//��ͼƬ��ַ�������ݿ⡣
			String str5 = editor.getText();
			String str6 = press.getText();
			String str7 = (String) pox.getSelectedItem();
			String str8 = price.getText();
			String str9 = introduction.getText();
			String str10 = tryread.getText();
			String store=number.getText();
			
			try
			 {
				
				Class.forName("com.mysql.jdbc.Driver");
				final String url="jdbc:mysql://localhost:3306/bookstore?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
				 String user="root";
				 String password="itcast";
				 ct=DriverManager.getConnection( url,user,password);
				 state=ct.createStatement();
				 String sql = "insert into student values('"+str1+"','"+str2+"','"+str5+"','"+str8+"','"+str6+"','"+str9+"','"+str10+"','"+str3+"', '"+str7+"','"+str4+"','"+store+"')";
				 int result=state.executeUpdate(sql);
				 System.out.println(result);
				 JOptionPane.showMessageDialog(null, "ͼ��¼��ɹ�");
				 
			 }
			 catch (Exception ee)
			 {
		            System.out.println("54");
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
		} else if (e.getSource() == Cancel) {
			System.exit(0);
		}
		else if (e.getSource() == open) {
			str=fileChooser();
		}
	}
	
	public static String fileChooser()//��ͼƬ��������ͼƬ��ַ
	{
	JFileChooser chooser = new JFileChooser();
	FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
	//�����ļ�����
	chooser.setFileFilter(filter);
	//��ѡ�������
	int returnVal = chooser.showOpenDialog(new JPanel()); 
	//�����ļ����������֣���������ļ���
	if(returnVal == JFileChooser.APPROVE_OPTION) 
	{
	System.out.println("��򿪵��ļ���: " +
	chooser.getSelectedFile().getName());
	str=chooser.getSelectedFile().getPath();
	System.out.println(str);

	}
	return str;
	}
	public static void main(String args[]) {
		new Manager_add();
	}
}
