package cn.wgh.thread.v7.v72;

/**
 * 某共享数据
 * Created by wgh on 2021/4/12.
 */
public class Sharedata {
    private int count = 100;

    public synchronized void increase() {
        for (int i = 0; i < 99; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            System.out.println(Thread.currentThread().getName() + " 增加 count:" + count);
        }
    }

    public synchronized void decrease() {
        for (int i = 0; i < 99; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count--;
            System.out.println(Thread.currentThread().getName() + " 减少 count:" + count);
        }

    }

    public int getCount() {
        return count;
    }
}
