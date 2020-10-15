package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 类似最长递增子序列
 * 合理排序  可形成宽度满足最长子序列条件 长度必定满足条件
 */
public class _08NestedEnvelope_DP {
    public static void main(String[] args) {
        _08NestedEnvelope_DP envelopeNesting = new _08NestedEnvelope_DP();
        int[][] arr = new int[][]{{3, 4}, {2, 3}, {4, 5}, {1, 3}, {2, 2}, {3, 6}, {1, 2}, {3, 2}, {2, 4}};
        int res = envelopeNesting.maxNestedEnvelopes(arr);
        System.out.println(res);

    }

    private int maxNestedEnvelopes(int[][] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        Envelope[] sortedEnvelopes = getSortedEnvelopes(arr);

        int n = sortedEnvelopes.length;
        int[] ends = new int[n];

        ends[0] = sortedEnvelopes[0].width;
        int effectiveIndex = 0;
        int left;
        int right;
        int mid;
        for (int i = 1; i < n; i++) {
            left = 0;
            right = effectiveIndex;
            while(left <= right){
                mid = (left + right) >> 1;
                if(ends[mid] >= sortedEnvelopes[i].width){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            if(left > effectiveIndex){
                effectiveIndex = left;
            }
            ends[left] = sortedEnvelopes[left].width;
        }

       return effectiveIndex + 1;

    }


    private Envelope[] getSortedEnvelopes(int[][] arr) {
        Envelope[] envs = new Envelope[arr.length];
        for (int i = 0; i < arr.length; i++) {
            Envelope env = new Envelope(arr[i][0], arr[i][1]);
            envs[i] = env;
        }

        Arrays.sort(envs, new EnvComparator());

        return envs;
    }

    class EnvComparator implements Comparator<Envelope> {

        @Override
        public int compare(Envelope o1, Envelope o2) {
            return o1.length == o2.length ? o2.width - o1.width : o1.length - o2.length;
        }

    }

    class Envelope {
        int length;
        int width;


        public Envelope(int length, int width) {
            this.length = length;
            this.width = width;
        }
    }
}
