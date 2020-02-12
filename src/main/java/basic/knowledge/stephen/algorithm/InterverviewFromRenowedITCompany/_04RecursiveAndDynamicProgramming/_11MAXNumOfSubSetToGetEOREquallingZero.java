package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._04RecursiveAndDynamicProgramming;

import java.util.HashMap;

public class _11MAXNumOfSubSetToGetEOREquallingZero {
    public static void main(String[] args) {
        _11MAXNumOfSubSetToGetEOREquallingZero maxNumOfSubSetToGetEOREquallingZero = new _11MAXNumOfSubSetToGetEOREquallingZero();
        int[] arr = new int[]{3, 2, 1, 9, 0, 7, 0, 2, 1, 3};
        int res = maxNumOfSubSetToGetEOREquallingZero.mostEOR(arr);
        System.out.println(res);
    }

    private int mostEOR(int[] arr) {
        int[] dp = new int[arr.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        dp[0] = arr[0] == 0 ? 1 : 0;
        map.put(0, -1);//没遍历之前就有一个异或和,为0  因为0 ^ x = x; 所以要此初始化
        map.put(arr[0], 0);
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
            if (map.containsKey(eor)) {
                Integer preEorIndex = map.get(eor);
                dp[i] = preEorIndex == -1 ? 1 : dp[preEorIndex] + 1;
            }
            dp[i] = Math.max(dp[i - 1], dp[i]);
            map.put(eor, i);
        }
        return dp[arr.length - 1];
    }
}
