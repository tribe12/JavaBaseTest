package cn.wgh.Utils.enumpag;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.apache.commons.lang3.StringUtils;


public enum UrlUtils {
	INSTANCE;
	/** 
     * @param urlStr url下载地址
     * @param fileName 命名要保存的文件名
     * @param savePath 要保存的文件路径
	 * @return 下载文件名称（fileName为null返回默认文件名，否则返回自定义文件名fileName）
	 * @throws IOException
	 */
	public String downLoadFromUrl(String urlStr, String fileName, String savePath) throws IOException {
//		String encode = URLEncoder.encode(urlStr, "UTF-8");
		String encode = URLDecoder.decode(urlStr, "UTF-8");
		System.err.println("encode:"+encode);
		URL url = new URL(encode);   
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();   
        //设置超时间为3秒  
        conn.setConnectTimeout(3*1000);  
//        //防止屏蔽程序抓取而返回403错误  
//        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");  
        if(StringUtils.isEmpty(fileName)){
        	String content_Disposition = conn.getHeaderField("Content-Disposition");
        	content_Disposition= new String(content_Disposition.replaceAll(" ", "").getBytes("UTF-8"), "ISO8859-1");
        	String decode = URLDecoder.decode(content_Disposition, "UTF-8");
        	fileName = decode.substring(decode.lastIndexOf("'") + 1);
        	System.err.println("content_Disposition:"+content_Disposition);
        }
        System.err.println("fileName:"+fileName);
        //得到输入流  
        InputStream inputStream = conn.getInputStream();    
        //获取自己数组  
        byte[] getData = readInputStream(inputStream);      
  
        //文件保存位置  
        File saveDir = new File(savePath);  
        if(!saveDir.exists()){  
            saveDir.mkdir();  
        }  
        System.err.println("File.separator:"+File.separator);
        File file = new File(saveDir+File.separator+fileName);      
        FileOutputStream fos = new FileOutputStream(file);       
        fos.write(getData);   
        if(fos!=null){  
            fos.close();    
        }  
        if(inputStream!=null){  
            inputStream.close();  
        }  
        System.out.println("info:"+url+" download success!");
		return fileName;   
  
    }  
  
  
  
    /** 
     * 从输入流中获取字节数组 
     * @param inputStream 
     * @return 
     * @throws IOException 
     */  
    public static  byte[] readInputStream(InputStream inputStream) throws IOException {    
        byte[] buffer = new byte[1024];    
        int len = 0;    
        ByteArrayOutputStream bos = new ByteArrayOutputStream();    
        while((len = inputStream.read(buffer)) != -1) {    
            bos.write(buffer, 0, len);    
        }    
        bos.close();    
        return bos.toByteArray();    
    }   
    
  
}
