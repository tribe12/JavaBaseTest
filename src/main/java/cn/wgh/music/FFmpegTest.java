package cn.wgh.music;

import static org.junit.Assert.*;

import org.junit.Test;

public class FFmpegTest {
	@Test
	public void testName() throws Exception {
		/**
		 * @param webroot    项目的根目录 以及 ffmpeg的地址
		 * @param sourcePath 源文件路径
		 * @param targetPath 目标文件路径
		 * @param sourceFile 源文件文件名称 
		 */
		String webroot ="E:/Java/eclipse-jee-mars-2-win32-x86_64/eclipse/workspace/Base/BaseTest_M/src/main/voiceFile/soft/";
		String sourcePath ="E:/Java/eclipse-jee-mars-2-win32-x86_64/eclipse/workspace/Base/BaseTest_M/src/main/voiceFile/";
		String targetPath ="E:/Java/eclipse-jee-mars-2-win32-x86_64/eclipse/workspace/Base/BaseTest_M/src/main/voiceFile/";
//		String sourceFile ="ly.amr";
//		String sourceFile ="最好的我们.m4a";
		String sourceFile ="说散就散.m4a";
//		String sourceFile ="年轮说-杨丞琳.aac";
		FFmpegUtil.toMp3(webroot, sourcePath, targetPath, sourceFile);
	}
}
