package cn.wgh.LongTest;

import org.junit.Test;

public class LongTest {
	@Test
	public void testName() throws Exception {
		System.out.println(Long.toHexString(13654));
	}
	
	
	@Test
	public void testName2() throws Exception {
		long l = 1l;
		if(l>0){
			System.out.println("l>0");
		}
		if(l>0l){
			System.out.println("l>0l");
		}		
	}
	
}
