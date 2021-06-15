package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._03binaryTree;

//叶子节点就是没有左右子节点的节点
//二叉树的最小深度  根节点到最近叶子节点的距离。
//二叉树的最大深度  根节点到最远叶子节点的距离。
public class _01MinDepth {
    public static void main(String[] args) {
        Node head = HeadSample.generateHeadSample();
        _01MinDepth obj = new _01MinDepth();

        int resMin = obj.minDepth(head);
        int resMin2 = obj.minDepth2(head);
        System.out.println(resMin == resMin2);
    }


    private int minDepth(Node head) {
        if (head == null) {
            return 0;
        }
        return getMinDepthFromCur(head);
    }

    private int minDepth2(Node head) {
        if (head == null) {
            return 0;
        }
        return getMinDepthFromCur2(head, 1);
    }

    /**
     * 方法含义：当前节点cur 距离其子节点的最小深度.
     *
     * @param cur

     * @return
     */
    private int getMinDepthFromCur(Node cur) {
        if (cur.left == null && cur.right == null) {
            return 1;
        }
        int min = Integer.MAX_VALUE;
        if (cur.left != null) {
            min = Math.min(getMinDepthFromCur(cur.left), min);
        }
        if (cur.right != null) {
            min = Math.min(getMinDepthFromCur(cur.right), min);
        }
        return min + 1;
    }


    //不同的递归函数定义 有不同的逻辑

    /**
     * 方法意义：
     * 当前节点cur机及其所有子节点  与  head的 最小距离
     * level we
     *
     * @param cur
     * @param level
     * @return
     */
    private int getMinDepthFromCur2(Node cur, int level) {
        if (cur.left == null && cur.right == null) {
            return level;
        }
        int min = Integer.MAX_VALUE;
        if (cur.left != null) {
            min = Math.min(getMinDepthFromCur2(cur.left, level + 1), min);
        }
        if (cur.right != null) {
            min = Math.min(getMinDepthFromCur2(cur.right, level + 1), min);
        }
        return min;
    }


}
