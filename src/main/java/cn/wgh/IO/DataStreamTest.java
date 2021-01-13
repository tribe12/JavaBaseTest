package cn.wgh.IO;

import org.junit.Test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;


/**
 * 数据输入/输出流
 * Created by wgh on 2021/1/11.
 */
public class DataStreamTest {
    /**
     * 使用writeUTF()方法写入，再通过readUTF()方法读回后显示正常；
     * 而writeChars()和writeBytes()方法写入字符串后，再读取回来就不容易了
     *
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {
        try {
            //创建FileOutputStream对象
            FileOutputStream fos = new FileOutputStream("word.txt");
            //创建DataOutputStream对象
            DataOutputStream dos = new DataOutputStream(fos);
            //写入磁盘文件数据
            dos.writeUTF("使用writeUTF()方法写入数据；");
            dos.writeChars("使用writeChars()方法写入数据；");
            dos.writeBytes("使用writeBytes()方法写入数据；");
            dos.close();

            //创建FileInputStream对象
            FileInputStream fis = new FileInputStream("word.txt");
            //创建DataInputStream对象
            DataInputStream dis = new DataInputStream(fis);
            //将文件数据输出
            System.out.println(dis.readUTF());
            System.out.println(dis.readChar());
            System.out.println(dis.readByte());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
