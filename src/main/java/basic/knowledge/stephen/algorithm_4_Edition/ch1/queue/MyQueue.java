package basic.knowledge.stephen.algorithm_4_Edition.ch1.queue;

import basic.knowledge.stephen.algorithm_4_Edition.exception.ListIsEmptyException;

import java.util.Iterator;

//链表实现 自定义队列 先进先出 FIFO
//采用双向链表
public class MyQueue<T> implements Iterable<T> {
    private Node first;
    private Node last;
    private int N;

    public T findAndDeleteByIndex(int index) {
        int i = 0;
        for(Node current = this.first; current != null; current = current.next){
            if(i == index){
                //size == 1
                if(current == this.first && current == this.last){
                    this.first =null;
                    this.last =null;
                }
                //删除first
                else if(current == this.first){
                    first = first.next;
                    first.previous = null;
                }
                //删除last
                else if(current == this.last){
                    this.last = current.previous;
                    this.last.next = null;
                }
                else{
                    current.previous.next = current.next;
                    current.next.previous = current.previous;
                }
                this.N--;
                return current.t;
            }
            i++;
        }
        return null;
    }


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
        if(isEmpty()){
            throw new ListIsEmptyException("size =0");
        }
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
            current = current.next;
            return t;
        }

        @Override
        public void remove() {
            //do nothing
        }
    }
}
