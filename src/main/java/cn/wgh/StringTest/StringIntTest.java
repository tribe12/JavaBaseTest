package cn.wgh.StringTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringIntTest {
	@Test
	public void testName() throws Exception {
		int loopTime = 50000000;
		Integer i = 0;
		long startTime = System.currentTimeMillis();
		for (int j = 0; j < loopTime; j++) {
			String str = String.valueOf(i);
		}
		System.out.println("String.valueOf()：" + (System.currentTimeMillis() - startTime) + "ms");

		startTime = System.currentTimeMillis();
		for (int j = 0; j < loopTime; j++) {
			String str = i.toString();
		}
		System.out.println("Integer.toString()：" + (System.currentTimeMillis() - startTime) + "ms");

		startTime = System.currentTimeMillis();
		for (int j = 0; j < loopTime; j++) {
			String str = i + "";
		}
		System.out.println("i + \"\"：" + (System.currentTimeMillis() - startTime) + "ms");
	}
	// 运行结果为：
	//
	// String.valueOf()：11ms Integer.toString()：5ms i + ""：25ms
	// 所以以后遇到把一个基本数据类型转为String的时候，优先考虑使用toString()方法。至于为什么，很简单：
	//
	// 1、String.valueOf()方法底层调用了Integer.toString()方法，但是会在调用前做空判断
	//
	// 2、Integer.toString()方法就不说了，直接调用了
	//
	// 3、i + “”底层使用了StringBuilder实现，先用append方法拼接，再用toString()方法获取字符串
	//
	// 三者对比下来，明显是2最快、1次之、3最慢
}
