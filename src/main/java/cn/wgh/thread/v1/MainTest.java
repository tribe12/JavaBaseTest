package cn.wgh.thread.v1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * 通常4种方法创建线程
 * 1、继承Thread类
 * 2、实现Runnable接口
 * 3、实现Callable接口，并结合Future实现
 * 4、通过线程池创建线程
 * Created by wgh on 2021/4/5.
 */
public class MainTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * 1、继承Thread类
         */
        MyThread myThread = new MyThread();
        myThread.start();
        /**
         * 2、实现Runnable接口
         */
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        /**
         * 3、实现Callable接口，并结合Future实现
         */
        /*
         * 首先定义一个Callable的实现类，并实现call方法，call方法是带返回值得；
         * 然后通过FutureTask的构造方法，把这个Callable实现类传进去；
         * 把FutureTask作为Thread类的target，创建Thread线程对象；
         * 通过FutureTask的get方法获取线程的执行结果；
         *
         */
        MyCallable myCallable = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(myCallable);
        Thread futureThread = new Thread(futureTask);
        futureThread.start();
        Integer returnInt = futureTask.get();
        System.out.println("返回：" + returnInt);

        /**
         * 4、通过线程池创建线程
         */
        /*
         * 首先，第一个Runnable的实现类，重写run方法；
         * 然后创建一个拥有固定线程数的线程池；
         * 最后通过对象的方法传入线程对象；
         */
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new MyRunnable(i));
        }
        executorService.shutdown();

    }
}
