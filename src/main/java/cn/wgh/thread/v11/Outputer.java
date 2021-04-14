package cn.wgh.thread.v11;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 输出器
 * 把字母一个个打出来
 * Created by wgh on 2021/4/9.
 */
public class Outputer {
    //多线程运行有时会出现打印混乱
    public void output(String name) {
        int length = name.length();
        for (int i = 0; i < length; i++) {
            System.out.print(name.charAt(i));
        }
        System.out.println("");
    }

    /**
     * 加Lock锁实现线程互斥
     * <p>
     * 比synchronized更直观
     *
     * @param name
     */
    public void output1(String name) {
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            int length = name.length();
            for (int i = 0; i < length; i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println("");
        } finally {
            lock.unlock();
        }
    }
}
