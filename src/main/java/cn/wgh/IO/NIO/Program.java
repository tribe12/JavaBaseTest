package cn.wgh.IO.NIO;
import java.io.*;  
import java.nio.*;  
import java.nio.channels.*;

import org.junit.Test;  
  
public class Program {  
	@Test
	public void testNIORead() throws Exception {
        FileInputStream fin = new FileInputStream("F:\\javatest\\NIOTest\\test.txt");  

        // 获取通道  
        FileChannel fc = fin.getChannel();  
          
        // 创建缓冲区  
        ByteBuffer buffer = ByteBuffer.allocate(1024);  
          
        // 读取数据到缓冲区  
        fc.read(buffer);  
          
        buffer.flip();  
          
        while (buffer.remaining()>0) {  
            byte b = buffer.get();  
//            System.out.print(((char)b));  
            System.out.print(b);  
        }  
          
        fin.close();  
    }  
	
	
	private static final byte message[] = { 83, 111, 109, 101, 32, 98, 121, 116, 101, 115, 46 };
//	private static final byte message[] = { 65, 66, 67, 68, 69 };

	@Test
	public void testNIOWrite() throws Exception {
		FileOutputStream fout = new FileOutputStream("F:\\javatest\\NIOTest\\testout.txt");  

		FileChannel fc = fout.getChannel();

		ByteBuffer buffer = ByteBuffer.allocate(1024);

		for (int i = 0; i < message.length; ++i) {
			buffer.put(message[i]);
		}

		buffer.flip();

		fc.write(buffer);

		fout.close();
	}
}