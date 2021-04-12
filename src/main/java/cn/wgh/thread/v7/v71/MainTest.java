package cn.wgh.thread.v7.v71;

/**
 * 多线程访问共享对象和数据的的方式
 * <p>
 * 1.如果每个线程执行的代码相同，可以使用同一个Runnable对象，这个Runnable对象中有那个共享数据，
 * 比如卖票系统就可以这么做
 *
 * Created by wgh on 2021/4/12.
 */
public class MainTest {
    public static void main(String[] args) {

        // 一个对象,交由多个线程卖票，票不会卖超。
        Sharedata sharedata = new Sharedata();

        new Thread(sharedata).start();
        new Thread(sharedata).start();
        new Thread(sharedata).start();
        new Thread(sharedata).start();
        new Thread(sharedata).start();
        new Thread(sharedata).start();

        //再等待足够长时间，由主线程去查票
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("============ 余票为："+sharedata.getCount()+" ============");
    }

}
