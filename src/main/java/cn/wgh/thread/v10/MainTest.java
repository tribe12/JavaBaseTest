package cn.wgh.thread.v10;

import java.time.LocalDateTime;
import java.util.concurrent.*;

/**
 * Callable 与 Future 例子
 * <p>
 * Created by wgh on 2021/4/14.
 */
public class MainTest {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        Future<String> future = threadPool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(10000);
                return "我是结果！";
            }
        });

        System.out.println(LocalDateTime.now() + " 等待结果");
        try {
            //运行到future.get()，会等待，直到拿到结果再运行后面的代码
            System.out.println(LocalDateTime.now() + " 结果是：" + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(LocalDateTime.now());
    }
}
