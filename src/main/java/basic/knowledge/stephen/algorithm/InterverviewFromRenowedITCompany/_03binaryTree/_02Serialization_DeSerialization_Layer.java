package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._03binaryTree;


import java.util.LinkedList;

/**
 * 按层级遍历序列化和反序列化
 */
public class _02Serialization_DeSerialization_Layer {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.left.left = new Node(4);
        head.left.left.right = new Node(6);
        head.left.left.right.right = new Node(7);

        head.right = new Node(3);
        head.right.left = new Node(5);
        head.right.left.left = new Node(10);


        _02Serialization_DeSerialization_Layer object = new _02Serialization_DeSerialization_Layer();
        String reStr = object.serialize(head);
        System.out.println(reStr);
        head = object.deSerialize(reStr);
        System.out.println(head);
    }

    public Node deSerialize(String str) {
        if (str == null) {
            return null;
        }

        int index = 0;
        String[] strs = str.split("!");

        //错了 不能 一次都放入队列  要放一个 一个有父子关系的bundle
//        LinkedList<Node> queue = new LinkedList<>();
//        for (String s : strs) {
//            if (!s.equals("#")) {
//                queue.addLast(new Node(Integer.valueOf(s)));
//            }
//        }
//

        LinkedList<Node> queue = new LinkedList<>();

        Node head = null;
        if (!strs[index].equals("#")) {
            head = new Node(Integer.valueOf(strs[index++]));
            queue.addLast(head);
        } else {
            return null;
        }

        Node cur = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            Node subNode = generateNode(strs[index++]);
            if (subNode != null) {
                cur.left = subNode;
                queue.addLast(subNode);
            }

            subNode = generateNode(strs[index++]);
            if (subNode != null) {
                cur.right = subNode;
                queue.addLast(subNode);
            }
        }
        return head;
    }

    private Node generateNode(String str) {
        if ("#".equals(str)) {
            return null;
        }
        return new Node(Integer.parseInt(str));
    }

    public String serialize(Node head) {
        if (head == null) {
            return "#!";
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(head);
        String res = String.valueOf(head.value) + "!";

        Node cur = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (cur.left != null) {
                queue.addLast(cur.left);
                res += String.valueOf(cur.left.value) + "!";
            } else {
                res += "#!";
            }
            if (cur.right != null) {
                queue.addLast(cur.right);
                res += String.valueOf(cur.right.value) + "!";
            } else {
                res += "#!";
            }
        }
        return res;
    }


}
