package basic.knowledge.stephen.algorithms.ch1_queue_statck.queue;


import java.util.Iterator;

/**
 * 1.3.37 Josehus问题
 * 双向链表, 环形链表
 * 不用反选
 */
public class JosephusQueue implements Iterable {
    private int n;
    private Node first;
    private Node last;

    @Override
    public Iterator iterator() {
        return new JosephusQueueIterator();
    }

    private class Node {
        Integer item;
        Node next;
        Node previous;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void enqueue(Integer item) {
        if (!isEmpty()) {
            Node current = new Node();

            Node oldLast = last;
            current.item = item;
            oldLast.previous = current;
            current.next = oldLast;

            current.previous = first;
            first.next = current;

            last = current;
        } else {
            Node current = new Node();
            current.item = item;
            current.next = null;
            current.previous = null;
            last = current;
            first = current;
        }
        n++;
    }

    public Integer dequeue() {
        if (!isEmpty()) {
            Node oldFirst = first;
            oldFirst.previous.next = null;
            first = oldFirst.previous;
            //保证环形
            last.previous = first;
            first.next = last;

            n--;
            return oldFirst.item;
        }
        return null;
    }

    /**
     * 练习1.3.37
     * 删除M后其Next节点变成first节点
     * 如果参数为4  最终只有3个人
     *
     * @return
     */
    public JosephusQueue storeM(int m, JosephusQueue originalQueue) {
        Node current = this.first;
        JosephusQueue newJosephusQueue = new JosephusQueue();
        //i= 1时就是first节点
        for (int i = 1; originalQueue.size() >= m; i++, current = current.previous) {
            if (i % m == 0) { //到m节点,删除m节点
                current.previous.next = current.next;
                current.next.previous = current.previous;
                originalQueue.n--;
                newJosephusQueue.enqueue(current.item);
            }
        }
        return newJosephusQueue;
    }


    private class JosephusQueueIterator implements Iterator {
        private Node current = first;
        private int i = n;

        @Override
        public boolean hasNext() {
            return i != 0;
        }

        @Override
        public Integer next() {
            Integer item = current.item;
            current = current.previous;
            i--;
            return item;
        }
    }
}
