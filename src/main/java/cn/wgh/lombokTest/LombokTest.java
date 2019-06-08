package cn.wgh.lombokTest;

import org.junit.Test;

public class LombokTest {
	@Test
	public void testName() throws Exception {
		LombokUser user = new LombokUser(007,"周星星",20);
		System.out.println(user.getId());
		System.out.println(user.getName());
		System.out.println(user.getAge());
		System.out.println(user);
		user.setAge(21);
		System.out.println(user);
		
		LombokUser user2 = new LombokUser();
		user2.setId(007);
		user2.setName("周星星");
		user2.setAge(21);
		System.out.println(user.equals(user2));
	}
}
