package cn.wgh.thread.v3;

/**
 * 输出器
 * 把字母一个个打出来
 * Created by wgh on 2021/4/9.
 */
public class Outputer {
    //多线程运行有时会出现打印混乱
    public void output(String name) {
        int length = name.length();
        for (int i = 0; i < length; i++) {
            System.out.print(name.charAt(i));
        }
        System.out.println("");
    }

    /**
     * 加锁实现线程互斥（相互排斥，就不会冲突）
     *
     * @param name
     */
    public void output1(String name) {
        synchronized (this) {
            int length = name.length();
            for (int i = 0; i < length; i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println("");
        }
    }

    /**
     * 和output1方法效果一样，简便写法
     *
     * @param name
     */
    public synchronized void output2(String name) {
        int length = name.length();
        for (int i = 0; i < length; i++) {
            System.out.print(name.charAt(i));
        }
        System.out.println("");
    }
}
