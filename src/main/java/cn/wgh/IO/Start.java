package cn.wgh.IO;

import java.io.*;  
import javax.swing.*;  
public class Start  
{  
    public static void main(String args[]) throws Exception{  
          
        //源文件，必须存在，路径可选  
//        File sf = new File("E:/个人资料/图片/美国队长.JPG");    
        File sf = new File("E:/个人资料/图片/头像.jpg");    
          
        //目的文件，因为要向其中写入，指定文件可以不存在，由程序生成  
        File df = new File("E:/个人资料/图片/头像test.jpg");  
        new ReadWriteGra(sf,df);  
        new UseGra(df);  
    }  
}  
  
class ReadWriteGra   
{  
    FileInputStream in = null;  
    FileOutputStream out = null;  
    public ReadWriteGra(File sourceFile,File destFile) throws Exception{  
        byte[] buf = new byte[1024];  
        int len = 0;  
        in = new FileInputStream(sourceFile);  
        out = new FileOutputStream(destFile,true);  
        while( (len = in.read(buf)) != -1 ){  
            out.write(buf,0,len);  
        }  
        out.close();  
    }  
}  
class UseGra extends JFrame  
{  
    public UseGra(File picFile) throws Exception{  
  
        this.setVisible(true);  
        this.setResizable(false);  
        this.setLayout(null);  
//        this.setBounds(600, 200, 400, 370);  
        this.setBounds(600, 130, 290, 308);  
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  
        JPanel p1 = (JPanel)this.getContentPane();  
        p1.setOpaque(false);  
        p1.setLayout(null);  
        InputStream is = new FileInputStream(picFile);  
        ByteArrayOutputStream baos = new ByteArrayOutputStream();  
        int b = 0;  
        while((b = is.read())!=-1){  
            baos.write(b);  
        }  
        ImageIcon image = new ImageIcon(baos.toByteArray());  
        JLabel background = new JLabel(image);  
        this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));  
        background.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());  
        JButton bt = new JButton("Test_Button");  
        p1.add(bt);  
        bt.setBounds(10,10,150,25);  
        validate();  
    }  
}