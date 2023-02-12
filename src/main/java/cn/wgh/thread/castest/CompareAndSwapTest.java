package cn.wgh.thread.castest;

/**
 * 模拟 CAS 算法
 * <p>
 * 此处模拟代码使用 synchronized 关键字只是模拟演示效果，并非 Java 底层具体实现方式。
 *
 * @author: tribe
 * @time: 2023/2/11 21:21
 */
public class CompareAndSwapTest {
    public static void main(String[] args) {

        CompareAndSwap cas = new CompareAndSwap();

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int expectedValue = cas.get();
                    boolean result = cas.compareAndSet(expectedValue, (int) (Math.random() * 100));
                    System.out.println("结果：" + result);
                }
            }).start();
        }
    }
}

class CompareAndSwap {

    private int value;

    /**
     * 获取内存值
     *
     * @return
     */
    public synchronized int get() {
        return value;
    }

    /**
     * 设置
     *
     * @param expectedValue 预估值
     * @param newValue      新值
     * @return
     */
    public synchronized boolean compareAndSet(int expectedValue, int newValue) {
        return expectedValue == compareAndSwap(expectedValue, newValue);
    }

    /**
     * 比较
     *
     * @param expectedValue 预估值
     * @param newValue      新值
     * @return
     */
    private synchronized int compareAndSwap(int expectedValue, int newValue) {
        int oldValue = value;

        if (oldValue == expectedValue) {
            value = newValue;
        }

        return oldValue;
    }
}
