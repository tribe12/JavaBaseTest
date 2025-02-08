package cn.wgh.vectorTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/**
 * @author: tribe
 * @time: 2023/4/20 1:09
 */
public class VectorTest {
    @Test
    public void test1() throws Exception {
        Vector<Object> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add("1");
        vector.add("2");
        vector.add("3");
        System.out.println(vector);
        vector.remove(1);
        System.out.println(vector);
        vector.remove("1");
        System.out.println(vector);
    }
}
