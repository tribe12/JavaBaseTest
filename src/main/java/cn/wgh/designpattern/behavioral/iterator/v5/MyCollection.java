package cn.wgh.designpattern.behavioral.iterator.v5;

/**
 * Created by wgh on 2021/1/9.
 */
public interface MyCollection<E> {
    void add(E e);

    int size();

    MyIterator<E> iterator();
}
