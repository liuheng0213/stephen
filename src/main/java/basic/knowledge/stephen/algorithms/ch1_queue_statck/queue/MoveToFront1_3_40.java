package basic.knowledge.stephen.algorithms.ch1_queue_statck.queue;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * 练习1.3.40前移编码
 */
public class MoveToFront1_3_40<Item> implements Iterable<Item>{
    private int n;
    private Node first;
    private Node last;
    private int enqueueNum;


    @Override
    public Iterator<Item> iterator() {
        return new MoveToFrontIterator();
    }

    class Node{
        Item item;
        Node next;
        Node previous;
    }
    public boolean isEmpty(){
        return n == 0;
    }

    public void enqueue(Item item){
        if(exist(item)){
            delete(item);
        }

        //插入表头
        Node current = new Node();
        current.item = item;

        if(isEmpty()){
            current.next = null;
            current.previous = null;
            last = current;
            first = current;
        }else{
            first.next = current;
            current.previous = first;
        }

        enqueueNum++;
    }

    private void delete(Item item) {

    }

    private boolean exist(Item item) {
        MoveToFront1_3_40 moveToFront1_3_40 = new MoveToFront1_3_40();
        Iterator iterator = moveToFront1_3_40.iterator();
        while(iterator.hasNext()){
            Item current = (Item) iterator.next();
            if(current == item){
                return true;
            }
        }
        return false;
    }


    private class MoveToFrontIterator implements Iterator<Item> {
        private Node current = first;
        private int num = enqueueNum;

        @Override
        public boolean hasNext() {
            if(num != enqueueNum){
                throw new ConcurrentModificationException();
            }
            return current.next != null;
        }

        @Override
        public Item next() {
            if(num != enqueueNum){
                throw new ConcurrentModificationException();
            }
            Item item = current.item;
            current = current.previous;
            return item;
        }

        @Override
        public void remove() {
            current.previous.next = current.next;
            current.next.previous = current.previous;

        }
    }
}
