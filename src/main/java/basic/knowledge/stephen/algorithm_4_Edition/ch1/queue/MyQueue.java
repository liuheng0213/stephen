package basic.knowledge.stephen.algorithm_4_Edition.ch1.queue;

import java.util.Iterator;

//链表实现 自定义队列 先进先出 FIFO
//采用双向链表
public class MyQueue<T> implements Iterable<T> {
    private Node first;
    private Node last;
    private int N;


    private class Node {
        T t;
        Node next;
        Node previous;
    }

    public boolean isEmpty() {
        return first == null && last == null;
    }

    public int size() {
        return N;
    }

    //放到last后  dequeue从first出
    public void enqueue(T t) {
        if (!isEmpty()) {
            Node oldLast = last;
            Node current = new Node();
            current.t = t;
            current.next = null;
            current.previous = oldLast;
            last = current;
            oldLast.next = last;
        } else {
            Node current = new Node();
            current.t = t;
            current.next = null;
            current.previous = null;
            last = current;
            first = current;
        }
        N++;
    }

    public T peek() {
        if (!isEmpty()) {
            return first.t;
        }
        return null;
    }

    public T dequeue() {
        if (size() == 1) {
            T t = first.t;
            first = null;
            last = null;
            N--;
            return t;
        }
        if (!isEmpty()) {
            Node oldFirst = first;
            first = oldFirst.next;
            first.previous = null;
            N--;
            return oldFirst.t;
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyQueueIterator();
    }

    private class MyQueueIterator implements Iterator<T> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T t = current.t;
            current = current.previous;
            return t;
        }

        @Override
        public void remove() {
            //do nothing
        }
    }
}
