package cn.wgh.IO.NIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.junit.Test;

public class TestChannel {
	@Test
	public void testRead() throws Exception {
		File file = new File("F:\\javatest\\NIOTest\\test.txt");
		FileInputStream fis = new FileInputStream(file);
		FileChannel fc = fis.getChannel();

		ByteBuffer bb = ByteBuffer.allocate(35);
		fc.read(bb);
		bb.flip();

		while (bb.hasRemaining()) {
			System.out.print((char) bb.get());
		}
		bb.clear();
		fc.close();
	}

	@Test
	public void testWrite() throws Exception {
		File file = new File("F:\\javatest\\NIOTest\\testout.txt");
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		FileChannel fc = raf.getChannel();
		
		ByteBuffer bb = ByteBuffer.allocate(20);
		
		String str = "abcdefghij1234567890";
		bb.put(str.getBytes());
		bb.flip();
		
		fc.write(bb);
		
		bb.clear();
		fc.close();
	}
}
