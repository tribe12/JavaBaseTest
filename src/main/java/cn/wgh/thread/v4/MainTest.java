package cn.wgh.thread.v4;

/**
 * 线程同步通信技术
 * <p>
 * 子线程循环10次，主线程循环20次，
 * 接着又回到子线程循环10次，主线程循环20次，
 * 如此往复50次，请写出程序。
 * <p>
 * 经验：如果要用到的数据（包括同步锁）或共同算法的若干个方法应该归在同一个类身上，
 * 这种思想刚好体现了高类聚和程序的健壮性
 * Created by wgh on 2021/4/9.
 */
public class MainTest {
    public static void main(String[] args) {
        Business business = new Business();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 50; i++) {
                    business.sub(i);
                }
            }
        }).start();

        for (int i = 1; i <= 50; i++) {
            business.main(i);
        }
    }
}
