package cn.wgh.designpattern.behavioral.iterator.v3;

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
}
