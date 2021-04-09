package cn.wgh.thread.v3;

/**
 * 线程互斥
 * Created by wgh on 2021/4/5.
 */
public class MainTest {
    public static void main(String[] args) {
        Outputer outputer = new Outputer();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //outputer.output("ABCDEFG");
                    //outputer.output1("ABCDEFG");
                    outputer.output2("ABCDEFG");

                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //outputer.output("1234567");
                    //outputer.output1("1234567");
                    outputer.output2("1234567");
                }
            }
        }).start();
    }
}
