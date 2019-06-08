package cn.wgh.IO.uploading_download;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;

public class UploadingDownloadTest {
	@Test
	public void uploadingTest( ) throws Exception {
		System.err.println("hahahahahahaahahahahhahaha哈哈哈");
//		System.err.println(request);
		// FormFile file=manform.getFile();
		String uploadfileUrl = "E:/test/ioTest/file/source/测试文件.txt";
		String filePath = "E:/test/ioTest/file/uploadPath";
		File uploadfile = new File(uploadfileUrl);
		//对文件进行读操作 
		FileInputStream fis=new FileInputStream(uploadfile);  
		//对文件进行写操作
        FileOutputStream fos=new FileOutputStream(filePath);  
        byte[] buffer=new byte[1024];  
        int len=0;  
        //读入流，保存至byte数组
        while((len=fis.read(buffer))>0){  
            fos.write(buffer,0,len);  
        }  
        fos.close();  
        fis.close();  
	}
	
	
	@Test
	public void uploadHttpTest() throws Exception {
		String uploadfileUrl = "http://img.sj33.cn/uploads/allimg/200912/20091206235337582.jpg";
		String filePath = "E:/test/ioTest/file/uploadPath";
		File uploadfile = new File(uploadfileUrl);
		//对文件进行读操作 
		FileInputStream fis=new FileInputStream(uploadfile);  
		//对文件进行写操作
        FileOutputStream fos=new FileOutputStream(filePath);  
        byte[] buffer=new byte[1024];  
        int len=0;  
        //读入流，保存至byte数组
        while((len=fis.read(buffer))>0){  
            fos.write(buffer,0,len);  
        }  
        fos.close();  
        fis.close();  
	}
	
	
}
