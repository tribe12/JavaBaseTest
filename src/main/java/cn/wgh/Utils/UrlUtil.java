package cn.wgh.Utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;

import org.apache.commons.lang3.StringUtils;
/**
 * 从网络Url中下载文件 
 * @author guohui.wang
 *
 */
public class UrlUtil {
	private static UrlUtil urlUtil = new UrlUtil();
	public UrlUtil(){
		super();
	}
	/**
	 * 终止mp3文件路径地址
	 */
	private static String downloadFileName;
	/** 
     * @param urlStr url下载地址
     * @param fileName 命名要保存的文件名
     * @param savePath 要保存的文件路径
     * @throws IOException 
     */  
    public static void  downLoadFromUrl(String urlStr,String fileName,String savePath) throws IOException{  
        URL url = new URL(urlStr);   
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();   
                //设置超时间为3秒  
        conn.setConnectTimeout(3*1000);  
        String Content_Disposition = conn.getHeaderField("Content-Disposition");
//        //防止屏蔽程序抓取而返回403错误  
//        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");  
        Content_Disposition= new String(Content_Disposition.replaceAll(" ", "").getBytes("UTF-8"), "ISO8859-1");
        System.err.println("Content_Disposition:"+Content_Disposition);
        String decode = URLDecoder.decode(Content_Disposition, "UTF-8");
        downloadFileName = decode.substring(decode.lastIndexOf("'") + 1);
        System.err.println("fileName:"+fileName);
        if(StringUtils.isEmpty(fileName)){
        	fileName = downloadFileName;
        }
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
    
    
    public static String getDownloadFileName(){
    	return downloadFileName;
    }
  
    public static UrlUtil getInstance() {
		return urlUtil;
	}
    
    
//    public static void main(String[] args) {  
//        try{  
//            downLoadFromUrl("http://101.95.48.97:8005/res/upload/interface/apptutorials/manualstypeico/6f83ce8f-0da5-49b3-bac8-fd5fc67d2725.png",  
//                    "百度.jpg","d:/resource/images/diaodiao/country/");  
//        }catch (Exception e) {  
//            // TODO: handle exception  
//        }  
//    }
}
