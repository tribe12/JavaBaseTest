package cn.wgh.thread.v10;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by wgh on 2021/4/14.
 */
public class MainTest02 {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        ExecutorCompletionService<Integer> completionService = new ExecutorCompletionService<>(threadPool);
        //提交10次
        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            completionService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    Thread.sleep(new Random().nextInt(10000));
                    return taskId;
                }
            });
        }

        //接收10次
        for (int i = 0; i < 10; i++) {
            try {
                int takeId = completionService.take().get();
                System.out.println("得到任务结果：" + takeId + "           " + LocalDateTime.now());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

    }
}
