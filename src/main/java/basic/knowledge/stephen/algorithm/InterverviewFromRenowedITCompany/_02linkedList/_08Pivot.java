package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._02linkedList;
//将单项链表按某值划分为左边小,钟检2相等,右边大的形式
//进阶: 且保持原链表相应顺序
public class _08Pivot {
    public static void main(String[] args) {
        _08Pivot pivot = new _08Pivot();
        Node node = new Node(7);
        node.next = new Node(9);
        node.next.next = new Node(1);
        node.next.next.next = new Node(8);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(2);
        node.next.next.next.next.next.next = new Node(5);
//        Node head = pivot.listPartition(node, 5);
//        System.out.println();
        Node headFurther = pivot.listPartition_further(node, 5);
        System.out.println();
    }

    private Node listPartition_further(Node head, int pivot) {
        Node sh = null;
        Node st = null;
        Node eh = null;
        Node et = null;
        Node bh = null;
        Node bt = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value == pivot) {
                if (eh == null) {
                    eh = head;
                    et = head;
                } else {
                    et.next = head;
                    et = head;
                }
            } else if (head.value < pivot) {
                if (sh == null) {
                    sh = head;
                    st = head;
                } else {
                    st.next = head;
                    st = head;
                }
            } else {
                if (bh == null) {
                    bh = head;
                    bt = head;
                } else {
                    bt.next = head;
                    bt = head;
                }
            }
            head = next;
        }
        if (sh != null && eh != null) {
            st.next = eh;
            et.next = bh;
            return sh;
        } else if (sh != null && eh == null) {
            st.next = bh;
            return sh;
        } else if (sh == null && eh != null) {
            et.next = bh;
            return eh;
        } else {
            return bh;
        }

    }


    private Node listPartition(Node head, int pivot) {
        if (head == null) {
            return head;
        }
        int i = 0;
        Node cur = head;
        while (cur != null) {
            i++;
            cur = cur.next;
        }
        Node[] nodeArr = new Node[i];
        cur = head;
        i = 0;
        for (i = 0; i < nodeArr.length; i++) {
            nodeArr[i] = cur;
            cur = cur.next;
        }

        arrPartition(nodeArr, pivot);

        //下面的别忘了  Node 之间的关系  上面的方法已经打乱了
        for (i = 1; i < nodeArr.length; i++) {
            nodeArr[i - 1].next = nodeArr[i];
        }
        return nodeArr[0];

    }

    /**
     * 三向切分的快排
     *
     * @param nodeArr
     * @param pivot
     */
    private void arrPartition(Node[] nodeArr, int pivot) {
        int small = -1;
        int index = 0;
        int big = nodeArr.length;
        while (index <= big) {
            if (nodeArr[index].value < pivot) {
                swap(nodeArr, ++small, index);
            } else if (nodeArr[index].value == pivot) {
                index++;
            } else {
                swap(nodeArr, --big, index);
            }
        }
    }

    private void swap(Node[] nodeArr, int i, int j) {
        Node tempNode = nodeArr[i];
        nodeArr[i] = nodeArr[j];
        nodeArr[j] = tempNode;
    }

}
