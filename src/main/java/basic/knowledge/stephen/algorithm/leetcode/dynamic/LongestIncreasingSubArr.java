package basic.knowledge.stephen.algorithm.leetcode.dynamic;

public class LongestIncreasingSubArr {
    public static void main(String[] args) {
        int[] arr = new int[]{2,4,1,4,5,6,7};
        getLongest(arr,6);
        getLongestBetter(arr,6);
    }

    /**
     * 动态规划
     * @param arr
     * @param i
     */
    private static void getLongestBetter(int[] arr, int i) {
    }

    /**
     * o(n^2)
     * @param arr
     * @param n
     */
    public static void getLongest(int[] arr, int n){
        //存放状态
        int[] d = new int[n];
        //最长非降子序列长度初始化为1
        int length = 1;
        //状态初始化为1
        d[0] = 1;
        for (int i = 1; i < n; i++){
            //状态初始化为1
            d[i] = 1;
            for (int j = 0; j < i; j++){
                if (arr[i] > arr[j] && d[j] + 1 > d[i]){
                    d[i] = d[j] + 1;
                }
                if (length < d[i]){
                    length = d[i];
                }
            }
        }

        System.out.println(length);

    }

}
