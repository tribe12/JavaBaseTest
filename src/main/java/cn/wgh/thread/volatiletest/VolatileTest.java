package cn.wgh.thread.volatiletest;

/**
 * @author: tribe
 * @time: 2023/2/11 20:28
 */
public class VolatileTest {
    public static void main(String[] args) {
        DemoThread dt = new DemoThread();
        dt.start();
        while (true) {
            if (dt.isFlag()) {
                System.out.println("主线程终止");
                break;
            }
//            System.out.printf(".");
        }
    }
}

class DemoThread extends Thread {
//    private boolean flag;
    private volatile boolean flag;

    @Override
    public void run() {
        try {
            System.out.println("1");
            Thread.sleep(200);
            System.out.println("2");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("子线程-flag:" + isFlag());
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
