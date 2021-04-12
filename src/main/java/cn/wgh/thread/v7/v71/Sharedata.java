package cn.wgh.thread.v7.v71;

/**
 * Created by wgh on 2021/4/12.
 */
public class Sharedata implements Runnable {
    private int count = 100;
    private boolean hasTicket = true;

    @Override
    public void run() {
        while (hasTicket) {
            count--;
            System.out.println(Thread.currentThread().getName()+" 卖出去1张，还票剩" + count + "张");
            if (count == 0) {
                hasTicket = false;
                System.out.println(Thread.currentThread().getName()+" 票卖完啦！");
            }
        }
    }

    public int getCount() {
        return count;
    }
}
