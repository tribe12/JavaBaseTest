package cn.wgh.thread.v2;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 线程池里提供的定时器功能
 * Created by wgh on 2021/4/14.
 */
public class MainTest02 {
    public static void main(String[] args) {
        System.out.println(LocalDateTime.now());
        System.out.println("===========================");
        Executors.newScheduledThreadPool(3).schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + " 爆炸...");
            }
        }, 2, TimeUnit.SECONDS);

    }
}
