//ͼ��¼�����
import java.sql.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
public class Reader_detail extends JFrame implements ActionListener 
{   static    PreparedStatement ps=null;  
   static	Connection ct=null;
   static    ResultSet rs=null;
   static    Statement	 state=null;
   static String str;
	private static final long serialVersionUID = 1L;
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
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
	JPanel p13 = new JPanel();
	JTextArea ISBN = new JTextArea(1,15);
	JTextArea name = new JTextArea(1,15);
	JTextArea editor = new JTextArea(1,15);
	JTextArea date = new JTextArea(1,15);
	JTextArea press = new JTextArea(1,15);
	JTextArea price = new JTextArea(1,15);	
	JTextArea pox = new JTextArea(1,15);
	JTextArea introduction = new JTextArea();
	JTextArea tryread = new JTextArea();
	JTextArea Id = new JTextArea(1,15);
	JButton pay = new JButton("����");
	JButton Cancel = new JButton("�ر�");
	JLabel jl=new JLabel();
	JPanel jp5=new JPanel();
	
	public Reader_detail(String ISB,String ID) 
	{
		super(ISB+"ͼ����ϸ��Ϣ");
		//this.setSize(700, 800);
		//this.setLocation(300, 50);
		setBounds(((Toolkit.getDefaultToolkit().getScreenSize().width)/2)-300, ((Toolkit.getDefaultToolkit().getScreenSize().height)/2)-500,700,1200);
		this.setLayout(new GridLayout(15, 1));
//
		{
			// ��������������Դ����ʾ���ݵľ��崦��������ע����
			try
			{
			Class.forName("com.mysql.jdbc.Driver");
			final String URL="jdbc:mysql://localhost:3306/Bookstore?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(URL, "root", "itcast");			
			String select="select * from student where (ISBN = "+ISB+")";
			System.out.println(select);
			PreparedStatement pstm = conn.prepareStatement(select);
			// ִ�в�ѯ
			ResultSet rs = pstm.executeQuery();			
			rs = pstm.executeQuery();
			// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
			while(rs.next())
			{
			Id.setText(ID);
			ISBN.setText(rs.getString("ISBN"));
			name.setText(rs.getString("����"));
			editor.setText(rs.getString("����"));
			price.setText(rs.getString("�۸�"));
			press.setText(rs.getString("������"));
			introduction.setText(rs.getString("���"));
			tryread.setText(rs.getString("�Զ�����"));
           date.setText(rs.getString("��������") );		
			pox.setText(rs.getString("����"));			
            String picture=rs.getString("����ͼƬ");
            System.out.println("��ý��"+name);                   
            int intIndex = picture.indexOf("g");
            System.out.println(intIndex);
            String m4=picture.substring(23,intIndex+1);
            String m1="C:/Users/DELL/Documents/��ϻ�/";
            String m=m1+m4;
            System.out.println(m);//��Ƭ����ͼƬ��ַ��ԭ
    		ImageIcon img =new ImageIcon(m); 
    		img.setImage(img.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
            jl.setIcon(img);   
            jp5.setLayout(new GridLayout(1,1));
            jp5.setSize(200, 200);
            //jp5.setLayout(new FlowLayout().CENTER);
    	    jp5.add(jl);
    	    
			}
			
			}
			catch(ClassNotFoundException cnfe){
			JOptionPane.showMessageDialog(null,"����Դ����","����",JOptionPane.ERROR_MESSAGE);
			}
			catch(SQLException sqle){
			JOptionPane.showMessageDialog(null,"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
			}
			}		
	
		p1.add(new JLabel("ISBN��         "));
		p1.add(ISBN);
		p1.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(p1);

		p2.add(new JLabel("������         "));
		p2.add(name);
		p2.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(p2);

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
        
		
		
		jp5.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		this.add(jp5);
		p12.add(pay);
		pay.addActionListener(this);
		
		Cancel.addActionListener(this);
		p12.add(Cancel);
		this.add(p12);
		Cancel.addActionListener(this);

		this.setVisible(true);
	}
    
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == Cancel) 
		{
			System.exit(0);
		}
		else if (e.getSource() == pay)
		{
			//System.exit(0);
			new Reader_pay(ISBN.getText(),name.getText(),Id.getText(),price.getText());
		}
	}
	
	public static String fileChooser()
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
	public static void main(String args[])
	{   String ISB="4152";
	  
		new Reader_detail(ISB, ISB);
	}
}
