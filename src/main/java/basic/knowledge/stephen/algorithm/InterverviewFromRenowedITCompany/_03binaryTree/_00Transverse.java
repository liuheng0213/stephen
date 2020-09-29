package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._03binaryTree;

import java.util.Stack;

//非递归 和递归  遍历二叉树
public class _00Transverse {
    public static void main(String[] args) {
        Node head = HeadSample.generateHeadSample();
        _00Transverse obj = new _00Transverse();
        System.out.println("---------------中序遍历开始-------------------");
        obj.inTransverse(head);
        System.out.println("===========");
        obj.inTransverseRecur(head);

        System.out.println("----------------前序遍历开始------------------");
        obj.preTransverse(head);
        System.out.println("===========");
        obj.preTransverseRecur(head);

        System.out.println("---------------后续遍历开始-------------------");
        obj.postTransverse(head);
        System.out.println("===========");
        obj.postTransverseRec(head);


    }


    /**
     * @param head
     */
    private void postTransverseRec(Node head) {
        if (head == null) {
            return;
        }
        postTransverseRec(head.left);
        postTransverseRec(head.right);
        System.out.println(head.value);
    }

    /**
     * 和前序的比较, 把前序的倒入  stack2中
     *
     * @param head
     */
    private void postTransverse(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(head);

        while (!stack1.isEmpty()) {
            head = stack1.pop();
            stack2.push(head);
            if (head.left != null) {
                stack1.push(head.left);
            }
            if (head.right != null) {
                stack1.push(head.right);
            }
        }

        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop().value);
        }
    }


    //先序非递归
    public void preTransverse(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(head);

        while (!stack.isEmpty()) {
            head = stack.pop();
            System.out.println(head.value);
            if (head.right != null) {
                stack.push(head.right);
            }

            if (head.left != null) {
                stack.push(head.left);
            }
        }
    }

    //前序递归
    public void preTransverseRecur(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.value);
        preTransverseRecur(head.left);
        preTransverseRecur(head.right);
    }


    //中序非递归
    public void inTransverse(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();

        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.println(head.value);
                head = head.right;
            }
        }
    }

    //中序递归
    public void inTransverseRecur(Node head) {
        if (head == null) {
            return;
        }
        inTransverseRecur(head.left);
        System.out.println(head.value);
        inTransverseRecur(head.right);
    }
}
