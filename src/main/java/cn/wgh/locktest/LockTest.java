package cn.wgh.locktest;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock 是一个接口，两个直接实现类：ReentrantLock（重入锁）, ReentrantReadWriteLock（读写锁）。
 * Lock 锁的基本用法， l.lock()方法进行上锁， l.unlock()方法进行解锁
 *
 * @author: tribe
 * @time: 2023/4/23 3:49
 */
public class LockTest {
    @Test
    public void test1() throws Exception {
        // 创建一个Lock锁
        Lock l = new ReentrantLock();
        // 给代码块上锁
        l.lock();
        /**
         * 锁在空闲的才能获取锁（未获得锁不会等待）。
         * 举个例子：当两个线程同时通过lock.trylock()想获取某个锁时，假若此时线程A获取到了锁，而线程B不会等待，直接放弃获取锁。
         */
        boolean b = l.tryLock();
        /**
         * 如果锁定可用，则此方法立即返回值true。
         * 如果锁不可用，则当前线程将被禁用以进行线程调度，并且在发生以下三种情况之一之前处于休眠状态：
         * 1.当前线程获取锁。
         * 2.其他一些线程中断当前线程。
         * 3.等待时间过去了，返回false
         */
        boolean b1 = l.tryLock(1000, TimeUnit.MILLISECONDS);
        // 释放锁
        l.unlock();
    }
}
