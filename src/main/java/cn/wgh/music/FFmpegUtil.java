package cn.wgh.music;

import cn.wgh.Utils.UrlUtil;

/**
 * ffmpeg格式转换工具
 * @author guohui.wang
 *
 */
public class FFmpegUtil {
	
	private static FFmpegUtil ffmpegUtil = new FFmpegUtil();
	/**
	 * 终止mp3文件路径地址
	 */
	private static String mp3PathFlie;
	/**
	 * 将上传的录音转为mp3格式 
	 * @param webroot    项目的根目录 以及 ffmpeg的地址
	 * @param sourcePath 源文件路径
	 * @param targetPath 目标文件路径
	 * @param sourceFile 源文件文件名称 
	 */
    public static void toMp3(String webroot, String sourcePath, String targetPath ,String sourceFile){  
        //File file = new File(sourcePath); 
    	String targetFile = sourceFile.substring(0,sourceFile.lastIndexOf("."))+".mp3";
        Runtime run = null;    
        try {    
            run = Runtime.getRuntime();    
            long start=System.currentTimeMillis();    
            //执行ffmpeg.exe,前面是ffmpeg.exe的地址，中间是需要转换的文件地址，后面是转换后的文件地址。-i是转换方式，意思是可编码解码，mp3编码方式采用的是libmp3lame  
           String command = webroot+"ffmpeg -i "+sourcePath+sourceFile+" -acodec libmp3lame "+targetPath+targetFile;
           System.out.println("command:"+command);
           Process p=run.exec(command);
            //释放进程    
            p.getOutputStream().close();    
            p.getInputStream().close();    
            p.getErrorStream().close();    
            p.waitFor();    
            long end=System.currentTimeMillis();  
            mp3PathFlie = targetPath+targetFile;
            System.out.println(sourceFile+" convert success, costs:"+(end-start)+"ms");    
            //删除原来的文件    
            //if(file.exists()){    
                //file.delete();    
            //}    
        } catch (Exception e) {    
            e.printStackTrace();    
        }finally{    
            //run调用lame解码器最后释放内存    
            run.freeMemory();    
        }  
        
    }
    public static String getMp3PathFlie(){
    	return mp3PathFlie;
    }
    
    public FFmpegUtil getInstance() {
		return ffmpegUtil;
	}

}
