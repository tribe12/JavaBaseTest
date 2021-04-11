package cn.wgh.thread.v5;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 线程范围内共享变量
 * <p>
 * Created by wgh on 2021/4/11.
 */
public class MainTest {
    /*
       private static int data = 0;
      */
    private static Map<Thread, Integer> threadMap = new HashMap<>();

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    /*
                      data = new Random().nextInt();
                      System.out.println(Thread.currentThread().getName() + " put data:" + data);
                    */
                    int tempData = new Random().nextInt();
                    threadMap.put(Thread.currentThread(), tempData);
                    System.out.println(Thread.currentThread().getName() + " put data:" + tempData);
                    new A().getData();
                    new B().getData();
                }

            }).start();
        }
    }


    static class A {
        public void getData() {
            /*
                System.out.println("A from " + Thread.currentThread().getName() + " get data:" + data);
             */
            System.out.println("A from " + Thread.currentThread().getName() + " get data:" + threadMap.get(Thread.currentThread()));

        }
    }

    static class B {
        public void getData() {
            /*
                System.out.println("B from " + Thread.currentThread().getName() + " get data:" + data);
             */
            System.out.println("B from " + Thread.currentThread().getName() + " get data:" + threadMap.get(Thread.currentThread()));
        }
    }
}
