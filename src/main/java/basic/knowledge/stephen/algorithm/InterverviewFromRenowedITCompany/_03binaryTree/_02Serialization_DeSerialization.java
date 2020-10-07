package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._03binaryTree;


import java.util.LinkedList;

//先序遍历的序列化与反序列化  这个先序后序  递归比较好 只有层遍历是while
public class _02Serialization_DeSerialization {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.left.left = new Node(4);
        head.left.left.right = new Node(6);
        head.left.left.right.right = new Node(7);

        head.right = new Node(3);
        head.right.left = new Node(5);
        head.right.left.left = new Node(10);


        _02Serialization_DeSerialization object = new _02Serialization_DeSerialization();
        String serRes = object.serializeByPre(head);
        System.out.println(serRes);

        Node newHead = object.deSerialByString(serRes);
        System.out.println();
    }


    /**
     * 方法含义:
     * head 自己单节点序列化 加上其子节点的序列化 并返回序列化字符串
     *
     * @param head
     * @return
     */
    private String serializeByPre(Node head) {
        if (head == null) {
            return "#!";
        }
        String str = String.valueOf(head.value) + "!";
        str += serializeByPre(head.left);
        str += serializeByPre(head.right);
        return str;
    }


    /**
     * 反序列化先序二叉树字符串
     *
     * @param str
     * @return
     */
    private Node deSerialByString(String str) {
        if (str == null || str.equals("#!") || str.equals("#")) {
            return null;
        }
        String[] strs = str.split("!");
        LinkedList<String> queue = new LinkedList<>();
        for (String s : strs) {
            queue.addLast(s);
        }
        return generateNode(queue);


    }

    /**
     * 从linkedlist中取出一个head 并构成其子节点
     *
     * @param nodeQueue
     * @return
     */
    private Node generateNode(LinkedList<String> nodeQueue) {
        Node cur = getNode(nodeQueue.pollFirst());
        if (cur == null) {
            return null;
        }

        cur.left = generateNode(nodeQueue);
        cur.right = generateNode(nodeQueue);
        return cur;
    }

    private Node getNode(String str) {
        if (str.equals("#")) {
            return null;
        }
        return new Node(Integer.valueOf(str));
    }


}
