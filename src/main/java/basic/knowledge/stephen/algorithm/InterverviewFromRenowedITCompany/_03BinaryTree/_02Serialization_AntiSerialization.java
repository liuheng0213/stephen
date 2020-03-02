package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._03BinaryTree;


import java.util.LinkedList;
import java.util.Queue;

public class _02Serialization_AntiSerialization {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.left.left = new Node(4);
        head.left.left.right = new Node(6);
        head.left.left.right.right = new Node(7);

        head.right = new Node(3);
        head.right.left = new Node(5);
        head.right.left.left = new Node(10);


        _02Serialization_AntiSerialization serialization_antiSerialization = new _02Serialization_AntiSerialization();
        String reStr = serialization_antiSerialization.serialByPre(head);
        System.out.println(reStr);
        head = serialization_antiSerialization.antiSerialByPre(reStr);
        System.out.println(head);
    }

    private Node antiSerialByPre(String str) {
        String[] values = str.split("!");
        Queue<String> queue = new LinkedList<>();
        for (String s : values) {
            queue.add(s);
        }
        return resonPreOrder(queue);
    }

    /**
     * 将队列queue中存的元素 反序列化为二叉树
     * 递归每一层 把queue 的第一个元素 安装后 返回
     *
     * @param queue
     * @return
     */
    private Node resonPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.left = resonPreOrder(queue);
        head.right = resonPreOrder(queue);
        return head;
    }

    /**
     * 方法含义：
     * 从head开始 序列化二叉树
     *
     * @param head
     * @return
     */
    private String serialByPre(Node head) {
        if (head == null) {
            return "#!";
        }
        String res = head.value + "!";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }


    static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}
