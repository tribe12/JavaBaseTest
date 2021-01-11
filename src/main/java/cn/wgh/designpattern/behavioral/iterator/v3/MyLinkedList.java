package cn.wgh.designpattern.behavioral.iterator.v3;


import org.junit.Test;

/**
 * Created by wgh on 2021/1/6.
 */
public class MyLinkedList implements MyCollection{
    //头节点
    Node head = null;
    private int size = 0;

    @Override
    public void add(Object o) {
        Node newNode = new Node(o);
        Node temp = head;
        if (head == null) {
            head = newNode;
        } else {
            for (int i = 0; i < size; i++) {
                if (i == size - 1) {
                    temp.next = newNode;
                } else {
                    temp = temp.next;
                }
            }
        }
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * 节点
     */
    private class Node {
        //数据本身
        private Object o;
        //下一个节点
        Node next = null;

        public Node(Object o) {
            this.o = o;
        }

    }


}
