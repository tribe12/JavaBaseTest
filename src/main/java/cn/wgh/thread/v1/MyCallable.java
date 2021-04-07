package cn.wgh.thread.v1;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * 实现Callable接口，并结合Future实现
 * <p>
 * 首先定义一个Callable的实现类，并实现call方法，call方法是带返回值得；
 * 然后通过FutureTask的构造方法，把这个Callable实现类传进去；
 * 把FutureTask作为Thread类的target，创建Thread线程对象；
 * 通过FutureTask的get方法获取线程的执行结果；
 *
 * Created by wgh on 2021/4/5.
 */
public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("我是线程MyCallable");
        Thread.sleep(new Random().nextInt(1000));
        return new Random().nextInt(100);
    }
}
