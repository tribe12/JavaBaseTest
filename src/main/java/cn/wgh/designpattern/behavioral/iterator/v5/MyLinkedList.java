package cn.wgh.designpattern.behavioral.iterator.v5;


import org.junit.Test;

/**
 * Created by wgh on 2021/1/6.
 */
public class MyLinkedList<E> implements MyCollection<E> {
    //头节点
    Node<E> head = null;
    private int size = 0;

    @Override
    public void add(E e) {
        Node newNode = new Node(e);
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

    @Override
    public MyIterator iterator() {
        return new MyLinkedListIterator();
    }

    private class MyLinkedListIterator implements MyIterator {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size - 1 ? true : false;
        }

        @Override
        public E next() {
            Node<E> nextNode = head;
            for (int i = 0; i <= currentIndex; i++) {
                nextNode = nextNode.next;
            }
            currentIndex++;
            return nextNode.o;
        }
    }

    /**
     * 节点
     */
    private class Node<E> {
        //数据本身
        private E o;
        //下一个节点E<E>
        Node<E> next = null;

        public Node(E e) {
            this.o = e;
        }

    }

}
