

//图书录入界面
import java.sql.*;
import java.util.concurrent.TimeUnit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
public class Reader_pay extends JFrame implements ActionListener 
{   static    PreparedStatement ps=null;  
   static	Connection ct=null;
   static    ResultSet rs=null;
   static    Statement	 state=null;
   static    Statement	 state1=null;
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
	
	JTextArea ISBN = new JTextArea(1,15);
	JTextArea name = new JTextArea(1,15);
	JTextField editor = new JTextField(15);
	JTextArea date = new JTextArea(1,15);
	JTextField press = new JTextField(15);
	JTextArea price = new JTextArea(1,15);
	
	JCheckBox box = new JCheckBox();
	//JComboBox<String> pox = new JComboBox<String>(zv);
	JTextArea introduction = new JTextArea();
	JTextArea tryread = new JTextArea();
	JButton Comfir = new JButton("购买");
	JButton Cancel = new JButton("取消");
	JButton open = new JButton("上传");

	public Reader_pay(String ISB,String nam,String dat,String pric) 
	{   
		super("支付窗口");
		
		setBounds(((Toolkit.getDefaultToolkit().getScreenSize().width)/2)-300, ((Toolkit.getDefaultToolkit().getScreenSize().height)/2)-500,700,800);
		this.setLayout(new GridLayout(12, 1));

		p1.add(new JLabel("ISBN：         "));
		ISBN.setText(ISB);
		p1.add(ISBN);
		
		p1.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(p1);

		p2.add(new JLabel("书名：         "));
		name.setText(nam);
		p2.add(name);		
		p2.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(p2);

		p3.add(new JLabel("用户名：      "));
		date.setText(dat);
		p3.add(date);
		p3.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(p3);
		
		p4.add(new JLabel("数量：         "));
		p4.add(editor);
		p4.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(p4);
		
		p5.add(new JLabel("地址：        "));
		p5.add(press);
		p5.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(p5);
		
		p7.add(new JLabel("价格：         "));
		price.setText(pric);
		p7.add(price);
		p7.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(p7);

		p8.add(new JLabel("订单信息"));
		p9.add(introduction);
		introduction.setLineWrap(true);  
		introduction.setWrapStyleWord(true); 
		JScrollPane logTxtScrollPane = new JScrollPane(introduction);  
		logTxtScrollPane.setPreferredSize(new Dimension(600, 500)); 
		logTxtScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);  
		logTxtScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		logTxtScrollPane.setSize(150, 100);
		p9.add(logTxtScrollPane);
		p8.setLayout(new FlowLayout(FlowLayout.CENTER));
		//p9.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.add(p8);
		this.add(p9);		
		
		p12.add(Comfir);
		Comfir.addActionListener(this);
		p12.add(Cancel);
		Cancel.addActionListener(this);
		
		this.add(p12);

		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == Comfir)
		{   
			String str1 = ISBN.getText();//
			System.out.println(str1);
			String str2 = name.getText();//书名
			System.out.println(str2);
			String str3 = date.getText();//用户名
			String str4 = editor.getText();//数量
			String str5 = price.getText();
			String str6 = press.getText();//价格				
			introduction.setText("ISBN:  "+str1+"  书名:  "+str2+"  数量:  "+str4+"  价格:  "+str5+"  地址:  "+str6);
			
			try
			 {
				
				Class.forName("com.mysql.jdbc.Driver");
				final String url="jdbc:mysql://localhost:3306/bookstore?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
				 String user="root";
				 String password="itcast";
				 ct=DriverManager.getConnection( url,user,password);
				 state=ct.createStatement();	
				 state1=ct.createStatement();
				 String sql = "insert into 图书 values('"+str3+"','"+str1+"','"+str2+"','"+str4+"','"+str5+"','"+str6+"')";
				 int t1=Integer.parseInt(str4);
				 //String sql1="update 用户  set 密码 ='"+m+"'where 登录名='"+ming1+"';";
				 String sql1="select * from student where ISBN='"+str1+"';";
				 System.out.println(sql1);
				 PreparedStatement pstm = ct.prepareStatement(sql1);
				// 执行查询
				   ResultSet rs1 = pstm.executeQuery();
				  String ss="";
				//System.out.println(ss); 
				while(rs1.next())
				{
					ss=rs1.getString("库存");
				}
				System.out.println(ss);  
				 int t2=Integer.parseInt(ss);
				 System.out.println(t2-t1);
				 if((t2-t1)>0)
				 {String gg=String.valueOf(t2-t1);
				 System.out.println(gg);
				 String sql3="update student set 库存 ='"+gg+"' where ISBN='"+str1+"';";
				
				 System.out.println(sql3);
				 state1.executeUpdate(sql3);
				// JOptionPane.showMessageDialog(null, "密码修改成功");
				 
				 int result=state.executeUpdate(sql);
				 System.out.println(result);
				 UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");

			        new pay_baby().setVisible(true);}
			        
				 else    
			        
			        
				 { JOptionPane.showMessageDialog(null,"购买失败！库存不足，请联系店家",null,JOptionPane.ERROR_MESSAGE, null);}
			       /* TimeUnit.SECONDS.sleep(20);//秒
			        
			      JOptionPane.showMessageDialog(null, "已成功下单");*/
				
				 
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
		}
		if (e.getSource() == Cancel)
		{
			System.exit(0);
		}
	}
	
	
	public static void main(String args[]) {
		
		new Reader_pay("1112","522","52","52");
	}
}
