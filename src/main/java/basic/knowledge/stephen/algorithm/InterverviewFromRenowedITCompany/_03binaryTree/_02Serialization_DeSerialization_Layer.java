package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._03binaryTree;


import java.util.LinkedList;
import java.util.Queue;

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
        if (str == null || str.length() == 0 || "#".equals(str)) {
            return null;
        }
        String[] strs = str.split("!");
        int index = 0;
        Node head = generateNode(strs[index++]);
        Queue<Node> queue = new LinkedList<>();
        if (head != null) {
            queue.add(head);
        }
        Node cur = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            cur.left = generateNode(strs[index++]);
            cur.right = generateNode(strs[index++]);
            if(cur.left != null){
                queue.add(cur.left);
            }
            if(cur.right != null){
                queue.add(cur.right);
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
        String res = head.value + "!";
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while(!queue.isEmpty()){
            head = queue.poll();
            if(head.left != null){
                queue.add(head.left);
                res += head.left.value + "!";
            }else{
                res += "#!";
            }
            if(head.right != null){
                queue.add(head.right);
                res += head.right.value + "!";
            }else{
                res += "#!";
            }
        }
        return res;
    }


}
