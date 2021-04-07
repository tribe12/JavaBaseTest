package cn.wgh.thread.vv1;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 常用的几种实现线程间通信的方法
 * <p>
 * Created by wgh on 2021/4/3.
 */
public class ThreadTest {
    public static void main(String[] args) {
        //1.如何让两个线程依次执行？
        //testName1();
        //2.保证A全部打印完后才开始打印B
        //testName2();
        //3.如何让两个线程按照指定的方式有序交叉运行？
        // testName3();
        //4. A、B、C、D四个线程，其中D必须要等到A、B、C全部执行完毕后才鞥执行，而A、B、C是同步运行的
        //  testCountDownLatch();
        // 5、三个运动员各自准备等到三个人都准备好后，再一起跑
        //  testCyclicBarrier();
        //6、子线程完成某件任务后，把得到的结果或传给你主线程
        testCallableFuture();
    }

    /**
     * 1.如何让两个线程依次执行？
     *
     */
    public static void testName1() {
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                printNumber("A", 3, 200);
            }
        });

        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                printNumber("B", 3, 200);
            }
        });

        B.start();
        A.start();

    }


    /**
     * 2.保证A全部打印完后才开始打印B
     *
     */
    public static void testName2() {
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                printNumber("A", 3, 200);
            }
        });

        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("B开始等待A");
                try {
                    A.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                printNumber("B", 3, 200);
            }
        });

        A.start();
        B.start();
    }


    /**
     * 3.如何让两个线程按照指定的方式有序交叉运行？
     * A打完1后，再让B打印完全部，最后再回到A继续打印剩余
     *
     */
    public static void testName3() {
        Object lock = new Object();
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("A --> 1");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("A --> 2");
                    System.out.println("A --> 3");
                }

            }
        });

        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("B --> 1");
                    System.out.println("B --> 2");
                    System.out.println("B --> 3");
                    lock.notify();
                }
            }
        });

        A.start();
        B.start();

    }


    /**
     * 4. A、B、C、D四个线程，其中D必须要等到A、B、C全部执行完毕后才鞥执行，
     * 而A、B、C是同步运行的。
     */
    @Test
    public static void testCountDownLatch() {
        int worker = 3;
        //创建一个计数器，设置初始值
        CountDownLatch countDownLatch = new CountDownLatch(worker);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("D is waiting for other three threads");
                try {
                    //进入等待状态，等待线程调用，直到计数器变成0；
                    countDownLatch.await();
                    System.out.println("All done, D start working");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
        for (char threadName = 'A'; threadName <= 'C'; threadName++) {
            final String tN = String.valueOf(threadName);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(tN + " is working");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(tN + " finished");
                    //每调用一次计数器减小1
                    countDownLatch.countDown();
                }
            }).start();
        }
    }



    /**
     * 5、三个运动员各自准备等到三个人都准备好后，再一起跑
     *
     */
    public static void testCyclicBarrier() {
        int runner = 3;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(runner);
        final Random random = new Random();
        for (char runnerName = 'A'; runnerName <= 'C'; runnerName++) {
            String rN = String.valueOf(runnerName);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    long prepareTime = random.nextInt(10000) + 100;
                    System.out.println(rN + " is preparing for time: " + prepareTime);
                    try {
                        Thread.sleep(prepareTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(rN + " is prepared, waiting for others");
                    try {
                        //当先线程进入等待状态
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println(rN + " starts running");
                }
            }).start();
        }
    }


    /**
     * 6、子线程完成某件任务后，把得到的结果或传给你主线程
     */
    public static void testCallableFuture() {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("Task starts");
                Thread.sleep(1000);
                int result = 0;
                for (int i = 0; i <= 100 ; i++) {
                    System.out.println(i);
                    result += i;
                }
                System.out.println("Task finished and return result");
                return result;
            }
        };

        FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);
        new Thread(futureTask).start();

        try {
            System.out.println("Before futureTask.get()");
            System.out.println("Result: "+ futureTask.get());
            System.out.println("After futureTask.get()");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }


    /**
     * 依次打印num个数字
     *
     * @param threadName
     * @param num
     */
    private static void printNumber(String threadName, int num) {
        printNumber(threadName, num, 0l);
    }


    private static void printNumber(String threadName, int num, long sleepMillis) {
        int i = 0;
        while (i++ < num) {
            if (sleepMillis != 0l) {
                try {
                    Thread.sleep(sleepMillis);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(threadName + "print：" + i);
        }
    }
}
