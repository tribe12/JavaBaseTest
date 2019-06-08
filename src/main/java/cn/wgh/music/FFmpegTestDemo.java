package cn.wgh.music;

import static org.junit.Assert.*;

import org.junit.Test;

public class FFmpegTestDemo {
	@Test
	public void testName() throws Exception {
		
		String webroot ="E:/test/musicTest/soft/";
		String sourcePath ="ly.amr";
//		String webroot ="E:/Java/eclipse-jee-mars-2-win32-x86_64/eclipse/workspace/Base/BaseTest_M/src/main/java/cn/wgh/music/";
//		String sourcePath ="ly.amr";
//		String webroot ="E:/Java/eclipse-jee-mars-2-win32-x86_64/eclipse/workspace/Base/BaseTest_M/src/main/";
//		String sourcePath ="ly.amr";
		
		
		FFmpegUtilDemo.toMp3(webroot, sourcePath);
		
		
		/**
		 * command:E:/Java/eclipse-jee-mars-2-win32-x86_64/eclipse/workspace/Base/BaseTest_M/src/main/ffmpeg -i E:/Java/eclipse-jee-mars-2-win32-x86_64/eclipse/workspace/Base/BaseTest_M/src/main/ly.amr -acodec libmp3lame E:/Java/eclipse-jee-mars-2-win32-x86_64/eclipse/workspace/Base/BaseTest_M/src/main/ly.amr.mp3

		 */
	}
}
