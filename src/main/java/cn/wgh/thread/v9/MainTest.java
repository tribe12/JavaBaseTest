package cn.wgh.thread.v9;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 并发库的应用
 * <p>
 * Created by wgh on 2021/4/13.
 */
public class MainTest {
    public static void main(String[] args) {
        //固定的线程池
        //ExecutorService threadPool = Executors.newFixedThreadPool(3);
        //有缓存的线程池
        // ExecutorService threadPool = Executors.newCachedThreadPool();
        //单一线程池
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("============ " + Thread.currentThread().getName() + " for task of ============ " + taskId + " ============");
                    for (int j = 0; j < 10; j++) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        System.out.println(Thread.currentThread().getName() + " is looping of === " + j + " === for task of === " + taskId);
                    }
                }
            });
        }

        System.out.println("all task have committed !");
        threadPool.shutdown();
    }
}
