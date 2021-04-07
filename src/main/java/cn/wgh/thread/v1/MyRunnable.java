package cn.wgh.thread.v1;

import java.util.Random;

/**
 * 通过实现Runnable接口，并实现run方法.
 *
 * 然后创建Runnable实现类对象，并把它作为target传入Thread的构造函数中，
 * 最后调用start方法启动线程。
 * Created by wgh on 2021/4/5.
 */
public class MyRunnable implements Runnable {
    private Integer num;

    public MyRunnable() {}

    public MyRunnable(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println("我是线程MyRunnable" + (num == null ? "" : "_" + num));
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
