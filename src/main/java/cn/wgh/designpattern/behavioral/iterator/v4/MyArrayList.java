package cn.wgh.designpattern.behavioral.iterator.v4;

/**
 * Created by wgh on 2021/1/6.
 */
public class MyArrayList implements MyCollection {
    Object[] objs = new Object[10];
    private int index = 0;

    @Override
    public void add(Object o) {
        if (index == objs.length) {
            Object[] newObjs = new Object[objs.length * 2];
            System.arraycopy(objs, 0, newObjs, 0, objs.length);
            objs = newObjs;
        }

        objs[index] = o;
        index++;
    }

    @Override
    public int size() {
        return index;
    }

    @Override
    public MyIterator iterator() {
        return new MyArrayListIterator();
    }

    private class MyArrayListIterator implements MyIterator {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < index ? true : false;
        }

        @Override
        public Object next() {
            return objs[currentIndex++];
        }
    }
}
