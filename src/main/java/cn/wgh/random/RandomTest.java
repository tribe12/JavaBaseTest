package cn.wgh.random;

import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;

import org.junit.Test;

public class RandomTest {
	@Test
	public void testName1() throws Exception {
		double a = Math.random();
		double b = Math.random();
		Random r1 = new Random();
		Random r2 = new Random();
		int nextInt = r1.nextInt(10);
		int nextInt2 = r2.nextInt(10);
		System.out.println(a);
		System.out.println(b);
		System.out.println(nextInt);
		System.out.println(nextInt2);
	}
	
	
	@Test
	public void testName2() throws Exception {
		
		Random r =new Random(100);
		System.out.println(r.nextInt(20));
		
		Random r2 =new Random(100);
		System.out.println(r2.nextInt(20));
	}
	
	
	@Test
	public void testName3() throws Exception {
		SecureRandom secureRandom = new SecureRandom();
		int nextInt = secureRandom.nextInt(100);
		System.out.println(nextInt);
	}
	
	@Test
	public void testName4() throws Exception {
		System.out.println(new Date().getTime());
		System.out.println(new Random(new Date().getTime()).nextInt());
		System.out.println(new Date().getTime());
		System.out.println(new Random(new Date().getTime()).nextInt());
		System.out.println(new Random(new Date().getTime()).nextInt());
		System.out.println(new Random(new Date().getTime()).nextInt());
		System.out.println(new Random(new Date().getTime()).nextInt());
		System.out.println(new Random(new Date().getTime()).nextInt());
		System.out.println(new Random(new Date().getTime()).nextInt());
		System.out.println(new Random(new Date().getTime()).nextInt());
		System.out.println(new Random(new Date().getTime()).nextInt());
		System.out.println(new Random(new Date().getTime()).nextInt());
	}
}
