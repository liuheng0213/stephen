package basic.knowledge.stephen.algorithm_4_Edition.util;

import basic.knowledge.stephen.algorithm_4_Edition.ch2.sort._03InsertSort;
import basic.knowledge.stephen.algorithm_4_Edition.mock.MockData;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class SortUtil {

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static boolean isSorted(Comparable[] a) {
        for(int i = 1; i < a.length; ++i) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void show(Comparable[] a) {
        for(int i = 0; i < a.length; ++i) {
            StdOut.println(a[i]);
        }
    }
}
