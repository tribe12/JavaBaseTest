package cn.wgh.thread.v7.v72;

/**
 * 多线程访问共享对象和数据的的方式
 *
 * 2.如果每个线程执行代码不同，这时候需要用不同的Runnable对象，
 * 有如下两种方式来实现这些Runnable对象之间的共享数据
 * （1）将共享数据封装在一个对象中，然后将这个对象逐一传递给各个Runnable对象。
 *     每个线程对共享数据的操作方法也分配到那个对象身上去完成，这样容易实现
 *     针对该数据进行的各个操作的互斥和通信。
 * （2）将这些Runnable对象作为某一个类中的内部类，共享数据作为这个外部类中的
 *     成员变量，每个线程对共享数据的操作方法也分配给外部类，以便实现对共享数据
 *     进行的各个操作的互斥和通信，作为内部类的各个Runnable对象调用外部类的这
 *     些方法。
 * （3）上面两种方式的组合：将共享数据封装在另一个对象中，每个线程对共享数据的
 *     操作方法也分配到那个对象身上去完成，对象作为这个外部类中的成员变量或方法
 *     中的局部变量，每个线程的Runnable对象作为外部类中的成员内部类或局部内部类。
 *
 *     总之，要同步互斥的几段代码最好分别放在几个独立的方法中，这些方法再放在
 *     同一个类中，这样比较容易实现它们之间的同步互斥和通信。
 *
 *
 *
 *
 *
 *
 * Created by wgh on 2021/4/12.
 */
public class MainTest02 {
    public static void main(String[] args) {

        Sharedata sharedata = new Sharedata();

        new Thread(new IncreaseRunnable(sharedata)).start();
        new Thread(new DecreaseRunnable(sharedata)).start();
        new Thread(new IncreaseRunnable(sharedata)).start();
        new Thread(new DecreaseRunnable(sharedata)).start();
        new Thread(new IncreaseRunnable(sharedata)).start();
        new Thread(new DecreaseRunnable(sharedata)).start();



        //再等待足够长时间，由主线程去查票
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("============ 余票为："+sharedata.getCount()+" ============");
    }
}
