package cn.wgh.settest;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author: tribe
 * @time: 2023/4/10 10:54
 */
public class TreeSetTest {
    @Test
    public void test1() throws Exception {
        Set<String> hashSet = new TreeSet<>();
        hashSet.add("c");
        hashSet.add("b");
        hashSet.add("a");
        hashSet.add("b");
        hashSet.add("d");
        hashSet.add("3");
        hashSet.add("1");
        hashSet.add("2");
        hashSet.add("三");
        hashSet.add("一");
        hashSet.add("二");
        System.out.println(hashSet);//[1, 2, 3, a, b, c, d, 一, 三, 二]
        System.out.println(hashSet.size());//4
    }
}
