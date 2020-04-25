package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._02linkedList;

import java.util.Iterator;

public class DoubleNodetest {
    public Node first;
    public Node last;
    public int N;

    public void reverseListDouble(DoubleNodetest doubleNodetest) {
        if(doubleNodetest.size() == 1){
            return;
        }
        Node first = getAndRemoveFirst(doubleNodetest);
        reverseListDouble(doubleNodetest);
        first.next = null;
        doubleNodetest.last.next = first;
        first.previous = doubleNodetest.last;
        last = first;
        N++;

    }



    private Node getAndRemoveFirst(DoubleNodetest doubleNodetest) {
        if(doubleNodetest.isEmpty()){
            throw  new RuntimeException(" node must not be empty !");
        }
        Node oldFirst = first;
        first.next.previous = null;
        first = first.next;
        N--;
        return oldFirst;
    }

    private int size() {
        return N;
    }


    class Node {
        Integer value;
        Node next;
        Node previous;

        public Node(int data) {
            this.value = data;
        }
    }
    //放到last后  dequeue从first出
    public void enqueue(Integer t) {
        if (!isEmpty()) {
            Node oldLast = last;
            Node current = new Node(t);
            current.next = null;
            current.previous = oldLast;
            last = current;
            oldLast.next = last;
        } else {
            Node current = new Node(t);
            current.next = null;
            current.previous = null;
            last = current;
            first = current;
        }
        N++;
    }

    public Integer peek() {
        if (!isEmpty()) {
            return first.value;
        }
        return null;
    }

    public boolean isEmpty() {
        return first == null && last == null;
    }
    public Iterator<Integer> iterator() {
        return new MyQueueIterator();
    }

    private class MyQueueIterator implements Iterator<Integer> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Integer next() {
            Integer t = current.value;
            current = current.next;
            return t;
        }

        @Override
        public void remove() {
            //do nothing
        }
    }


}
