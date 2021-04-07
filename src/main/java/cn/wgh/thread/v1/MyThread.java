package cn.wgh.thread.v1;

import java.util.Random;

/**
 * 继承Thread类，并重写它的run方法，调用start方法就可以启动线程。
 * <p>
 * Created by wgh on 2021/4/5.
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("我是线程MyThread");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
