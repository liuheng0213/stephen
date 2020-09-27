package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._02linkedList;

import java.util.Stack;


//将单链表的美K个节点之间逆序
public class _12ReverseLinkBetweenK {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(6);
        node.next.next.next.next.next.next = new Node(7);
        node.next.next.next.next.next.next.next = new Node(8);
        node.next.next.next.next.next.next.next.next = new Node(9);
        _12ReverseLinkBetweenK obj = new _12ReverseLinkBetweenK();
        Node res = obj.reverseLinkList(node, 4);
        System.out.println(res);

    }

    /**
     * 不太好   reverse  最好是带进  pre(lastNodeInLastStack) next参数, 这样会使得逻辑性好很多
     * 也部制域像我这样改很多次
     *
     * @param head
     * @param k
     * @return
     */

    public Node reverseLinkList(Node head, int k) {
        if (head == null || k < 1) {
            return null;
        }

        Node cur = head;
        Node next = null;
        Node newHead = head;
        Node pre = null;
        Stack<Node> stack = new Stack<>();
        while (cur != null) {
            stack.push(cur);
            next = cur.next;
            if (stack.size() == k) {
                newHead = pre == null ? cur : newHead;
                if (pre != null) {
                    pre.next = cur;
                }
                pre = reverse(stack, next);
            }
            cur = next;

        }
        return newHead;
    }

    private Node reverse(Stack<Node> stack, Node next) {
        Node head = stack.pop();
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            head.next = cur;
            head = cur;
        }
        head.next = next;
        return head;
    }


}
