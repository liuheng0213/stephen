package basic.knowledge.stephen.algorithms.ch1_queue_statck.queue;

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
        return first == null && last ==null;
    }

    public int size() {
        return N;
    }

    public void enqueue(T t) {
        if(!isEmpty()){
            Node oldLast = last;
            Node current = new Node();
            current.t = t;
            current.next = oldLast;
            current.previous = null;
            last = current;
            oldLast.previous = last;
        }else{
            Node current = new Node();
            current.t = t;
            current.next = null;
            current.previous = null;
            last = current;
            first = current;
        }
        N++;
    }

    public T dequeue(){
        if(!isEmpty()){
            Node oldFirst = first;
            oldFirst.previous.next = null;
            first = oldFirst.previous;
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
