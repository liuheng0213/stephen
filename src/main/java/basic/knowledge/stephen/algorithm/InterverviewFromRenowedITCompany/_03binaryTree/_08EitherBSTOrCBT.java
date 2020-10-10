package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._03binaryTree;

import java.util.LinkedList;

/**
 * 判断一棵树 要么是否为搜索二叉树
 * 是否为完全二叉树
 */
public class _08EitherBSTOrCBT {
    public static void main(String[] args) {
        Node head = new Node(4);

        head.left = new Node(2);
        //head.left.left = new Node(1);
        //head.left.right = new Node(9);

        head.right = new Node(6);
        //head.right.left = new Node(5);
        //head.right.right = new Node(7);
        _08EitherBSTOrCBT bSTOrCBT = new _08EitherBSTOrCBT();
        //boolean isBST = bSTOrCBT.isBSTByRecursive(head);
        //boolean isBST = bSTOrCBT.isBST(head);
        boolean isCBT = bSTOrCBT.isCBT(head);
        System.out.println(isCBT);
    }

    private boolean isBSTByRecursive(Node head) {
        return process(head).isBST;
    }

    private ReturnType process(Node node) {
        if (node == null) {
            return new ReturnType(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }
        ReturnType leftData = process(node.left);
        ReturnType rightData = process(node.right);
        int min = Math.min(node.value, Math.min(leftData.min, rightData.min));
        int max = Math.max(node.value, Math.max(leftData.max, rightData.max));

        boolean isBST = leftData.isBST && rightData.isBST
                && node.value >= leftData.max && node.value <= rightData.min;

        return new ReturnType(min, max, isBST);
    }

    /**
     * 检查是否完全二叉树
     * 关键是要检查到所有的点
     * <p>
     * 完全二叉树 有个特点
     * 1  左节点没有填， 不能跳过它填右节点
     * 2  不可能 右节点没填就将新的节点填在当前节点的子节点
     *
     * @param head
     * @return
     */
    private boolean isCBT(Node head) {
        if (head == null) {
            return true;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(head);
        boolean leaf = false;// true 左边的节点只有左子节点,没有右子节点;false 没有意义
        Node left = null;
        Node right = null;
        while (!queue.isEmpty()) {
            head = queue.poll();
            left = head.left;
            right = head.right;
            if ((leaf && (left != null || right != null)) || (left == null && right != null)) {
                return false;
            }
            if(left != null){
                queue.addLast(left);
            }
            if(right != null){
                queue.addLast(right);
            }else{
                leaf = true;
            }
        }
        return true;
    }


    class ReturnType {
        public boolean isBST;
        public int min;
        public int max;

        public ReturnType(int min, int max, boolean isBST) {
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }
}
