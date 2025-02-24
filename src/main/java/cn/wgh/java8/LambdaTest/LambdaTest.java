package cn.wgh.java8.LambdaTest;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Test;

import cn.wgh.java8.LambdaTest.Java8Tester.GreetingService;
import cn.wgh.java8.LambdaTest.Java8Tester.MathOperation;

/**
 * 可选类型声明：不需要声明参数类型，编译器可以统一识别参数值。
 * 可选的参数圆括号：一个参数无需定义圆括号，但多个参数需要定义圆括号。
 * 可选的大括号：如果主体包含了一个语句，就不需要使用大括号。
 * 可选的返回关键字：如果主体只有一个表达式返回值则编译器会自动返回值，大括号需要指定明表达式返回了一个数值。
 * 
 * @author wgh
 *
 */

/*
 * // 1. 不需要参数,返回值为 5 () -> 5
 * // 2. 接收一个参数(数字类型),返回其2倍的值 x -> 2 * x
 * // 3. 接受2个参数(数字),并返回他们的差值 (x, y) -> x – y
 * // 4. 接收2个int型整数,返回他们的和 (int x, int y) -> x + y
 * // 5. 接受一个 string 对象,并在控制台打印,不返回任何值(看起来像是返回void) (String s) -> System.out.print(s)
 */

public class LambdaTest {
	@Test
	public void testName() throws Exception {
		Java8Tester tester = new Java8Tester();

		// 类型声明
		MathOperation addition = (int a, int b) -> a + b;

		// 不用类型声明
		MathOperation subtraction = (a, b) -> a - b;

		// 大括号中的返回语句
		MathOperation multiplication = (int a, int b) -> {
			return a * b;
		};

		// 没有大括号及返回语句
		MathOperation division = (int a, int b) -> a / b;

		System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
		System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
		System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
		System.out.println("10 / 5 = " + tester.operate(10, 5, division));

		// 不用括号
		GreetingService greetService1 = message -> System.out.println("Hello " + message);

		// 用括号
		GreetingService greetService2 = (message) -> System.out.println("Hello " + message);

		greetService1.sayMessage("Runoob");
		greetService2.sayMessage("Google");
	}

	final static String salutation = "Hello! ";
	@Test
	public void testName2() throws Exception {
		/**
		 * lambda 表达式只能引用标记了 final 的外层局部变量， 这就是说不能在 lambda
		 * 内部修改定义在域外的局部变量，否则会编译错误。
		 */
		GreetingService greetService1 = message -> System.out.println(salutation + message);
		greetService1.sayMessage("Runoob");
	}
	
	
	
	
	
	
	public interface Converter<T1, T2> {
        void convert(int i);
    }
	
	@Test
	public void testName3() throws Exception {
		final int num = 1;
		Converter<Integer, String> s = (param) -> System.out.println(String.valueOf(param + num));
	
		s.convert(2); // 输出结果为 3
		
		
	}
	
	
}
