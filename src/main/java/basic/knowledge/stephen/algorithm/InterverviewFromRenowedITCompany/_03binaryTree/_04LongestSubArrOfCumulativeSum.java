package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._03binaryTree;

import java.util.HashMap;

public class _04LongestSubArrOfCumulativeSum {
    public static void main(String[] args) {
        _04LongestSubArrOfCumulativeSum longestSubArrOfCumulativeSum = new _04LongestSubArrOfCumulativeSum();
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
        head.right.right.right.left.left.left= new Node(10);

        for (int i = -20; i <= 55; i++) {
            int res = longestSubArrOfCumulativeSum.maxLen(head, i);
            System.out.println(res);
            int res1 = longestSubArrOfCumulativeSum.maxLen1(head, i);
            System.out.println(res1);
            System.out.println("i == :" + i+ "===>" +  (res == res1));
            if (res != res1) {
                System.out.println("i == :" + i+ "===>" +  (res == res1));
            }
        }

    }

    private int maxLen(Node node, int k) {
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 0);
        return process(node, k, 0, 1, 0, sumMap);
    }

    private int process(Node node, int k, int preSum, int level, int maxLen, HashMap<Integer, Integer> sumMap) {
        if (node == null) {
            return maxLen;
        }
        int curSum = node.value + preSum;
        if (!sumMap.containsKey(curSum)) {
            sumMap.put(curSum, level);
        }
        if (sumMap.containsKey(curSum - k)) {
            maxLen = Math.max(maxLen, level - sumMap.get(curSum - k));
        }

        maxLen = process(node.left, k, curSum, level + 1, maxLen, sumMap);
        maxLen = process(node.right, k, curSum, level + 1, maxLen, sumMap);

        if (level == sumMap.get(curSum)) {
            sumMap.remove(curSum);
        }
        return maxLen;
    }

    private int maxLen1(Node node, int k) {
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 0);
        return process1(node, k, 0, 1, 0, sumMap);
    }

    /**
     *   if(level == sumMap.get(curSum)){
         sumMap.remove(curSum);
          }   这行代码 没用
     * @param node
     * @param k
     * @param preSum
     * @param level
     * @param maxLen
     * @param sumMap
     * @return
     */
    private int process1(Node node, int k, int preSum, int level, int maxLen, HashMap<Integer, Integer> sumMap) {
        if (node == null) {
            return maxLen;
        }
        int curSum = node.value + preSum;
        if (!sumMap.containsKey(curSum)) {
            sumMap.put(curSum, level);
        }
        if (sumMap.containsKey(curSum - k)) {
            maxLen = Math.max(maxLen, level - sumMap.get(curSum - k));
        }

        maxLen = process(node.left, k, curSum, level + 1, maxLen, sumMap);
        maxLen = process(node.right, k, curSum, level + 1, maxLen, sumMap);

      /*  if(level == sumMap.get(curSum)){
            sumMap.remove(curSum);
        }*/
        return maxLen;
    }


}
