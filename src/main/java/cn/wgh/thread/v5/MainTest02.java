package cn.wgh.thread.v5;

import java.util.Random;

/**
 * 线程范围内共享变量的概念
 * <p>
 * Created by wgh on 2021/4/11.
 */
public class MainTest02 {
    private static ThreadLocal threadLocal = new ThreadLocal<Integer>();

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int tempData = new Random().nextInt();
                    threadLocal.set(tempData);
                    System.out.println(Thread.currentThread().getName() + " put data:" + tempData);
                    new A().getData();
                    new B().getData();
                }

            }).start();
        }
    }


    static class A {
        public void getData() {
            System.out.println("A from " + Thread.currentThread().getName() + " get data:" + threadLocal.get());

        }
    }

    static class B {
        public void getData() {
            System.out.println("B from " + Thread.currentThread().getName() + " get data:" + threadLocal.get());
        }
    }
}
