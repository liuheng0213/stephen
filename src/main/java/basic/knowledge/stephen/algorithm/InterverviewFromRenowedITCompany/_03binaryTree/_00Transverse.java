package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._03binaryTree;

import java.util.Stack;

//非递归递归二叉树
public class _00Transverse {
    public static void main(String[] args) {
        Node head = HeadSample.generateHeadSample();
        _00Transverse obj = new _00Transverse();
        //obj.inTransverse(head);
        //obj.preTransverse(head);
        obj.postTransverse(head);
        System.out.println("===========");
        obj.postTransverseRec(head);
    }


    /**
     * @param head
     */
    private void postTransverseRec(Node head) {

    }

    /**
     * 和前序的比较, 八前序的倒入  stack2中
     * @param head
     */
    private void postTransverse(Node head) {

    }


    //先序
    public void preTransverse(Node head) {

    }


    //中序
    public void inTransverse(Node head) {


    }
}
