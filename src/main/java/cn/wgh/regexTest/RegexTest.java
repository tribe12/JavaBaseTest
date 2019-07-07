package cn.wgh.regexTest;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class RegexTest {
	@Test
	public void testName() throws Exception {
		Pattern compile = Pattern.compile("12412");
		System.out.println(compile);
//		Pattern pattern = new Pattern("122", 0);
	}
	
	
	
	
	@Test
	public void testName2() throws Exception {
		// 验证电话和手机号码
		Pattern compile = Pattern.compile("(0\\d{2,3}-\\d{7,9})|(1[35789]\\d{9})");
		System.out.println(compile);
		Matcher matcher = compile.matcher("15208365789");
		boolean b = matcher.matches();
		System.out.println(b);
	}
	
	
	@Test
	public void testName3() throws Exception {
		// 验证邮箱
		Pattern compile = Pattern.compile("[\\w\\-]+@\\w+(\\.+[a-zA-Z]{2,4}){1,2}");
		Matcher matcher = compile.matcher("tribe12wgh@163.com");
//		Matcher matcher = compile.matcher("Tribe12wgh@sina.com.cn");
		boolean b = matcher.matches();
		System.out.println(b);
	}
	
	
	
	@Test
	public void testName4() throws Exception {
		Pattern compile = Pattern.compile("\\d+");
		Matcher matcher = compile.matcher("abc123###def456###tribe12wgh");
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
	}
	
	@Test
	public void testName5() throws Exception {
		Pattern compile = Pattern.compile("([a-z]+)(\\d+)");
		Matcher matcher = compile.matcher("abc123###def456###tribe12wgh");
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
	}
	
	
	@Test
	public void testName6() throws Exception {
		Pattern compile = Pattern.compile("([a-z]+)(\\d+)");
		Matcher matcher = compile.matcher("abc123###def456###tribe12wgh");
		while (matcher.find()) {
			System.out.println("---------------------");
			System.out.println(matcher.group());
			System.out.println(matcher.group(1));
			System.out.println(matcher.group(2));
		}
	}
	
	
	/**
	 *  替换
	 */
	@Test
	public void testName7() throws Exception {
		Pattern compile = Pattern.compile("\\d");
		Matcher matcher = compile.matcher("abc123def456tribe12wgh");
		String replace = matcher.replaceAll("*");
		System.out.println(replace);
	}
	
	
	/**
	 *  切割
	 */
	@Test
	public void testName8() throws Exception {
		String str = "abc123###def456###tribe12wgh";
		String[] split = str.split("\\d+");
		System.out.println(Arrays.toString(split));
	}
}
