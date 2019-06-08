package cn.wgh.thread;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class LingzaiThreadTest {
	/**
	 * 令仔学多线程系列（一）----同步工具类CountDownLatch
	 * 
	 * http://blog.csdn.net/zlts000/article/details/56831100
	 * 
	 * @throws Exception
	 */
	@Test
	public void 同步工具类CountDownLatch() throws Exception {
		final CountDownLatch countDownLatch = new CountDownLatch(5);
		final List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 5; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					// 调用不同的供应商
					list.add(otherGame());
					countDownLatch.countDown(); // 每new 一个Thread记得要减一。
				}
			}).start();
		}
		try {
			// countDownLatch.await();
			countDownLatch.await(10000, TimeUnit.MILLISECONDS); // 等待10秒（<小于平台要求的返回时间）
			// 后续处理
			System.out.println("-----------------------------------------------------");
			System.out.println(list);
			if (!list.isEmpty()) {
				System.out.println("最小值:" + Collections.min(list));
			} else {
				System.out.println("所有等待超过10秒,立即结束，没有获取到值。");
			}
			System.out.println("结束");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int otherGame() {
		int nextInt = 0;
		try {
			System.out.println("--其他子程序开始:" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
			Random random = new Random();
			int time = random.nextInt(20000);
			System.out.println("会耗时:" + time + "毫秒");
			Thread.sleep(time);//
			nextInt = random.nextInt(100);
			System.out.println("nextInt:" + nextInt);
			System.out.println("==其他子程序结束:" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return nextInt;
	}
}
