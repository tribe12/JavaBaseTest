package cn.wgh.designpattern.behavioral.iterator.v5;

/**
 * Created by wgh on 2021/1/9.
 */
public interface MyIterator<E> {
    boolean hasNext();
    E next();
}
