package cn.wgh.booleanTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class BooleanTest {
	@Test
	public void testName() throws Exception {
		boolean flag = false;
		System.out.println(""+flag);
	}
	
	
	
	@Test
	public void testName2() throws Exception {
		String str1 = "";
		String str2 = null;
		
		System.out.println("str1==null结果:"+str1==null);
		System.out.println("str1==''结果:"+str1=="");
		System.out.println("str2==null结果:"+str2==null);
		System.out.println("str2==''结果:"+str2=="");
		
		System.out.println("str1.equals(null)结果:"+str1.equals(null));
		System.out.println("str1.equals('')结果:"+str1.equals(""));
		
		System.out.println("''.equals(str2)结果:"+"".equals(str2));
	}
	
	
	
	
}
