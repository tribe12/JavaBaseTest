package cn.wgh.List;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by wgh on 2021/2/25.
 */
public class IteratorTest {

    /**
     * 不要在foreach循环里进行元素add/remove操作。
     * remove元素操作请使用Iterator方式，
     * 如果并发操作需要对Iterator加锁。
     *
     * @throws Exception
     */
    @Test
    public void testName1() throws Exception {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int item = iterator.next();
            if (item % 2 == 0) {
                iterator.remove();
            }
        }
        System.out.println(list);
    }
}
