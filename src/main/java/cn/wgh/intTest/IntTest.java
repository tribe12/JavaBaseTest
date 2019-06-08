package cn.wgh.intTest;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class IntTest {
	@Test
	public void nextIntTest() throws Exception {
		Random random = new Random();
		int nextInt = random.nextInt();
		System.out.println(nextInt);
	}
	
	@Test
	public void nextInt10Test() throws Exception {
		Random random = new Random();
		int nextInt = random.nextInt(10);
		System.out.println(nextInt);
	}
	
	
	@Test
	public void nextInt100Test() throws Exception {
		Random random = new Random();
		for (int i = 0; i < 100; i++) {
			int nextInt = random.nextInt(100);
			System.out.println(nextInt);
		}
	}
	
	
	
	@Test
	public void highestOneBitTest() throws Exception {
		for (int j = 0; j <= 100; j++) {
			int i = j;
			// HD, Figure 3-1
			i |= (i >> 1);
			i |= (i >> 2);
			i |= (i >> 4);
			i |= (i >> 8);
			i |= (i >> 16);
			System.out.println(i - (i >>> 1));
		}
		
		System.out.println("--------------------------");
		
		for (int j = 0; j >= -100; j--) {
			int i = j;
			// HD, Figure 3-1
			i |= (i >> 1);
			i |= (i >> 2);
			i |= (i >> 4);
			i |= (i >> 8);
			i |= (i >> 16);
			System.out.println(i - (i >>> 1));
		}
	}
	
	/**
	 * Java常量池详解之一道比较蛋疼的面试题:
	   http://www.cnblogs.com/DreamSea/archive/2011/11/20/2256396.html
	 * @throws Exception
	 */
	@Test
	public void 基本和包装类() throws Exception {
//		Integer i1 = 10;
//		Integer i2 = 10;
//		Integer i3 = 0;
//		Integer i4 = new Integer(10);
//		Integer i5 = new Integer(10);
//		Integer i6 = new Integer(0);
		
//		System.out.println("i1==i2:"+(i1==i2));//true
//		System.out.println("i1==i4:"+(i1==i4));//false
//		System.out.println("i4==i5:"+(i4==i5));//false
//		System.out.println("i1==(i2+i3):"+(i1==(i2+i3)));//true
//		System.out.println("i4==(i5+i6):"+(i4==(i5+i6)));//true

		Integer i1 = 400;
		Integer i2 = 400;
		Integer i3 = 0;
		Integer i4 = new Integer(400);
		Integer i5 = new Integer(400);
		Integer i6 = new Integer(0);
		
		System.out.println("i1==i2:"+(i1==i2));//false
		System.out.println("i1==i4:"+(i1==i4));//false
		System.out.println("i4==i5:"+(i4==i5));//false
		System.out.println("i1==(i2+i3):"+(i1==(i2+i3)));//true
		System.out.println("i4==(i5+i6):"+(i4==(i5+i6)));//true
		
	}
	
	@Test
	public void testname() throws Exception {
		System.out.println(Integer.MAX_VALUE*4);
	}
	
	
	@Test
	public void 循环次数() throws Exception {
		int size = 9;
		int a = 28;
		System.out.println(a/size);
		System.out.println(a%size);
		
		
		
		System.out.println(a/size+(a%size>0?1:0));
		
	}
	
	/**
	 * String 和 int 相互转换
	 */

	@Test
	public void StingInt() throws Exception {
		int i = 28;
		String iStr = String.valueOf(28);
		System.out.println(iStr);
		int iInt = Integer.parseInt(iStr);
		System.out.println(iInt);
	}
	
	
	@Test
	public void 比较大小() throws Exception {
		int a = 0;
		int b = 1;
		int c = 1;
		if(b>=c){
			System.out.println("b>=c");
		}
	}	
}
