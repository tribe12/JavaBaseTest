package cn.wgh.regexTest;

import static org.junit.Assert.*;

import java.util.regex.Pattern;

import org.junit.Test;

public class RegexTest {
	@Test
	public void testName() throws Exception {
		Pattern compile = Pattern.compile("12412");
		System.out.println(compile);
//		Pattern pattern = new Pattern("122", 0);
	}
}
