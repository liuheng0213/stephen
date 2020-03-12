package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._03BinaryTree;

/**
 * 判断一棵树 要么是否为搜索二叉树
 * 是否为完全二叉树
 */
public class _08EitherBSTOrCBT {
    public static void main(String[] args) {
        Node head = new Node(4);

        head.left = new Node(2);
        head.left.left = new Node(1);
        head.left.right = new Node(9);

        head.right = new Node(6);
        head.right.left = new Node(5);
        head.right.right = new Node(7);
        _08EitherBSTOrCBT bSTOrCBT = new _08EitherBSTOrCBT();
        //boolean isBST = bSTOrCBT.isBSTByRecursive(head);
        boolean isBST = bSTOrCBT.isBST(head);
        //boolean isCBT = bSTOrCBT.isCBT(head);
        System.out.println(isBST);
    }

    private boolean isBSTByRecursive(Node node) {
        ReturnType returnType = process(node);
        return returnType.isBST;
    }

    private ReturnType process(Node node) {
        if (node == null) {
            return new ReturnType(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }

        ReturnType leftReturnType = process(node.left);
        ReturnType rightReturnType = process(node.right);

        int min = Math.min(node.value, Math.min(leftReturnType.min, rightReturnType.min));
        int max = Math.max(node.value, Math.max(leftReturnType.max, rightReturnType.max));

        if (leftReturnType.isBST && rightReturnType.isBST
                && node.value >= leftReturnType.max && node.value <= rightReturnType.min) {
            return new ReturnType(min, max, true);
        }
        return new ReturnType(min, max, false);
    }

    private boolean isCBT(Node node) {
        if (node == null) {
            return false;
        }
        return false;
    }

    private boolean isBST(Node node) {
        if (node == null) {
            return true;
        }
        boolean isBST = true;
        Node preCur = null;
        Node cur = node;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;//因为mostRight是左子树上的最优节点
            if (mostRight != null) {// 因为有可能cur.left == null， 也就是 有可能没有左子树
                //找到最右子节点
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }

                //此时要么mostRight.right == null  要么 mostRight.right == cur
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }

            if (preCur != null && cur.value < preCur.value) {
                isBST = false;
            }

            preCur = cur;
            //cur 没有左子树
            cur = cur.right;
        }
        return isBST;
    }

    static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    static class ReturnType {
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
