package basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch3._01Symbol_table_arr_linkList;

import basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch1.queue.MyQueue;

import java.util.ArrayList;
import java.util.Queue;

/**
 * 链表法不需要Key comparable
 *
 * @param <Key>
 * @param <Value>
 */
public class SequentialSearchST<Key, Value> {
    private Node first;
    private int n = 0;


    public void delete(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to delete() is null");
        }
        if (size() == 0) {
            return;
        }

        if (size() == 1) {
            first = null;
        } else {
            Node x = first;
            for (; x != null; x = x.next) {
                if (x.next == key) {
                    break;
                }
            }
            Node toBeNull = x.next;
            x.next = x.next.next;
            toBeNull = null;
        }
        this.n--;


    }

    private class Node {
        Key key;
        Value val;
        Node next;


        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to get() is null");
        }
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.val;
            }
        }
        return null;
    }

    public void put(Key key, Value val) {
        if (key == null) {
            throw new IllegalArgumentException("first argument to put() is null");
        }
        if (val == null) {
            this.delete(key);
            return;
        }
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
        n++;
    }

    // Exercise 3.1.5
    public int size() {
        return n;
    }

    public Iterable<Key> keys() {
        ArrayList<Key> q = new ArrayList<Key>();
        for (Node x = first; x != null; x = x.next) {
            q.add(x.key);
        }
        return q;
    }

    public boolean contains(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("first argument to put() is null");
        }
        return get(key) != null;
    }


}
