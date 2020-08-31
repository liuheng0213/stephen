package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._09others;


//画匠问题
//根据之前刷题的经验，求最大中的最小，或者最小中的最大，要么是二分，要么是动态规划。
public class _22Artisan {
    public static void main(String[] args) {
        _22Artisan artisan = new _22Artisan();
        int[] arr = new int[]{ 3, 1, 4, 3, 5};
        int num = 3;
        int res = artisan.solution1(arr, num);
        System.out.println("no space compress  " + res);
        int res1 = artisan.solution2_space_compress(arr, num);
        System.out.println("space compress   " + res1);
        int res2 = artisan.solution4ByDivideAndConquer(arr, num);
        System.out.println("二分查找 : " + res2);
    }

    /**
     * @param arr
     * @param num
     * @return
     */
    private int solution4ByDivideAndConquer(int[] arr, int num) {
        if (arr == null || arr.length == 0 || num < 1) {
            throw new RuntimeException("err");
        }
        if (arr.length < num) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < arr.length; i++) {
                max = Math.max(max, arr[i]);
            }
            return max;
        } else {
            int minSum = 0;
            int maxSum = 0;
            for (int i = 0; i < arr.length; i++) {
                maxSum += arr[i];
            }
            int mid = 0;
            //这里不要有个 if (getNeedNum(arr, mid) == num) 返回一个mid  这里不会有精确值
            while (minSum <= maxSum) {
                mid = (minSum + maxSum) / 2;
                if (getNeedNum(arr, mid) > num) {//每个画匠画画总时间小于等于lim(mid) 且 画匠数大于 num 说明lim(mid)设置得太小了
                    minSum = mid + 1;
                }
                // getNeedNum(arr, mid) ==  num  说明 lim(mid)的情况下需要num  能说明 mid 设置的恰到好处么
                // 如同MinMaxDivision  需要的是  每个画匠画画总时间小于等于lim(mid) 且 画匠数小于等于 num
                // 说明lim 偏大
                else {
                    maxSum = mid - 1;
                }
            }
            return minSum;
        }
    }

    /**
     * 这里求出的是 limit下的最大num
     *  res lim 是 负相关的 lim越小 res越大
     * @param arr
     * @param lim
     * @return
     */
    private int getNeedNum(int[] arr, int lim) {
        int res = 1;//画匠数
        int stepSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > lim) {
                return Integer.MAX_VALUE;//返回最大 ,
            }

            stepSum += arr[i];
            if (stepSum > lim) {
                res++;
                stepSum = arr[i];
            }
        }
        return res;
    }

    /**
     * 空间压缩解
     * 空间压缩 除了  压缩空间  往往又其他好处  比如本题  i > j  的 不需要  更新 直接往下复制
     * O(n^2 * num)
     *
     * @param arr
     * @param num
     * @return
     */
    private int solution2_space_compress(int[] arr, int num) {
        if (arr == null || arr.length == 0 || num < 1) {
            throw new RuntimeException("err");
        }
        //画匠数 大于 画数  数据压缩不需要
       /* if (num > arr.length) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < arr.length; i++) {
                max = Math.max(max, arr[i]);
            }
            return max;
        }*/
        int[] sumArr = new int[arr.length];
        int[] map = new int[arr.length];  //初始 对应的是 i= 1 即一个画匠
        sumArr[0] = arr[0];
        map[0] = arr[0];
        //base case
        for (int i = 1; i < sumArr.length; i++) {
            sumArr[i] = sumArr[i - 1] + arr[i];
            map[i] = sumArr[i];//画匠数为1时的初始值
        }
        for (int i = 1; i <= num - 1; i++) {
            //和 非空间压缩不一样 必须倒着j-- 否则会提前修改map[k]  倒叙 不会 因为你是k < j 不会提前改 这和dp[][] 不一样的
            //空间压缩  有隐患  最好直接用dp
            for (int j = arr.length - 1; j >= i; j--) {  //已经是i > j的话 map[j] 不动  用上一次的
                int min = Integer.MAX_VALUE;
                for (int k = i - 1; k < j; k++) {
                    int cur = Math.max(sumArr[j] - sumArr[k], map[k]);
                    min = Math.min(cur, min);
                }
                map[j] = min;//i== 1时进来的map , 运行完 这是i == 2的那一行了
            }
        }
        return map[arr.length - 1];
    }

    /**
     * 如果5个人干三幅画  那么最大值就是 三幅画某一幅的的最大工作能够时间
     * 与上面数据压缩solution2_space_compress 的方法比 有个问题:  如果 i >j 是没有值的
     * O(n^2 * num)
     *
     * @param arr
     * @param num
     * @return
     */
    private int solution1(int[] arr, int num) {
        if (arr == null || arr.length == 0 || num < 1) {
            throw new RuntimeException("err");
        }
        //画匠数 大于 画数
        /*if (num > arr.length) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < arr.length; i++) {
                max = Math.max(max, arr[i]);
            }
            return max;
        }*/
        //row 是 画匠数
        //dp[i][j]  代表i个画匠搞定srr[0...j]这些画所需要的最少时间
        int[][] dp = new int[num + 1][arr.length];
        int[] sumArr = new int[arr.length];
        sumArr[0] = arr[0];
        dp[1][0] = arr[0];
        //base case
        for (int i = 1; i < sumArr.length; i++) {
            sumArr[i] = sumArr[i - 1] + arr[i];
            dp[1][i] = sumArr[i];// 初始状态  1个画匠搞定i幅画  最少时间是sumArr[i]
        }
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = arr[0];
        }
        for (int i = 2; i < dp.length; i++) {//画匠数
            //第j幅画,  倒遍历 正遍历都可以, 因为dp[1][...]是有值的 所以可以倒遍历
            //无论哪个方向 都不会修改dp[i - 1][xxx]
            for (int j = 1; j <= dp[0].length - 1; j++) {
                if (j >= i) {
                    int min = Integer.MAX_VALUE;
                    for (int k = i - 1; k < j; k++) {
                        //找到最小min值 k 有多种可能
                        int cur = Math.max(dp[i - 1][k], sumArr[j] - sumArr[k]);
                        min = Math.min(min, cur);
                    }
                    dp[i][j] = min;
                } else {
                    dp[i][j] = dp[i - 1][j];// dp[i-1][j] 是j >= i的边界
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];


    }

}
