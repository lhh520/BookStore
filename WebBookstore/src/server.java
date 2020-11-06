
import java.io.*;
import java.net.*;

import javax.swing.JFrame;

import java.awt.*;
import java.awt.event.*;

public class server {
    private ServerSocket ss;
    private Socket s;
    private DataInputStream dis;
    private DataOutputStream dos;
    private TextArea ta;
    private TextField tf;

    public static void main(String args[]) {
        server ts = new server();
        ts.createUI();
        ts.connect();
        ts.createThread();
    }

    public void connect() {
        try {
            ss = new ServerSocket(8888);
            s = ss.accept();
            dis = new DataInputStream(s.getInputStream());
            dos = new DataOutputStream(s.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            // 13701303436

        }
    }

    public void createUI() {
        JFrame f = new JFrame("店家");
        ta = new TextArea();
        tf = new TextField();
        Button send = new Button("send");
        Panel p = new Panel();
        p.setLayout(new BorderLayout());
        p.add(tf, "Center");
        p.add(send, "East");
        f.add(ta, "Center");
        f.add(p, "South");
        MyServerListener listener = new MyServerListener(this);
        send.addActionListener(listener);
        tf.addActionListener(listener);
        /*f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });*/
        f.setSize(400, 400);
        f.setVisible(true);
    }

    public void createThread() {
        MyServerReader reader = new MyServerReader(this);
        reader.start();
    }

    public void close() {
        try {
            dis.close();
            dos.close();
            s.close();
            ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public DataInputStream getDataInputStream() {
        return dis;
    }

    public DataOutputStream getDataOutputStream() {
        return dos;
    }

    public TextArea getTextArea() {
        return ta;
    }

    public TextField getTextField() {
        return tf;
    }
}

class MyServerListener implements ActionListener {
    private server server;

    public MyServerListener(server server) {
        this.server = server;
    }

    public void actionPerformed(ActionEvent e) {
        TextField tf = server.getTextField();
        String info = tf.getText();
        server.getTextArea().append("店家: " + info + "\n");
        try {
            server.getDataOutputStream().writeUTF(info);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        if (info.equals("bye")) {
            server.close();
            System.exit(0);
        }
        tf.setText("");
        tf.requestFocus();
    }
}

class MyServerReader extends Thread {
    private server server;

    public MyServerReader(server server) {
        this.server = server;
    }

    public void run() {
        String info;
        DataInputStream dis = server.getDataInputStream();
        TextArea ta = server.getTextArea();
        try {
            while (true) {
                info = dis.readUTF();
                ta.append("客户: " + info + "\n");
                if (info.equals("bye")) {
                    server.close();
                    System.exit(0);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}