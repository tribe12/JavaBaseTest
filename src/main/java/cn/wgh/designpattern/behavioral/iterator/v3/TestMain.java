package cn.wgh.designpattern.behavioral.iterator.v3;

import org.junit.Test;

/**
 * Created by wgh on 2021/1/9.
 */
public class TestMain {

    @Test
    public void test1() throws Exception {
        MyCollection myCollection1 = new MyArrayList();
        for (int i = 0; i < 12; i++) {
            myCollection1.add("myArray" + i);
        }
        System.out.println("myArray size:" + myCollection1.size());

        MyCollection myCollection2 = new MyLinkedList();
        for (int i = 0; i < 24; i++) {
            myCollection2.add("myLinked" + i);
        }
        System.out.println("myLinked size:" + myCollection2.size());
    }
}
