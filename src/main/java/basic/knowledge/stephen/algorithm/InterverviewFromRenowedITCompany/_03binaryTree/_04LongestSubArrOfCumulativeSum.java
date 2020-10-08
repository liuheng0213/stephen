package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._03binaryTree;

import java.util.HashMap;
//二叉树的节点和等于targetSum的最大深度
public class _04LongestSubArrOfCumulativeSum {
    public static void main(String[] args) {
        _04LongestSubArrOfCumulativeSum obj = new _04LongestSubArrOfCumulativeSum();
        Node head = new Node(-3);
        head.left = new Node(3);
        head.left.left = new Node(1);
        head.left.right = new Node(0);
        head.left.right.left = new Node(1);
        head.left.right.right = new Node(6);
        head.left.right.right.left = new Node(-2);
        head.left.right.right.right = new Node(-8);

        head.right = new Node(-9);
        head.right.left = new Node(2);
        head.right.right = new Node(1);
        head.right.right.right = new Node(5);
        head.right.right.left = new Node(7);
        head.right.right.right.left = new Node(15);
        head.right.right.right.left.left = new Node(-4);
        head.right.right.right.left.left.left = new Node(10);


        int res = obj.maxLen(head, 5);
        System.out.println(res);

    }

    /**
     * 从head往下查找求出最大的length
     * @param head
     * @param targetSum
     * @return
     */
    private int maxLen(Node head, int targetSum) {
        if (head == null) {
            return 0;
        }
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 0);//key 是sum , value 是 level
        return getMaxLen(sumMap, head, 0, 0, 1, targetSum);
    }

    private int getMaxLen(HashMap<Integer, Integer> sumMap,
                          Node cur,
                          int maxLen, int preSum,
                          int level, int targetSum) {
        if (cur == null) {
            return maxLen;
        }

        int curSum = preSum + cur.value;
        if (!sumMap.containsKey(curSum)) {
            sumMap.put(curSum, level);
        }

        if (sumMap.containsKey(curSum - targetSum)) {
            maxLen = Math.max(maxLen, level - sumMap.get(curSum - targetSum));
        }

        //试想 没有必要max函数了,注意getMaxLen的方法意义
        maxLen = Math.max(maxLen, getMaxLen(sumMap, cur.left, maxLen, curSum, level + 1, targetSum));
        maxLen = Math.max(maxLen, getMaxLen(sumMap, cur.right, maxLen, curSum, level + 1, targetSum));

        return maxLen;

    }


}
