package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._03binaryTree;

import java.util.Stack;

/**
 * 非递归遍历前序中序后序二叉树
 */
public class TransverseBTByUnrecur {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.left.left = new Node(4);
        head.left.left.right = new Node(6);
        head.left.left.right.right = new Node(7);

        head.right = new Node(3);
        head.right.left = new Node(5);
        head.right.left.left = new Node(10);

        TransverseBTByUnrecur transverseBTByUnrecur = new TransverseBTByUnrecur();
        transverseBTByUnrecur.transeverseInUnrecur(head);
    }
    public void transeversePreUnrecur(Node root) {
        if (root != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                root = stack.pop();
                System.out.println(root.value + " ");
                if (root.right != null) {
                    stack.push(root.right);
                }
                if (root.left != null) {
                    stack.push(root.left);
                }
            }
        }
    }

    public void transeverseInUnrecur(Node root) {
        if (root != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    System.out.println(root.value + " ");
                    root = root.right;
                }
            }
        }
    }

    public void transeversePostUnrecur(Node root) {
        if (root != null) {
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            stack1.push(root);
            while (!stack1.isEmpty()) {
                root = stack1.pop();
                stack2.push(root);
                if (root.left != null) {
                    stack1.push(root.left);
                }
                if (root.right != null) {
                    stack1.push(root.right);
                }
            }
            while (!stack2.isEmpty()) {
                System.out.println(stack2.pop().value + " ");
            }

        }
    }
}
