package cn.wgh.List;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author: tribe
 * @time: 2023/4/20 0:13
 */
public class LinkedListTest {
    @Test
    public void test1() throws Exception {
        LinkedList<Object> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add("1");
        list.add("2");
        list.add("3");
        list.add(1);
        list.add(2);
        list.add(3);
        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        list.remove("1");
        System.out.println(list);
    }
}
