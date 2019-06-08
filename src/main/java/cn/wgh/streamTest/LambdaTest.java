package cn.wgh.streamTest;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Test;

public class LambdaTest {
	@Test
	public void testName() throws Exception {
		List<String> list = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8");

		list.forEach(e -> System.out.println(e));
		list.forEach(e -> System.out.println(e + "拼接"));

		System.out.println("--------------------------");
		list.forEach(e -> {
			int parseInt = Integer.parseInt(e);
			if (parseInt % 2 == 0) {
				System.out.println(parseInt + "是双数");
			} else {
				System.out.println(parseInt + "是单数");
			}
		});
		System.out.println("--------------------------");

		Stream<String> filter = list.stream().filter(e -> list.contains("5"));
		Optional<String> findFirst = filter.findFirst();
		String string = findFirst.get();
		System.out.println(string);
	}

	@Test
	public void testName2() throws Exception {
		// Lambda可以引用类的成员变量与局部变量（如果这些变量不是final的话，它们会被隐含的转为final，这样效率更高）。
		// 例如，下面两个代码片段是等价的：
		String separator1 = ",";
		Arrays.asList("a", "b", "d").forEach((String e) -> System.out.print(e + separator1));
		// 和：
		System.out.println();
		System.out.println("--------------------------------");
		final String separator2 = ",";
		Arrays.asList("a", "b", "d").forEach((String e) -> System.out.print(e + separator2));
	}

	@Test
	public void testName3() throws Exception {
		// Lambda可能会返回一个值。返回值的类型也是由编译器推测出来的。
		// 如果lambda的函数体只有一行的话，那么没有必要显式使用return语句。
		// 下面两个代码片段是等价的：
		Arrays.asList("a", "b", "d").sort((e1, e2) -> e1.compareTo(e2));
		// 和：
		System.out.println();
		System.out.println("--------------------------------");
		Arrays.asList("a", "b", "d").sort((e1, e2) -> {
			int result = e1.compareTo(e2);
			return result;
		});
	}

	@Test
	public void testName4() throws Exception {
		// 第一种方法引用是构造器引用，它的语法是Class::new，或者更一般的Class< T >::new。请注意构造器没有参数。
		System.out.println("--------1");
		final Car car = Car.create(Car::new);
		final List<Car> cars = Arrays.asList(car);

		// 第二种方法引用是静态方法引用，它的语法是Class::static_method。请注意这个方法接受一个Car类型的参数。
		System.out.println("--------2");
		cars.forEach(Car::collide);

		// 第三种方法引用是特定类的任意对象的方法引用，它的语法是Class::method。请注意，这个方法没有参数。
		System.out.println("--------3");
		cars.forEach(Car::repair);

		// 最后，第四种方法引用是特定对象的方法引用，它的语法是instance::method。请注意，这个方法接受一个Car类型的参数
		System.out.println("--------4");
		final Car police = Car.create(Car::new);
		cars.forEach(police::follow);
	}

	/**
	 * Optional实际上是个容器：它可以保存类型T的值，或者仅仅保存null。 Optional提供很多有用的方法，这样我们就不用显式进行空值检测。
	 * 
	 * 我们下面用两个小例子来演示如何使用Optional类：一个允许为空值，一个不允许为空值。
	 * 
	 * @throws Exception
	 */
	@Test
	public void testName5() throws Exception {
		// 如果Optional类的实例为非空值的话，isPresent()返回true，否从返回false。
		// 为了防止Optional为空值，orElseGet()方法通过回调函数来产生一个默认值。
		// map()函数对当前Optional的值进行转化，然后返回一个新的Optional实例。
		// orElse()方法和orElseGet()方法类似，但是orElse接受一个默认值而不是一个回调函数。

		Optional<String> fullName = Optional.ofNullable(null);
		// Optional< String > fullName = Optional.ofNullable( "有值" );
		System.out.println("Full Name is set? " + fullName.isPresent());
		System.out.println("Full Name: " + fullName.orElseGet(() -> "[none]"));
		System.out.println(fullName.map(s -> "Hey " + s + "!").orElse("Hey Stranger!"));
	}

	
}
