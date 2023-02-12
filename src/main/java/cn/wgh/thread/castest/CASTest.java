package cn.wgh.thread.castest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: tribe
 * @time: 2023/2/11 21:02
 */
public class CASTest {
    public static void main(String[] args) {
//        DemoRunnable dr = new DemoRunnable();
        DemoRunnable2 dr = new DemoRunnable2();
        for (int i = 0; i < 10; i++) {
            new Thread(dr).start();
        }
    }
}

class DemoRunnable implements Runnable {

    private volatile int count = 0;

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("子线程-count:" + (++count));
    }

}


class DemoRunnable2 implements Runnable {

    private volatile AtomicInteger ai = new AtomicInteger();

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("子线程-count:" + (ai.incrementAndGet()));
    }

}
