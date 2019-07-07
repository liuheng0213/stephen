package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_02_merge;

import basic.knowledge.stephen.algorithm_4_Edition.util.SortUtil;
import edu.princeton.cs.algs4.In;

public class _14E2_2_20 {
    private static int[] aux;

    public static void main(String[] args) {
        String[] a = new In().readAllStrings();
        int[] perm = sort(a);
        for (int i = 0; i < perm.length; i++) {
            System.out.print(perm[i] + " ");
        }
        System.out.println();
    }

    private static int[] merge(Comparable[] a, int lo, int mid, int hi, int[] perm) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = perm[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                perm[k] = aux[j++];
            } else if (j > hi) {
                perm[k] = aux[i++];
            } else if (SortUtil.less(a[aux[j]], a[aux[i]])) {
                perm[k] = aux[j++];//第k小的
            } else {
                perm[k] = aux[i++];
            }
        }
        return perm;
    }

    public static int[] sort(Comparable[] a) {
        int[] perm = new int[a.length];
        aux = new int[a.length];
        for (int i = 0; i < perm.length; i++) {
            perm[i] = i;
        }
        return sort(a, 0, a.length - 1, perm);
    }

    private static int[] sort(Comparable[] a, int lo, int hi, int[] perm) {
        if (hi <= lo) {
            return perm;
        }
        int mid = lo + (hi - lo) / 2;
        perm = sort(a, lo, mid, perm);
        perm = sort(a, mid + 1, hi, perm);
        perm = merge(a, lo, mid, hi, perm);
        return perm;
    }




}
