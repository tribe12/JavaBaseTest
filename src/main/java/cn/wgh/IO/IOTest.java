package cn.wgh.IO;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;

import org.junit.Test;

public class IOTest {
	/**
	 * 读取流的信息
	 * 
	 * @throws Exception
	 */
	@Test
	public void testName() throws Exception {
		File f = new File("E:/test/ioTest/hello.txt");
		Reader r = new FileReader(f);
		int b = 0;
		while ((b = r.read()) != -1) {
			System.out.print((char) b); // Hello world!
										// 你好！世界！
		}
		r.close();
	}

	/**
	 * 创建一个文件并写入内容
	 * 
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		FileOutputStream fop = null;
		File file = null;
		String content = "This is the text content , 我是外部写入的 ！";
		try {
			file = new File("E:/test/ioTest/FOPtest.txt");
			fop = new FileOutputStream(file);
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
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
		// 在把它读出来------------
		Reader r = null;
		r = new FileReader(file);
		int b = 0;
		while ((b = r.read()) != -1) {
			System.out.print((char) b);
		}
		r.close();
		// ---------------------
	}

	
	/**
	 * 使用BufferedReader和BufferedWriter来实现字符流的写入写出
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception {
		File file = new File("E:/test/ioTest/a.txt");//源文件
//		String b = "E:/test/ioTest/b.txt";//目标文件 方式1
		File b = new File("E:/test/ioTest/b.txt");//目标文件 方式2
		BufferedReader read = null;
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(b));//目标文件
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			read = new BufferedReader(new FileReader(file));
			String tempString = null;
			while ((tempString = read.readLine()) != null) {
				writer.append(tempString);
				writer.newLine();// 换行
				writer.flush();// 需要及时清掉流的缓冲区，万一文件过大就有可能无法写入了
			}
			read.close();
			writer.close();
			System.out.println("文件写入完成...");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Test
	//自己写的读文件写文件
	//写文件有中文乱码问题
	public void testmy() throws Exception {
		//找到文件名
		String ifileName = "E:/test/ioTest/iflie.txt"; 
		String ofileName = "E:/test/ioTest/oflie.txt"; 
		//创建读入写出文件
		File ifile = new File(ifileName);
		File ofile = new File(ofileName);
		if (!ofile.exists()) {
			ofile.createNewFile();
		}
		Reader reader = new FileReader(ifile);
		FileOutputStream fop = new FileOutputStream(ofile);
		try {
			int b = 0;
			while((b = reader.read())!=-1){
				fop.write(b);
				fop.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (fop != null) {
				fop.close();
			}
		}
	}
	
	
	@Test
	public void testmy2() throws Exception {
		// 找到文件名
		String ifileName = "E:/test/ioTest/iflie.txt";
		String ofileName = "E:/test/ioTest/oflie.txt";
		// 创建读入写出文件
		File ifile = new File(ifileName);
		File ofile = new File(ofileName);
		
		FileInputStream fis = new FileInputStream(ifileName);
//		InputStreamReader ipsr = new InputStreamReader(fis);
//		BufferedReader br = new BufferedReader(ipsr);
		
		FileOutputStream fos = new FileOutputStream(ofile);
//		OutputStreamWriter opsw = new OutputStreamWriter(fos);
//		BufferedWriter bw = new BufferedWriter(opsw);
		String data;
//		while((data = br.readLine())!=null)
//		{
//			bw.write(data);
//			bw.flush();
//			bw.write(data);
//			bw.flush();
//		}
		int read ;
		while((read=fis.read())!=-1){
			fos.write(read);
			fos.flush();
		}
		fis.close();
		fos.close();
	}
	
	
	
	
	@Test
	public void testmy3() throws Exception {
		// 找到文件名
		String ifileName = "http://echat-sit.oss-cn-hangzhou.aliyuncs.com/echat_sit/Attachment/582a6e428e824138ef3b7d48";
		String ofileName = "E:/test/ioTest/mp3test.mp3";
		// 创建读入写出文件
		File ifile = new File(ifileName);
		File ofile = new File(ofileName);
//		InputStreamReader fis = new InputStreamReader();
		FileOutputStream fos = new FileOutputStream(ofile);
//		int read ;
//		while((read=fis.read())!=-1){
//			fos.write(read);
//			fos.flush();
//		}
//		fis.close();
//		fos.close();
	}
	
	
	
	
	@Test
	public void ReadFromFileTest1() throws Exception {
		String fileName = "E:/test/ioTest/a.txt";
		ReadFromFileUtils.readFileByBytes(fileName);
		
	}

	@Test
	public void AppendToFileTest1() throws Exception {
		String fileName = "C:/temp/newTemp.txt";
		String content = "new append!";
		// 按方法A追加文件
		AppendToFileUtil.appendMethodA(fileName, content);
		AppendToFileUtil.appendMethodA(fileName, "append end. \n");
		// 显示文件内容
		ReadFromFileUtils.readFileByLines(fileName);
		// 按方法B追加文件
		AppendToFileUtil.appendMethodB(fileName, content);
		AppendToFileUtil.appendMethodB(fileName, "append end. \n");
		// 显示文件内容
//		AppendToFileUtil.readFileByLines(fileName);
	}
	
	@Test
	public void fileInputStream() throws Exception {
		String fileUrl = "C:\\Users\\Lenovo\\Desktop\\导入test.xls";
		InputStream fileInputStream = null;
			fileInputStream = new FileInputStream(fileUrl);
	}
}
