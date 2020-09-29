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
        return null;
    }

    private Node generateNodeByStack(Stack<String> stack) {
        return null;
    }

    private Node getNode(String pop) {
        return null;
    }

    /**
     * 方法含义:
     * head 自己单节点序列化 加上其子节点的序列化 并返回序列化字符串
     *
     * @param head
     * @return
     */
    private String serializeByPre2(Node head) {
        return null;
    }

    /**
     * 序列化二叉树
     *
     * @param head
     * @return
     */
    private String serializeByPre(Node head) {
        return null;
    }

    /**
     * cur (含)的序列化 并加到str 上返回
     * 这个递归 类似  二叉树的最大深度
     * @param cur
     * @param str
     * @return
     */
    private String serializeByPre(Node cur, String str) {
        return null;
    }

    /**
     * 反序列化先序二叉树字符串
     *
     * @param str
     * @return
     */
    private Node deSerialByString(String str) {
        return null;

    }

    /**
     * c从linkedlist中取出一个head 并构成其子节点
     *
     * @param nodeQueue
     * @return
     */
    private Node generateNode(LinkedList<String> nodeQueue) {
        return null;
    }


}
