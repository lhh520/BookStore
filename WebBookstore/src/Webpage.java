

import java.lang.reflect.Method;

 

//ʵ�ִ������������ָ����ַ���� 

public class Webpage 
{
	public String url;
	public Webpage(String url)
	{
		this.url=url;
		
	}

	public static void openURL(String url) {

		try {

			browse(url);

		} catch (Exception e) {

 

		}

	}

 

	private static void browse(String url) throws Exception {

		// ��ȡ����ϵͳ������

		String osName = System.getProperty("os.name", "");

		if (osName.startsWith("Mac OS")) {

			// ƻ���Ĵ򿪷�ʽ

			Class fileMgr = Class.forName("com.apple.eio.FileManager");

			Method openURL = fileMgr.getDeclaredMethod("openURL",new Class[] { String.class });

			openURL.invoke(null, new Object[] { url });

		} else if (osName.startsWith("Windows")) {

			// windows�Ĵ򿪷�ʽ��

			Runtime.getRuntime().exec(

					"rundll32 url.dll,FileProtocolHandler " + url);

		} else {

			// Unix or Linux�Ĵ򿪷�ʽ

			String[] browsers = { "firefox", "opera", "konqueror", "epiphany",

					"mozilla", "netscape" };

			String browser = null;

			for (int count = 0; count < browsers.length && browser == null; count++) {

				// ִ�д��룬��brower��ֵ��������

				// ������������̴����ɹ��ˣ�==0�Ǳ�ʾ����������

				if (Runtime.getRuntime()

						.exec(new String[] { "which", browsers[count] })

						.waitFor() == 0)

					browser = browsers[count];

				if (browser == null)

					throw new Exception("Could not find web browser");

				else

					// ���ֵ�������Ѿ��ɹ��ĵõ���һ�����̡�

					Runtime.getRuntime().exec(new String[] { browser, url });

			}

			// ������ ������

		}

	}

	public static void main(String[] args) {  

		// ������д�����ַ  
		String url="http://login.cup.edu.cn:802/srun_portal_pc_succeed.php";
		Webpage w1=new Webpage(url);
		w1.openURL(url);

	} 

}


