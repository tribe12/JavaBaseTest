package cn.wgh.StringTest;

import static org.junit.Assert.*;

import java.util.Random;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class UUIDTest {
	@Test
	public void testName() throws Exception {
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid);//6cf61edb-7de2-4c2d-a0c4-56c03e4702f9
		System.out.println(uuid.toString());//6cf61edb-7de2-4c2d-a0c4-56c03e4702f9
	}
	
	@Test
	public void testName2() throws Exception {
		for (int i = 0; i < 128; i++) {
			UUID uuid = UUID.randomUUID();
			System.out.println(uuid);
		}
	}
	
	@Test
	public void testName_() throws Exception {
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid);//6cf61edb-7de2-4c2d-a0c4-56c03e4702f9
		System.out.println(uuid.toString());//6cf61edb-7de2-4c2d-a0c4-56c03e4702f9
		String replace = uuid.toString().replaceAll("-", "");
		System.out.println(replace);
	}
	
	
	@Test
	public void 产生6位随机数() throws Exception {
		UUID uuid = UUID.randomUUID();
		String replace = uuid.toString().replaceAll("-", "");
		String psw = replace.substring(0, 6);
		System.out.println("uuid:"+uuid);
		System.out.println("replace:"+replace);
		System.out.println("psw:"+psw);
	}

	@Test
	public void getRandomStr() throws Exception {
		int length = 6;
		String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		System.out.println(sb);
	}
	
	//必须有数字和大写和小写
	@Test
	public void getRandomStr2() throws Exception {
		int length = 6/2;
		String base_A = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String base_a = "abcdefghijklmnopqrstuvwxyz";
		String base_1 = "1234567890";
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		while (sb.length()<length || sb.length()==length ) {
			sb.append(base_A.charAt(random.nextInt(base_A.length())));
			sb.append(base_a.charAt(random.nextInt(base_a.length())));
			sb.append(base_1.charAt(random.nextInt(base_1.length())));
		}
		System.out.println(sb);
	}
	
	
	//必须有数字和大写和小写
		@Test
		public void getRandomStr3() throws Exception {
			int length = 6/2;
			Random random = new Random();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < length; i++) {
				getRandom_A(random,sb);
				getRandom_a(random,sb);
				getRandom_1(random,sb);
			}
			System.out.println(sb);
		}
		
		
		public void getRandom_A(Random random ,StringBuilder sb){
			String base_A = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			sb.append(base_A.charAt(random.nextInt(base_A.length())));
		}
		public void getRandom_a(Random random ,StringBuilder sb){
			String base_a = "abcdefghijklmnopqrstuvwxyz";
			sb.append(base_a.charAt(random.nextInt(base_a.length())));
		}
		public void getRandom_1(Random random ,StringBuilder sb){
			String base_1 = "1234567890";
			sb.append(base_1.charAt(random.nextInt(base_1.length())));
		}
	
}
