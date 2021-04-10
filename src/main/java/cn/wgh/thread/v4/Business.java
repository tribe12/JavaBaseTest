package cn.wgh.thread.v4;

/**
 * 子线程循环10次，主线程循环20次，
 * 接着又回到子线程循环10次，主线程循环20次，
 * 如此往复50次，请写出程序。
 * <p>
 * 经验：如果要用到的数据（包括同步锁）或共同算法的若干个方法应该归在同一个类身上，
 * 这种思想刚好体现了高类聚和程序的健壮性
 * Created by wgh on 2021/4/10.
 */
public class Business {
    private boolean bShouldSub = true;

    public synchronized void sub(int cnum) {
        //关于线程等待唤醒的判断，这里用while比用if更好，代码更健壮
        while (!bShouldSub) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 1; i <= 10; i++) {
            System.out.println("-- 子线程循环第" + i + "次，总的循环第" + cnum + "次。--");
        }

        bShouldSub = false;
        this.notify();
    }


    public synchronized void main(int cnum) {
        //关于线程等待唤醒的判断，这里用while比用if更好，代码更健壮
        while (bShouldSub) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 1; i <= 20; i++) {
            System.out.println("主线程循环第" + i + "次，总的循环第" + cnum + "次。");
        }

        bShouldSub = true;
        this.notify();
    }

}
