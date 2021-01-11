package cn.wgh.designpattern.behavioral.iterator.v4;

import org.junit.Test;

/**
 * 如何对容器遍历呢？
 * 只有让一种容器自己实现遍历方法（只有自己知道自己要怎么遍历）
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
        MyIterator iterator1 = myCollection1.iterator();
        while (iterator1.hasNext()){
            Object  o =  iterator1.next();
            System.out.println(o);
        }

        System.out.println("------------");



        MyCollection myCollection2 = new MyLinkedList();
        for (int i = 0; i < 24; i++) {
            myCollection2.add("myLinked" + i);
        }
        System.out.println("myLinked size:" + myCollection2.size());
        MyIterator iterator2 = myCollection2.iterator();
        while (iterator2.hasNext()) {
            System.out.println( iterator2.next());
        }

    }
}
