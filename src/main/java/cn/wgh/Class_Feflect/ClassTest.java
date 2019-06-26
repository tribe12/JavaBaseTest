package cn.wgh.Class_Feflect;

import org.junit.Test;

public class ClassTest {
	@Test
	public void testName() throws Exception {
		/**
		 * 三种获得Class实例的方法 （获得类）
		 * 1.Class.forName(全限定名)
		 * 2.类型.class
		 * 3.对象.getClass()
		 */
		
		Class class1 = Class.forName("java.lang.String");
		Class class2 = String.class;
		Class class3 = "str".getClass();
		
		System.out.println(class1);
		System.out.println(class2);
		System.out.println(class3);
		
		System.out.println(class1 == class2);
		System.out.println(class1 == class3);
		System.out.println(class1.equals(class2));
		System.out.println(class1.equals(class3));
	}
	
	
	
	@Test
	public void testName2() throws Exception {
		/**
		 * 
		 */
		
		Class class1 = int[].class;
		
		int[] is = new int[10];
		Class class2 = is.getClass();
		
		int[] is2 = new int[100];
		Class class3 = is.getClass();
		
		int[][] is3 = new int[100][10];
		Class class4 = is3.getClass();
		
		System.out.println(class1);
		System.out.println(class2);
		System.out.println(class3);
		System.out.println(class4);
		System.out.println("------------------");
		System.out.println(class1 == class2);
		System.out.println(class1 == class3);
		System.out.println(class1 == class4);
	}
	
	
	@Test
	public void testName3() throws Exception {
		/**
		 * 基本类型
		 */
		Class class1 = int.class;
		Class class2 = Integer.class;
		Class class3 = Integer.TYPE;

		System.out.println(class1);
		System.out.println(class2);
		System.out.println(class3);
		System.out.println("------------------");
		System.out.println(class1 == class2);
		System.out.println(class1 == class3);
	}
	
}
