package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._03binaryTree;

//叶子节点就是没有左右子节点的节点
//二叉树的最小深度  根节点到最近叶子节点的距离。
//二叉树的最大深度  根节点到最远叶子节点的距离。
public class _01MinDepth {
    public static void main(String[] args) {
        Node head = HeadSample.generateHeadSample();
        _01MinDepth obj = new _01MinDepth();

        int resMin = obj.minDepth(head);
        int resMax = obj.maxDepth(head);
        System.out.println(resMin);
        System.out.println(resMax);
    }

    private int maxDepth(Node head) {
        if (head == null) {
            return 0;
        }
        return handleMax(head, 1);
    }

    private int handleMax(Node cur, int level) {
        if (cur.right == null && cur.left == null) {
            return level;
        }
        int temp = Integer.MIN_VALUE;
        if (cur.left != null) {
            temp = Math.max(temp, handleMax(cur.left, level + 1));
        }

        if (cur.right != null) {
            temp = Math.max(temp, handleMax(cur.right, level + 1));
        }

        return temp;

    }

    private int minDepth(Node head) {
        if (head == null) {
            return 0;
        }
        return handleMin(head, 1);
    }

    /**
     * 参数：节点cur所在的深度为level
     * 方法意义：
     * 从当前节点cur 往下搜索  返回离head得最小深度； 如果handle是这么定义 那么temp 就是 最小深度 没问题
     *
     * @param cur
     * @param level
     * @return
     */
    private int handleMin(Node cur, int level) {
        if (cur.right == null && cur.left == null) {
            return level;
        }

        int temp = Integer.MAX_VALUE;
        if (cur.left != null) {
            temp = Math.min(temp, handleMin(cur.left, level + 1));
        }

        if (cur.right != null) {
            temp = Math.min(temp, handleMin(cur.right, level + 1));
        }

        return temp;

    }


}
