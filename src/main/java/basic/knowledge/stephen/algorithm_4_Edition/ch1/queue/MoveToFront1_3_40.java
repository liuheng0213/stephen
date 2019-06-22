package basic.knowledge.stephen.algorithm_4_Edition.ch1.queue;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * 练习1.3.40前移编码
 */
public class MoveToFront1_3_40<Item> implements Iterable<Item>{
    private int n;
    private Node first;
    private Node last;
    private int modCount;


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
        //插入表头
        Node current = new Node();
        current.item = item;

        if(isEmpty()){
            current.next = null;
            current.previous = null;
            last = current;
            first = current;
        }else{
            existAndDelete(item);
            Node oldFirst = first;
            oldFirst.previous = current;
            current.next = oldFirst;
            first = current;
        }
        n++;
        modCount++;
    }

    private void existAndDelete(Item item) {
        for(Node current = this.first; current != null; current = current.next){
            if(current.item == item){
                //删除first
                if(current == this.first){
                    first = current.next;
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
                current =null;
                this.n--;
                modCount++;
                return;

            }
        }
        return;
    }


    private class MoveToFrontIterator implements Iterator<Item> {
        private Node current = first;
        private int expectedCount = modCount;

        @Override
        public boolean hasNext() {
            if(expectedCount != modCount){
                throw new ConcurrentModificationException();
            }
            return current != null;
        }

        @Override
        public Item next() {
            if(expectedCount != modCount){
                throw new ConcurrentModificationException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
           //
        }
    }
}
