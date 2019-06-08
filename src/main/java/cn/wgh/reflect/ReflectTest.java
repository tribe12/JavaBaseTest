package cn.wgh.reflect;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

public class ReflectTest {
	
	@Test
	public void testName() throws Exception {
		System.out.println(Integer.TYPE);//int
		System.out.println(Integer.class);//class java.lang.Integer
	}
	
	/**
	 * 利用反射获得类的所有方法
	 * 
	 * @throws Exception
	 */
	@Test
	public void clazzmethods() throws Exception {
		// User user = new User();
		// Class<?> clazz = Class.forName("java.lang.String");
		Class<?> clazz = Class.forName("cn.wgh.reflect.User");
//		Class<User> clazz =  User.class;
		Method[] methods = clazz.getDeclaredMethods();
		for (Method methed : methods) {
			System.out.println(methed);
			System.out.println(methed.getName());
		}
	}

	/**
	 * 利用反射获得类的所有成员变量
	 * 
	 * @throws Exception
	 */
	@Test
	public void clazzfields() throws Exception {
//		Class<?> clazz = Class.forName("java.lang.String");
//		Class<?> clazz = Class.forName("cn.wgh.reflect.User");
		Class<User> clazz =  User.class;
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field);
			System.out.println(field.getName());
		}
	}

	@Test
	public void testTest() throws Exception {
		// 获取字节码文件对象
//		Class<User> clazz = User.class;
		User usero = new User();
//		Class<? extends User> clazz = usero.getClass();
		Class<User> clazz = (Class<User>) usero.getClass();
		
		// 1.获取所有公共字段(包括继承)
		System.out.println("------------获取所有公共字段(包括继承)-----------");
		Field[] fs1 = clazz.getFields();
		for (Field f : fs1) {
			System.out.println(f.getName());
		}
		// 2.获取所有(包括继承)
		System.out.println("------------获取所有(包括继承)-----------");
		Field[] fs2 = clazz.getDeclaredFields();
		for (Field f : fs2) {
			System.out.println(f.getName());
		}
		
		
		//3.获取单个共有字段
		System.out.println("------------获取单个共有字段-----------");
//		Field f3=clazz.getField("phone");//没有的话或报错：java.lang.NoSuchFieldException: phone
//		System.out.println(f3);
	

		//3.获取单个私有字段
		System.out.println("------------获取单个私有字段-----------");
		Field f4 = clazz.getDeclaredField("phone");//没有的话或报错：java.lang.NoSuchFieldException: phone
		System.out.println(f4.getName());
	
		//为字段设置值--获取字段的值
		System.out.println("------------为字段设置值--获取字段的值-----------");
		//如果是私有 需要设置访问权限 
		f4.setAccessible(true);
		User user=clazz.newInstance();
		f4.set(user, "110");
		String phone=(String) f4.get(user);
		System.out.println(phone);
		
		System.out.println("-----------------------");
		User user2 = new User();
		user2.setId("007");
		user2.setName("周星星");
		user2.setAge(20);
		user2.setPhone("13066662222");
		String phone2 = (String) f4.get(user2);
		System.out.println(phone2);
	}
	
}
