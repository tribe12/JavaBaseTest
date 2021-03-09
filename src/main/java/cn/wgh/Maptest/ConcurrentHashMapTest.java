package cn.wgh.Maptest;

import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 *
 * 我们可以使用CocurrentHashMap来代替Hashtable吗？
 *     我们知道Hashtable是synchronized的，但是ConcurrentHashMap同步性能更好，
 *     因为它仅仅根据同步级别对map的一部分进行上锁。ConcurrentHashMap当然可以
 *     代替HashTable，但是HashTable提供更强的线程安全性。它们都可以用于多线程
 *     的环境，但是当Hashtable的大小增加到一定的时候，性能会急剧下降，因为迭代
 *     时需要被锁定很长的时间。因为ConcurrentHashMap引入了分割(segmentation)，
 *     不论它变得多么大，仅仅需要锁定map的某个部分，而其它的线程不需要等到迭代完
 *     成才能访问map。简而言之，在迭代的过程中，ConcurrentHashMap仅仅锁定map的
 *     某个部分，而Hashtable则会锁定整个map。
 *
 * Created by wgh on 2021/3/9.
 */
public class ConcurrentHashMapTest {
    @Test
    public void test1() throws Exception {
        //ConcurrentHashMap 是java集合中map的实现，
        // 是哈希表的线程安全版本，即使是线程安全版本
        Map<String, Integer> count = new ConcurrentHashMap<>();
        //CountDownLatch其实可以把它看作一个计数器，
        // 只不过这个计数器的操作是原子操作，
        // 同时只能有一个线程去操作这个计数器，
        // 也就是同时只能有一个线程去减这个计数器里面的值
        CountDownLatch endLatch = new CountDownLatch(3);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Integer oldvalue;
                for (int i = 0; i < 5; i++) {
                    Integer value = count.get("123");
                    if (null == value) {
                        // 添加键值对
                        count.put("123", 1);
                    } else {
                        count.put("123", value + 1);
                    }
                }
                //countDown 的时候每次调用都会对 state 减 1 也就是我们
                // new CountDownLatch(3); 的这个计数器的数字减 1
                endLatch.countDown();

            }
        };

        //new CountDownLatch(3);  3 代表 3个线程
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();

        try {
            //此方法用来让当前线程阻塞，直到count减小为0才恢复执行,a
            // wait 方法它会去获取同步值发现为0的话成功返回，
            // 如果小于0的话，再次判断是否是头结点
            endLatch.await();
            System.out.println(count);
            System.out.println(endLatch.getCount());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
