package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._04RecursiveAndDynamicProgramming;

import java.util.Arrays;

/**
 * 类似最长递增子序列
 * 合理排序  可形成宽度满足最长子序列条件 长度必定满足条件
 */
public class _08NestedEnvelope {
    public static void main(String[] args) {
        _08NestedEnvelope envelopeNesting = new _08NestedEnvelope();
        int[][] arr = new int[][]{{3, 4}, {2, 3}, {4, 5}, {1, 3}, {2, 2}, {3, 6}, {1, 2}, {3, 2}, {2, 4}};
        int res = envelopeNesting.maxNestedEnvelopes(arr);
        System.out.println(res);

    }

    private int maxNestedEnvelopes(int[][] arr) {
        Envelope[] sortedEnv = getSortedEnvelopes(arr);
        int[] ends = new int[sortedEnv.length];
        ends[0] = sortedEnv[0].wid;

        int right = 0;
        for (int i = 1; i < sortedEnv.length; i++) {
            if (sortedEnv[i].wid > ends[right]) {
                ends[++right] = sortedEnv[i].wid;
            } else {
                int index = binarySearch(ends, 0, right, sortedEnv[i].wid);
                ends[index] = sortedEnv[i].wid;
            }
        }
        return right + 1;

    }

    private int binarySearch(int[] ends, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) >> 1;//左移  乘 ; 右移  除
            if (ends[mid] == target) {
                return mid;
            } else if (ends[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private Envelope[] getSortedEnvelopes(int[][] arr) {
        Envelope[] envelopes = new Envelope[arr.length];
        for (int i = 0; i < arr.length; i++) {
            envelopes[i] = new Envelope(arr[i][0], arr[i][1]);
        }
        Arrays.sort(envelopes);
        return envelopes;
    }

    class Envelope implements Comparable<Envelope> {
        public int len;
        public int wid;


        public Envelope(int len, int wid) {
            this.len = len;
            this.wid = wid;
        }

        @Override
        public int compareTo(Envelope that) {
            return this.len != that.len ? this.len - that.len : that.wid - this.wid;
        }
    }
}
