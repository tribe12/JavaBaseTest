package cn.wgh.IO;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

/**
 * java写入文件的几种方法,供参考
 * 
 * @author wgh
 *
 */
public class WriteTest {
	/**
	 * 一、FileWritter写入文件 FileWritter,字符流写入字符到文件。
	 * 默认情况下，它会使用新的内容取代所有现有的内容，然而，当指定一个true（布尔）值作为FileWritter构造函数的第二个参数，
	 * 它会保留现有的内容，并追加新内容在文件的末尾。
	 * 
	 * 1. 替换所有现有的内容与新的内容：new FileWriter(file); 2. 保留现有的内容和附加在该文件的末尾的新内容：new
	 * FileWriter(file,true);
	 */

	@Test
	public void testFileWritter() throws Exception {
		try {
			String data = "This content will append to the end of the file,成功！";
			File file = new File("E:/test/ioTest/FileWritter.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fileWritter = new FileWriter(file, true);	// true = append file
			fileWritter.write(data);
			fileWritter.close();
			System.out.println("Done");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 二、BufferedWriter写入文件
	 *    缓冲字符（BufferedWriter ）是一个字符流类来处理字符数据。
	 *    不同于字节流（数据转换成字节），你可以直接写字符串，数组或字符数据保存到文件。
	 */
	@Test
	public void testBufferedWriter() throws Exception {
		try {
			   String content = "This is the content to write into file,成功！";
			   File file = new File("E:/test/ioTest/BufferedWriter.txt");
			   if (!file.exists()) {
			    file.createNewFile();
			   }
			   FileWriter fw = new FileWriter(file.getAbsoluteFile());
			   BufferedWriter bw = new BufferedWriter(fw);
			   bw.write(content);
			   bw.close();
			   System.out.println("Done");
			  } catch (IOException e) {
			   e.printStackTrace();
			  }
	}

	/**
	 * 三、FileOutputStream写入文件
	 * 文件输出流是一种用于处理原始二进制数据的字节流类。
	 * 为了将数据写入到文件中，必须将数据转换为字节，并保存到文件。	
	 */
	@Test
	public void testFileOutputStream() throws Exception {
		FileOutputStream fop = null;
		File file;
		String content = "This is the text content,成功！";
		try {
			file = new File("E:/test/ioTest/FileOutputStream.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
			fop = new FileOutputStream(file);
			// get the content in bytes
			byte[] contentInBytes = content.getBytes();
			fop.write(contentInBytes);
			fop.flush();
			fop.close();
			System.out.println("Done");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fop != null) {
					fop.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
