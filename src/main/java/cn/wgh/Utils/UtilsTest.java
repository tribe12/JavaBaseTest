package cn.wgh.Utils;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;

import cn.wgh.Utils.enumpag.FFmpegUtils;
import cn.wgh.Utils.enumpag.UrlUtils;
import cn.wgh.music.FFmpegUtil;

public class UtilsTest {
	/**
	 *将String转换成Xml文件
	 * @throws Exception
	 */
	@Test
	public void Xml2String() throws Exception {
		String XmlFileName = "E:/test/xmlTest/test.xml";
		String str = XmlUtil.xmlChangeString(XmlFileName);
		System.out.println(str);
	}
	
	
	
	/**
	 *将String转换成Xml文件
	 * @throws Exception
	 */
	@Test
	public void String2Xml() throws Exception {
		String str = "hello";
		String XmlFileName = "E:/test/xmlTest/Xmltest.xml";
		XmlUtil.strChangeXML(str,XmlFileName);
	}
	
	
	
	/**
	 * java 从网络Url中下载文件
	 * @throws Exception
	 */
	@Test
	public void testUrlUtil() throws Exception {
//		  UrlUtil.downLoadFromUrl("http://101.95.48.97:8005/res/upload/interface/apptutorials/manualstypeico/6f83ce8f-0da5-49b3-bac8-fd5fc67d2725.png",  
//                  "百度.jpg","d:/resource/images/diaodiao/country/");  
		  UrlUtil.downLoadFromUrl("http://echat-sit.oss-cn-hangzhou.aliyuncs.com/echat_sit/Attachment/582a6e428e824138ef3b7d48",  
				  "录音文件.amr","E:/test/musicTest/");  
	}
	
	
	
	/**
	 * 从网上下载文件，再转成MP3格式
	 */
	@Test
	public void URL2File2mp3() throws Exception {
		UUID uuid = UUID.randomUUID();
		String url = "http://echat-sit.oss-cn-hangzhou.aliyuncs.com/echat_sit/Attachment/582a6e428e824138ef3b7d48";
		String sourceFile = "录音"+uuid+".amr";
		String sourcePath = "E:/test/musicTest/amr/";  
		String webroot ="E:/Java/eclipse-jee-mars-2-win32-x86_64/eclipse/workspace/Base/BaseTest_M/src/main/voiceFile/soft/";
		String targetPath = "E:/test/musicTest/mp3/";  
		//下载文件保存指定路径
		UrlUtil.downLoadFromUrl(url, sourceFile, sourcePath);
		//转成mp3格式保存到指定路径
		FFmpegUtil.toMp3(webroot, sourcePath, targetPath, sourceFile);
		
		String mp3PathFlie = FFmpegUtil.getMp3PathFlie();
		System.err.println("mp3文件路径："+mp3PathFlie);
	}
	
	@Test
	public void testToMP3() throws Exception {
		String webroot ="E:/Java/eclipse-jee-mars-2-win32-x86_64/eclipse/workspace/Base/BaseTest_M/src/main/voiceFile/soft/";
		String sourcePath ="E:/test/musicTest/m4a/";
		String targetPath ="E:/test/musicTest/mp3/";
		String sourceFile ="不再犹豫.m4a";
		String mp3PathFlie = FFmpegUtils.INSTANCE.toMp3(webroot, sourcePath, targetPath, sourceFile);
		System.err.println(mp3PathFlie);

	}
	
	

	/**
	 * 从网上下载文件，再转成MP3格式
	 * 使用下载的默认名字
	 */
	@Test
	public void URL2File2mp3_() throws Exception {
		String url = "http://echat-sit.oss-cn-hangzhou.aliyuncs.com/echat_sit/Attachment/582a6e428e824138ef3b7d48";
		String sourcePath = "E:/test/musicTest/amr/";  
		String webroot ="E:/Java/eclipse-jee-mars-2-win32-x86_64/eclipse/workspace/Base/BaseTest_M/src/main/voiceFile/soft/";
		String targetPath = "E:/test/musicTest/mp3/";  
		//下载文件保存指定路径
		UrlUtil urlUtil = new UrlUtil();
		urlUtil.downLoadFromUrl(url, null, sourcePath);
		String sourceFile = urlUtil.getDownloadFileName();
		//转成mp3格式保存到指定路径
		FFmpegUtil ffmpegUtil = new FFmpegUtil();
		ffmpegUtil.toMp3(webroot, sourcePath, targetPath, sourceFile);
		
		String mp3PathFlie = ffmpegUtil.getMp3PathFlie();
		System.err.println("mp3文件路径："+mp3PathFlie);
	}
	
	
	
	/**
	 * 从网上下载文件，再转成MP3格式
	 * 使用下载的默认名字
	 */
	@Test
	public void URL2File2mp3_2() throws Exception {
//		下载地址
		//amr格式 
		String url = "http://echat-sit.oss-cn-hangzhou.aliyuncs.com/echat_sit/Attachment/582a6e428e824138ef3b7d48";
		//caf格式
		url = "http://echat-sit.oss-cn-hangzhou.aliyuncs.com/echat_sit/Attachment/5835697a8e824138ef3e8341";
		//wav格式
		url = "http://echat-sit.oss-cn-hangzhou.aliyuncs.com/echat_sit/Attachment/58356ac08e824138ef3e8405";
		
//		源文件存放路径
		String sourcePath = "E:/test/musicTest/amr/";  
//		项目地址，ffmpeg安装地址
		String webroot ="E:/Java/eclipse-jee-mars-2-win32-x86_64/eclipse/workspace/Base/BaseTest_M/src/main/voiceFile/soft/";
//		转换后文件存放路径
		String targetPath = "E:/test/musicTest/mp3/";  

		String downLoadFileName = UrlUtils.INSTANCE.downLoadFromUrl(url, null, sourcePath);
		
		String mp3PathFlie = FFmpegUtils.INSTANCE.toMp3(webroot, sourcePath, targetPath, downLoadFileName);
		System.out.println("downLoadFileName:"+downLoadFileName);
		System.out.println("mp3PathFlie:"+mp3PathFlie);
	}
	
	
	
}
