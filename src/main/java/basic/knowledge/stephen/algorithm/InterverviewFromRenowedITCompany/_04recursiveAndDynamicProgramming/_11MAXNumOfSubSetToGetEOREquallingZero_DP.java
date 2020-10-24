package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;

import java.util.HashMap;
import java.util.Map;


//异或为零的小数组 最多有多少个
public class _11MAXNumOfSubSetToGetEOREquallingZero_DP {
    public static void main(String[] args) {
        _11MAXNumOfSubSetToGetEOREquallingZero_DP maxNumOfSubSetToGetEOREquallingZero = new _11MAXNumOfSubSetToGetEOREquallingZero_DP();
        int[] arr = new int[]{0, 2, 1, 9, 0, 7, 0, 2, 1, 3};
        int res = maxNumOfSubSetToGetEOREquallingZero.mostEOR(arr);
        System.out.println(res);
    }

    private int mostEOR(int[] arr) {
        if (arr == null) {
            return 0;
        }

        int[] dp = new int[arr.length];

        Map<Integer, Integer> eorMap = new HashMap<>();//记录0--i的异或值
        eorMap.put(0, -1);//初始状态, 数组和为0个
        dp[0] = arr[0] == 0 ? 1 : 0;
        eorMap.put(arr[0], 0);
        int eor = 0;
        for (int i = 1; i < arr.length; i++) {
            eor ^= arr[i];
            int preEorIndex = 0;
            if (eorMap.containsKey(eor)) {
                preEorIndex = eorMap.get(eor);
                //wrong
                // if preEorIndex == -1  so preEorIndex == 0 ;
                // 要是arr[0] == arr[preEorIndex] == 1
                //则 dp[0] = 2;  肯定不对!
                preEorIndex = preEorIndex == -1 ? 0 : preEorIndex;

                //correct
                dp[i] = preEorIndex == -1 ? 1 : dp[preEorIndex] + 1;
            }

            dp[i] = Math.max(dp[i - 1], dp[i]);
            eorMap.put(eor, i);
        }
        return dp[arr.length - 1];

    }
}
