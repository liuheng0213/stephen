package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._02linkedList;

import java.util.Stack;

//删除无序单链表中值重复出向的节点
public class _14DelNodeWithDesignatedValue {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(3);
        node.next.next.next.next = new Node(4);
        node.next.next.next.next.next = new Node(4);
        node.next.next.next.next.next.next = new Node(2);
        node.next.next.next.next.next.next.next = new Node(1);
        node.next.next.next.next.next.next.next.next = new Node(1);

        _14DelNodeWithDesignatedValue obj = new _14DelNodeWithDesignatedValue();
        //Node res = obj.removeValue1(node, 1);
        Node res = obj.removeValue2(node, 1);
        System.out.println(res.value);
    }

    /**
     * 先找到第一个不等于 value的节点  然后往后遍历 所有的 = num 的都删掉
     *
     * @param head
     * @param num
     * @return
     */
    private Node removeValue2(Node head, int num) {
        //先找到不等于 Num的第一个点作为起始点  否则  较难以实现
        while (head != null) {
            if (head.value != num) {
                break;
            }
            head = head.next;
        }

        //initial head.value != num
        Node pre = null;
        Node cur = head;
        while (cur != null) {
            if (cur.value == num) {
                pre.next = cur.next;

            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    /**
     * 用栈进入后倒出来
     *
     * @param head
     * @param num
     * @return
     */
    private Node removeValue1(Node head, int num) {
        Stack<Node> stack = new Stack<>();
        while (head != null) {
            if (head.value != num) {
                stack.push(head);
            }
            head = head.next;
        }

        //initial head == null
        while (!stack.isEmpty()) {
            stack.peek().next = head;
            head = stack.pop();
        }

        return head;
    }


}
