package cn.wgh.designpattern.behavioral.iterator.v5;

/**
 * Created by wgh on 2021/1/6.
 */
public class MyArrayList<E> implements MyCollection<E> {
    E[] objs = (E[])new Object[10];
    private int index = 0;

    @Override
    public void add(E e) {
        if (index == objs.length) {
            E[] newObjs = (E[])new Object[objs.length * 2];
            System.arraycopy(objs, 0, newObjs, 0, objs.length);
            objs = newObjs;
        }

        objs[index] = e;
        index++;
    }

    @Override
    public int size() {
        return index;
    }

    @Override
    public MyIterator<E> iterator() {
        return new MyArrayListIterator();
    }

    private class MyArrayListIterator implements MyIterator<E> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < index ? true : false;
        }

        @Override
        public E next() {
            return objs[currentIndex++];
        }
    }
}
