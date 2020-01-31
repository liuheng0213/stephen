package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._02LinkedList;

import java.util.Iterator;

public class _02DeleteBackwardsToK {
    public static void main(String[] args) {
        Nodetest nodetest = new Nodetest();
        nodetest.enqueue(3);
        nodetest.enqueue(2);
        nodetest.enqueue(1);
        nodetest.enqueue(6);
        nodetest.enqueue(9);
        nodetest.enqueue(11);
        nodetest.enqueue(14);
        nodetest.enqueue(16);
        nodetest.enqueue(21);
        nodetest.enqueue(13);

        Nodetest.Node first = nodetest.removelastKthNode(nodetest.first, 3);
        nodetest.removelastKthNode(nodetest.first, 3);
        System.out.println();

        Iterator<Integer> iterator = nodetest.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }


}

