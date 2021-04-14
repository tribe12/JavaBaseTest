package cn.wgh.thread.v8;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 了解java.util.concurrent.atomic包中类
 * <p>
 * Created by wgh on 2021/4/13.
 */
public class MainTest {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                atomicInteger.addAndGet(1);
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(Thread.currentThread().getName() + " --> " + atomicInteger);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                atomicInteger.addAndGet(10);

//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(Thread.currentThread().getName() + " --> " + atomicInteger);
            }
        });

        t1.start();
        t2.start();
    }
}
