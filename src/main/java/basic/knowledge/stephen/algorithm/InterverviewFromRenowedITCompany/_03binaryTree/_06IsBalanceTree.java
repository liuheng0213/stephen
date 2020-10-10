package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._03binaryTree;

public class _06IsBalanceTree {
    public static void main(String[] args) {
        Node head = new Node(-3);
        head.left = new Node(-5);
        head.left.left = new Node(-6);
        head.left.right = new Node(-4);


        head.right = new Node(9);
        head.right.left = new Node(7);
        head.right.right = new Node(11);
        head.right.right.left = new Node(10);
        head.right.right.right = new Node(14);
        head.right.right.right.left = new Node(13);

        _06IsBalanceTree obj = new _06IsBalanceTree();
        boolean isBalanced = obj.isBalancedTree(head);
        System.out.println(isBalanced);
    }

    private boolean isBalancedTree(Node node) {
        ReturnType returnType = process(node);
        return returnType.isBalanced;
    }

    /**
     * 判断自身是否balanced
     *
     * @param node
     * @return
     */
    private ReturnType process(Node node) {
        if (node == null) {
            return new ReturnType(true, true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        ReturnType leftData = process(node.left);
        ReturnType rightData = process(node.right);

        int min = Math.min(Math.min(leftData.min, rightData.min), node.value);
        int max = Math.max(Math.max(leftData.max, rightData.max), node.value);
        Boolean isBST = false;
        if (node.value >= leftData.max && node.value <= rightData.min
                && leftData.isBST && rightData.isBST) {
            isBST = true;
        }

        Boolean isBalanced = false;
        if (isBST) {
            isBalanced = leftData.isBalanced && rightData.isBalanced
                    && Math.abs(leftData.height - rightData.height) < 2;
        }

        int height = Math.max(leftData.height, rightData.height) + 1;

        return new ReturnType(isBST, isBalanced, height, min, max);
    }


    class ReturnType {
        boolean isBST;
        boolean isBalanced;
        int height;
        int min;
        int max;


        public ReturnType(boolean isBST, boolean isBalanced, int height, int min, int max) {
            this.isBST = isBST;
            this.isBalanced = isBalanced;
            this.height = height;
            this.min = min;
            this.max = max;
        }
    }
}
