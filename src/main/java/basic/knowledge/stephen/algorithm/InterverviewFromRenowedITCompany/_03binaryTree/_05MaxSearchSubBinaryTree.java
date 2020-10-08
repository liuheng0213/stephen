package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._03binaryTree;

/**
 * 二叉树的最大搜索二叉子树
 * 05 06 套路要记住：
 * 二叉树的dp
 */
public class _05MaxSearchSubBinaryTree {

    public static void main(String[] args) {
        Node node = new Node(6);
        node.left = new Node(1);
        node.left.left = new Node(0);
        node.left.right = new Node(3);


        node.right = new Node(12);
        node.right.left = new Node(10);
        node.right.right = new Node(13);
        node.right.right.left = new Node(20);
        node.right.right.right = new Node(16);

        node.right.left.left = new Node(4);
        node.right.left.right = new Node(14);

        node.right.left.left.left = new Node(2);
        node.right.left.left.right = new Node(5);
        node.right.left.right.left = new Node(11);
        node.right.left.right.right = new Node(15);
        _05MaxSearchSubBinaryTree obj = new _05MaxSearchSubBinaryTree();
        Node res = obj.process(node).maxBSTHead;
        System.out.println(res.value);
    }

    /**
     * node (含)
     * 以下的 min max
     * maxBSTHead maxBSTSize
     *
     * @param node
     * @return
     */
    private ReturnType process(Node node) {
        if (node == null) {
            return new ReturnType(null, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        ReturnType leftData = process(node.left);
        ReturnType rightData = process(node.right);
        int min = Math.min(Math.min(leftData.min, rightData.min), node.value);
        int max = Math.max(Math.max(leftData.max, rightData.max), node.value);
        int maxBSTSize = Math.max(leftData.maxBSTSize, rightData.maxBSTSize);
        Node maxBSTHead = leftData.maxBSTSize > rightData.maxBSTSize ? leftData.maxBSTHead : rightData.maxBSTHead;
        if (node.left == leftData.maxBSTHead && node.right == rightData.maxBSTHead
                && node.value >= leftData.max && node.value <= rightData.min) {
            maxBSTHead = node;
            maxBSTSize = leftData.maxBSTSize + rightData.maxBSTSize + 1;
        }
        return new ReturnType(maxBSTHead, min, max, maxBSTSize);
    }

    class ReturnType {
        Node maxBSTHead;
        int min;
        int max;
        int maxBSTSize;

        public ReturnType(Node maxBSTHead, int min, int max, int maxBSTSize) {
            this.maxBSTHead = maxBSTHead;
            this.min = min;
            this.max = max;
            this.maxBSTSize = maxBSTSize;
        }
    }
}
