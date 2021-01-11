package cn.wgh.designpattern.behavioral.iterator.v2;

import org.junit.Test;

/**
 * Created by wgh on 2021/1/8.
 */
public class TestMain {

    @Test
    public void test1() throws Exception {
        MyLinkedList list = new MyLinkedList();
        for (int i = 0; i < 12; i++) {
            list.add("myLinked" + i);
        }

        System.out.println(list.size());

    }
}
