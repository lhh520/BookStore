//图书录入界面
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
	JButton pay = new JButton("购买");
	JButton Cancel = new JButton("关闭");
	JLabel jl=new JLabel();
	JPanel jp5=new JPanel();
	
	public Reader_detail(String ISB,String ID) 
	{
		super(ISB+"图书详细信息");
		//this.setSize(700, 800);
		//this.setLocation(300, 50);
		setBounds(((Toolkit.getDefaultToolkit().getScreenSize().width)/2)-300, ((Toolkit.getDefaultToolkit().getScreenSize().height)/2)-500,700,1200);
		this.setLayout(new GridLayout(15, 1));
//
		{
			// 以下是连接数据源和显示数据的具体处理方法，请注意下
			try
			{
			Class.forName("com.mysql.jdbc.Driver");
			final String URL="jdbc:mysql://localhost:3306/Bookstore?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(URL, "root", "itcast");			
			String select="select * from student where (ISBN = "+ISB+")";
			System.out.println(select);
			PreparedStatement pstm = conn.prepareStatement(select);
			// 执行查询
			ResultSet rs = pstm.executeQuery();			
			rs = pstm.executeQuery();
			// 将查询获得的记录数据，转换成适合生成JTable的数据形式
			while(rs.next())
			{
			Id.setText(ID);
			ISBN.setText(rs.getString("ISBN"));
			name.setText(rs.getString("书名"));
			editor.setText(rs.getString("主编"));
			price.setText(rs.getString("价格"));
			press.setText(rs.getString("出版社"));
			introduction.setText(rs.getString("简介"));
			tryread.setText(rs.getString("试读内容"));
           date.setText(rs.getString("出版日期") );		
			pox.setText(rs.getString("分类"));			
            String picture=rs.getString("封面图片");
            System.out.println("获得结果"+name);                   
            int intIndex = picture.indexOf("g");
            System.out.println(intIndex);
            String m4=picture.substring(23,intIndex+1);
            String m1="C:/Users/DELL/Documents/李合会/";
            String m=m1+m4;
            System.out.println(m);//切片，将图片地址还原
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
			JOptionPane.showMessageDialog(null,"数据源错误","错误",JOptionPane.ERROR_MESSAGE);
			}
			catch(SQLException sqle){
			JOptionPane.showMessageDialog(null,"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
			}
			}		
	
		p1.add(new JLabel("ISBN：         "));
		p1.add(ISBN);
		p1.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(p1);

		p2.add(new JLabel("书名：         "));
		p2.add(name);
		p2.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(p2);

		p3.add(new JLabel("出版日期："));
		p3.add(date);
		p3.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(p3);
		
		p4.add(new JLabel("主编：         "));
		p4.add(editor);
		p4.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(p4);
		
		p5.add(new JLabel("出版社：     "));
		p5.add(press);
		p5.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(p5);

		p6.add(new JLabel("分类：          "));
		p6.setLayout(new FlowLayout(FlowLayout.LEFT));
		p6.add(pox);
		this.add(p6);

		p7.add(new JLabel("价格：         "));
		p7.add(price);
		p7.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(p7);

		p8.add(new JLabel("简介"));
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
		
		p10.add(new JLabel("试读内容"));
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
	//设置文件类型
	chooser.setFileFilter(filter);
	//打开选择器面板
	int returnVal = chooser.showOpenDialog(new JPanel()); 
	//保存文件从这里入手，输出的是文件名
	if(returnVal == JFileChooser.APPROVE_OPTION) 
	{
	System.out.println("你打开的文件是: " +
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
