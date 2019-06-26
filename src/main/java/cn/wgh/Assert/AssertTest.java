package cn.wgh.Assert;

import org.junit.Assert;
import org.junit.Test;



public class AssertTest {
	@Test
	public void testName() throws Exception {
		Assert.assertEquals("这个方法有错误", add(5,3), 8);
	}

	private int add(int i, int j) {
		return i + j + 1;
	}
}
