package cn.wgh.thread.v7.v73;

/**
 * 设计4个线程，其中两个线程每次对j增加1，另外两个线程每次对j减少1。
 * Created by wgh on 2021/4/12.
 */
public class MainTest {
    private static int j = 0;

    public static void main(String[] args) {
        MainTest mainTest = new MainTest();
        IncreaseRunnable increaseRunnable = mainTest.new IncreaseRunnable();
        DecreaseRunnable decreaseRunnable = mainTest.new DecreaseRunnable();
        for (int i = 0; i < 2; i++) {
            new Thread(increaseRunnable).start();
            new Thread(decreaseRunnable).start();
        }

    }

    private synchronized void increase() {
        j++;
        System.out.println(Thread.currentThread().getName() + " 增加 j:" + j);
    }


    private synchronized void decrease() {
        j--;
        System.out.println(Thread.currentThread().getName() + " 减少 j:" + j);
    }

    class IncreaseRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                increase();
            }
        }
    }

    class DecreaseRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                decrease();
            }
        }
    }


}
