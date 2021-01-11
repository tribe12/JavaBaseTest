package cn.wgh.designpattern.behavioral.iterator.v5;

import org.junit.Test;

/**
 * 改为泛型版本
 * <p>
 * Created by wgh on 2021/1/9.
 */
public class TestMain {
    @Test
    public void test1() throws Exception {
        MyCollection<String> myCollection1 = new MyArrayList();
        for (int i = 0; i < 12; i++) {
            myCollection1.add("myArray" + i);
        }
        System.out.println("myArray size:" + myCollection1.size());
        MyIterator<String> iterator1 = myCollection1.iterator();
        while (iterator1.hasNext()) {
            String o = iterator1.next();
            System.out.println(o);
        }

        System.out.println("------------");


        MyCollection<String> myCollection2 = new MyLinkedList();
        for (int i = 0; i < 24; i++) {
            myCollection2.add("myLinked" + i);
        }
        System.out.println("myLinked size:" + myCollection2.size());
        MyIterator<String> iterator2 = myCollection2.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }

    }
}
