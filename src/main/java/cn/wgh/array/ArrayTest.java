package cn.wgh.array;

import org.junit.Test;

/**
 * Created by wgh on 2020/12/22.
 */
public class ArrayTest {
    @Test
    public void test1() throws Exception {
        System.out.println(add(1, 2, 3, 4, 5, 6));
        System.out.println(add2(1, 2, 3, 4, 5, 6));

    }

    /**
     * 不定长参数形式
     *
     * @param a
     * @return
     */
    public int add(int... a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }

    /**
     * 不定长参数形式
     *
     * @param a
     * @return
     */
    public int add2(int... a) {
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        return sum;
    }
}
