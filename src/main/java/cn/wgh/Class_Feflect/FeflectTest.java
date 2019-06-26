package cn.wgh.Class_Feflect;

import java.lang.reflect.Constructor;
/**
 * 反射 Test
 *
 */
import java.lang.reflect.Method;

import org.junit.Test;

import cn.wgh.Annotation.VIP;

public class FeflectTest {
	@Test
	public void testName() throws Exception {
		Class<Student> stuClass = Student.class;
		// 得到构造函数
		Constructor<Student> constructor = stuClass.getDeclaredConstructor(String.class);
		// 让我们在用反射时访问私有变量
		constructor.setAccessible(true);
		Student student = constructor.newInstance("小明");
		System.out.println(student);
	}

	@Test
	public void testName2() throws Exception {
//		Class userClass = Class.forName("cn.wgh.Class_Feflect.User");
		Class<User> userClass = User.class;

		// 得到构造函数
		Constructor<User> userCon = userClass.getDeclaredConstructor(String.class);
		// 破坏私有限制
		userCon.setAccessible(true);
		User user = userCon.newInstance("周星星");

		// 拿到sayHello方法
		Method sayHelloMethod = userClass.getDeclaredMethod("sayHello");
		// 破坏私有限制
		sayHelloMethod.setAccessible(true);

		// 拿到say方法
		Method sayMethod = userClass.getDeclaredMethod("say", String.class);
		// 破坏私有限制
		sayMethod.setAccessible(true);

		sayHelloMethod.invoke(user);
		sayMethod.invoke(user, "大家好，我是" + user.getName());

		
		//拿到所有方法
		Method[] methods = userClass.getMethods();
		System.out.println("------------所有的方法：");
		for (Method method : methods) {
			System.out.println(method.getName());
		}
		
		//拿到User类上的注解
		System.out.println("------------拿到User类上的注解：");
		VIP vip = userClass.getAnnotation(VIP.class);
		int value = vip.value();
		System.out.println("VIP级别:" + value);
	}
}
