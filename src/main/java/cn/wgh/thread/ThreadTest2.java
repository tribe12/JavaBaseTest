package cn.wgh.thread;

import static org.junit.Assert.*;

import org.junit.Test;

public class ThreadTest2 {
	@Test
	public void testName() throws Exception {
		
		Thread t = new Thread(new Runnable() {
			public void run() {
				System.err.println("-------------------------------");
				test2();
			}
		});
		t.start();
		
		for (int i = 0; i < 100; i++) {
			System.out.println("======" + i);
		}
		
	}

	private void test2() {
		for (int i = 0; i < 100; i++) {
			System.out.println("----------------------------------" + i);
		}

	}
	


}
