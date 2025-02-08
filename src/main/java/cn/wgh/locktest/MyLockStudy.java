package cn.wgh.locktest;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: tribe
 * @time: 2023/4/23 3:53
 */
public class MyLockStudy implements Runnable {

    private int count;
    Lock l = new ReentrantLock();

    @Override
    public void run() {
        l.lock();
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": ");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        l.unlock();
    }

    public static void main(String args[]) {
        MyLockStudy runn = new MyLockStudy();
        Thread thread1 = new Thread(runn, "thread1");
        Thread thread2 = new Thread(runn, "thread2");
        Thread thread3 = new Thread(runn, "thread3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}