package cn.wgh.json.intTest;

import static org.junit.Assert.*;

import java.util.Random;
import java.util.Scanner;

import org.junit.Test;

public class RandomTest {
	@Test
	public void test1() throws Exception {
		Random r = new Random(); // 随机种子
		System.out.println(r.nextInt());
		System.out.println(r.nextInt());
		System.out.println(r.nextInt());
		System.out.println(r.nextInt());
		System.out.println(r.nextInt(10));
		System.out.println(r.nextInt(10));
		System.out.println(r.nextInt(20));
		System.out.println(r.nextInt(20));
	}
	
	@Test
	public void ScannerTest() throws Exception {
		System.out.print("输入:");
		Scanner input = new Scanner(System.in);
		System.out.println("输出:"+input.nextLine());
	}
	
}
