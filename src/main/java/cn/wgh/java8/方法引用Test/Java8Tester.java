package cn.wgh.java8.方法引用Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Java8Tester {
	
	@Test
	public void testName() throws Exception {
		List<String> names = new ArrayList<String>();

		names.add("Google");
		names.add("Runoob");
		names.add("Taobao");
		names.add("Baidu");
		names.add("Sina");

		names.forEach(System.out::println);
	}

	@Test
	public void testName2() throws Exception {
//		构造器引用：它的语法是Class::new，或者更一般的Class< T >::new实例如下：
		final Car car = Car.create( Car::new );
		final List< Car > cars = Arrays.asList( car );
		
//		静态方法引用：它的语法是Class::static_method，实例如下：
		cars.forEach( Car::collide );

//		特定类的任意对象的方法引用：它的语法是Class::method实例如下：
		cars.forEach( Car::repair );

//		特定对象的方法引用：它的语法是instance::method实例如下：
		final Car police = Car.create( Car::new );
		cars.forEach( police::follow );
	}

}