package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._03binaryTree;


import org.apache.commons.lang3.StringUtils;

import java.util.LinkedList;
import java.util.Stack;

//线序遍历的序列化与反序列化
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
        String serRes1 = object.serializeByPre(head);
        String serRes2 = object.serializeByPre2(head);
        System.out.println(serRes1);
        System.out.println(serRes2);

        Node newHead1 = object.deSerialByString(serRes1);
        Node newHead2 = object.deSerialByString2(serRes1);
        System.out.println();
    }

    private Node deSerialByString2(String str) {
        if (StringUtils.isEmpty(str) || str.equals("#!")) {
            return null;
        }
        Stack<String> stack = new Stack<>();//linkedlist is ok too
        String[] strs = str.split("!");
        for (String s : strs) {
            stack.push(s);
        }
        return generateNodeByStack(stack);
    }

    private Node generateNodeByStack(Stack<String> stack) {
        Node head = null;
        while(!stack.isEmpty()){
            String pop = stack.pop();
            head = getNode(pop);
            if(head != null){
                head.left = getNode(stack.pop());
                head.right = getNode(stack.pop());
            }
        }
        return head;
    }

    private Node getNode(String pop) {
        if("#".equals(pop)){
            return null;
        }else {
            return new Node(Integer.valueOf(pop));
        }
    }

    /**
     * 方法含义:
     * head 自己单节点序列化 加上其子节点的序列化 并返回序列化字符串
     *
     * @param head
     * @return
     */
    private String serializeByPre2(Node head) {
        if (head == null) {
            return "#!";
        }
        String res = head.value + "!";
        res += serializeByPre2(head.left);
        res += serializeByPre2(head.right);
        return res;
    }

    /**
     * 序列化二叉树
     *
     * @param head
     * @return
     */
    private String serializeByPre(Node head) {
        if (head == null) {
            return "#!";
        }
        String temp = "";
        return serializeByPre(head, temp);
    }

    /**
     * cur (含)的序列化 并加到str 上返回
     * 这个递归 类似  二叉树的最大深度
     * @param cur
     * @param str
     * @return
     */
    private String serializeByPre(Node cur, String str) {
        if (cur == null) {
            str += "#!";
            return str;
        }
        str += cur.value + "!";
        str = serializeByPre(cur.left, str);
        str = serializeByPre(cur.right, str);

        return str;
    }

    /**
     * 反序列化先序二叉树字符串
     *
     * @param str
     * @return
     */
    private Node deSerialByString(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        String[] strs = str.split("!");
        LinkedList<String> nodeQueue = new LinkedList<>();
        for (String s : strs) {
            nodeQueue.addLast(s);
        }

        return generateNode(nodeQueue);

    }

    /**
     * c从linkedlist中取出一个head 并构成其子节点
     *
     * @param nodeQueue
     * @return
     */
    private Node generateNode(LinkedList<String> nodeQueue) {
        String value = nodeQueue.poll();
        if (value.equals("#")) {
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.left = generateNode(nodeQueue);
        head.right = generateNode(nodeQueue);
        return head;
    }


}
