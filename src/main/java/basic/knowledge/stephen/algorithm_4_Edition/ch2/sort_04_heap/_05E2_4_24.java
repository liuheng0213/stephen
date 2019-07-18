package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_04_heap;

import basic.knowledge.stephen.algorithm_4_Edition.util.SortUtil;

public class _05E2_4_24<Item extends Comparable<Item>> {
    private Node first;
    private Node last;

    private class Node {
        Item item;
        Node father;
        Node subLeft;
        Node subRight;
    }

    private int n = 0;

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void insert(Item item) {
        if (isEmpty()) {
            Node node = new Node();
            node.item = item;
            first = node;
            last = node;
        } else {
            Node node = new Node();
            node.item = item;

            //swim
            swim(node);
        }
        this.n++;
    }

    private void swim(Node node) {
        while (node != first) {
            if (SortUtil.less(node.father.item, node.item)) {
                Node father = node.father;
                //exchange node
                if (father.subLeft != null) {
                    Node oriLeft = father.subLeft;
                    oriLeft.father = node;

                    node.father = father.father;

                    father.subRight = null;
                    father.subLeft = null;
                    father.father = node;

                    node.subRight = father;
                    node.subLeft = oriLeft;
                }else{
                    node.father = father.father;

                    father.subRight = null;
                    father.subLeft = null;
                    father.father = node;

                    node.subLeft = father;
                }
            }
            node = node.father;
        }
    }
}
