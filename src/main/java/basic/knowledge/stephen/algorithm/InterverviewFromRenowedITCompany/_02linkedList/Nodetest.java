package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._02linkedList;

import java.util.Iterator;

public class Nodetest {
    public Node first;
    public Node last;
    public int N;

    public void reverseList(Nodetest nodetest) {

        //递归法
        if(nodetest.size() == 1){
            return;
        }
        Node first = nodetest.getAndRemoveFirst(nodetest);
        reverseList(nodetest);
        first.next = null;
        nodetest.last.next = first;
        last = first;
        N++;


    }

    private void reverseListNoReversion(Node cur) {
        Node pre = null;
        Node next = null;
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;

        }

    }

    public void reversePartialList(Nodetest nodetest,int from,int to){
        if(from < 0 || to < from || to > nodetest.size()){
            return;
        }

        
    }


    private int size() {
        return N;
    }

    private Node getAndRemoveFirst(Nodetest nodetest) {
        if (nodetest.isEmpty()) {
            throw new RuntimeException(" node must not be empty !");
        }
        Node oldFirst = first;
        first = first.next;
        N--;
        return oldFirst;
    }


    class Node {
        Integer value;
        Node next;

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
            last = current;
            oldLast.next = last;
        } else {
            Node current = new Node(t);
            current.next = null;
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

    /**
     * 仅考虑Next
     *
     * @param node
     * @param k
     * @return
     */
    public Node removelastKthNode(Node node, int k) {
        if (node == null || k < 1) {
            return node;
        }

        if (node != first) {
            throw new RuntimeException(" node must be the first node!");
        }

        Node cur = node;
        while (cur != null) {
            --k;
            cur = cur.next;
        }

        if (k == 0) {
            node = node.next;
        }

        if (k < 0) {
            cur = node;
            while (++k != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        //N--;
        return node;
    }
}
