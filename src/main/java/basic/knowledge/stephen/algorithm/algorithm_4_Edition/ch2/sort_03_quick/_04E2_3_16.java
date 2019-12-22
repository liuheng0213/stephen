package basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch2.sort_03_quick;

import basic.knowledge.stephen.algorithm.algorithm_4_Edition.util.SortUtil;
import edu.princeton.cs.algs4.StdIn;

/**
 * 原则: 不能重复
 * 尽快跳出while(true)大循环, 或者第一轮大循环就直达:  if (i >= j) {break;
 * }
 */
public class _04E2_3_16 {
    public static void main(String[] args) {
        int n = StdIn.readInt();
        Integer[] a = best(n);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static Integer[] best(Integer n) {
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }
        best(a, 0, n - 1);
        return a;
    }

    private static Integer[] best(Integer[] a, int lo, int hi) {
        if (hi <= lo) {
            return a;
        }
        int mid = lo + (hi - lo) / 2;
        a = best(a, lo, mid - 1);
        a = best(a, mid + 1, hi);
        SortUtil.exch(a, lo, mid);
        return a;
    }


}
