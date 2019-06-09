package basic.knowledge.stephen.algorithms.ch1_queue_statck.queue;


import java.util.Iterator;

/**
 * 练习1.3.38
 */
public class GeneralizedQueueByLink<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N;


    private class Node {
        Item t;
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
    public void enqueue(Item t) {
        if (!isEmpty()) {
            Node oldLast = last;
            Node current = new Node();
            current.t = t;
            current.next = oldLast;
            current.previous = null;
            last = current;
            oldLast.previous = last;
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

    public Item dequeue() {
        if (!isEmpty()) {
            Node oldFirst = first;
            oldFirst.previous.next = null;
            first = oldFirst.previous;
            N--;
            return oldFirst.t;
        }
        return null;
    }

    /**
     * 练习1.3.38
     *
     * @param k
     * @return
     */
    public Item delete(Item k) {
        Node first = this.first;
        for (int i = 1; i <= this.N; i++) {
            if (first.t == k) {
                first.previous.next = first.next;
                first.next.previous = first.previous;
                this.N--;
                return first.t;
            } else {
                first = first.previous;
            }
        }
        return null;
    }

    @Override
    public Iterator<Item> iterator() {
        return new GeneralizedQueueByLinkIterator();
    }

    private class GeneralizedQueueByLinkIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item t = current.t;
            current = current.previous;
            return t;
        }

        @Override
        public void remove() {
            //do nothing
        }
    }
}
