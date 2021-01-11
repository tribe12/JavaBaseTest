package cn.wgh.designpattern.behavioral.iterator.v2;


import org.junit.Test;

/**
 * Created by wgh on 2021/1/6.
 */
public class MyLinkedList {
    //头节点
    Node head = null;
    private int size = 0;

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


    @Test
    public void test1() throws Exception {
        MyLinkedList list = new MyLinkedList();
        for (int i = 0; i < 12; i++) {
            list.add("myLinked" + i);
        }

        System.out.println("size:" + list.size());
        System.out.println("-----------");
        Node temp = list.head;
        for (int i = 0; i < list.size(); i++) {
            System.out.println(temp.o.toString());
            if (temp.next != null) {
                temp = temp.next;
            }
        }
    }

}
