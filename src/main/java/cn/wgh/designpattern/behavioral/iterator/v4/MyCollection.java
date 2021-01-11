package cn.wgh.designpattern.behavioral.iterator.v4;

/**
 * Created by wgh on 2021/1/9.
 */
public interface MyCollection {
    void add(Object o);

    int size();

    MyIterator iterator();
}
