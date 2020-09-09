package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._02linkedList;

//在单链表中删除倒数第K个节点
public class _02DeleteBackwardsToK {
    public Node removeLastKthNode(Node node, int lastKth) {
        if (node == null || lastKth < 1) {
            return node;
        }
        Node cur = node;
        while (cur != null) {
            cur = cur.next;
            lastKth--;
        }
        if (lastKth > 0) {
            node = node.next;
            return node;
        }

        if (lastKth <= 0) {
            cur = node;
            while (++lastKth != 0) {
                cur = cur.next;
            }

            cur.next = cur.next.next;
        }

        return node;

    }


}

