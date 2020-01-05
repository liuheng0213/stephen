package basic.knowledge.stephen.algorithm.divideAndConquer;

/**
 * 求和最大的子数组
 * 源自算法导论
 */
public class MaxSumSubArray {

    public static void main(String[] args) {
        int[] arr = new int[]{100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106, 101, 79, 94, 90, 97};
        int res = findMaxSum(arr);
        System.out.println(res);
    }

    private static int findMaxSum(int[] arr) {
        int[] diffValue = new int[arr.length - 1];
        for (int i = 1; i < arr.length; i++) {
            diffValue[i - 1] = arr[i] - arr[i - 1];
        }
        IndexPair resPair = findMaxSum(diffValue, 0, diffValue.length - 1);
        return getSumByIndex(diffValue, resPair);
    }

    private static IndexPair findMaxSum(int[] diffValue, int left, int right) {
        if (left == right) {
            return new IndexPair(left, left);
        }

        int mid = (left + right) / 2;
        IndexPair indexPairLeft = findMaxSum(diffValue, left, mid);
        IndexPair indexPairRight = findMaxSum(diffValue, mid + 1, right);
        IndexPair indexPairCross = findCrossSubArray(diffValue, left, mid, right);

        int maxSumLeft = getSumByIndex(diffValue, indexPairLeft);
        int maxSumRight = getSumByIndex(diffValue, indexPairRight);
        int maxSumCross = getSumByIndex(diffValue, indexPairCross);
        if (maxSumCross > maxSumLeft && maxSumCross > maxSumRight) {
            return indexPairCross;
        } else if (maxSumLeft > maxSumRight) {
            return indexPairLeft;
        } else {
            return indexPairRight;
        }
    }

    private static int getSumByIndex(int[] diffValue, IndexPair indexPair) {
        int sum = 0;
        for (int i = indexPair.index1; i <= indexPair.index2; i++) {
            sum += diffValue[i];
        }
        return sum;
    }

    private static IndexPair findCrossSubArray(int[] diffValue, int left, int mid, int right) {
        int sum = 0;
        int left_sum = Integer.MIN_VALUE;
        int max_left = 0;
        for (int i = mid; i >= left; i--) {
            sum = sum + diffValue[i];
            if (left_sum < sum) {
                left_sum = sum;
                max_left = i;
            }
        }
        sum = 0;
        int right_sum = Integer.MIN_VALUE;
        int max_right = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum += diffValue[i];
            if (right_sum < sum) {
                right_sum = sum;
                max_right = i;
            }
        }
        return new IndexPair(max_left, max_right);
    }

    static class IndexPair {
        public IndexPair(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
        }

        int index1;
        int index2;

        @Override
        public String toString() {
            return "IndexPair{" +
                    "index1=" + index1 +
                    ", index2=" + index2 +
                    '}';
        }
    }
}
