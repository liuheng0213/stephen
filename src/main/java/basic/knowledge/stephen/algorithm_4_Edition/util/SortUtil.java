package basic.knowledge.stephen.algorithm_4_Edition.util;

import basic.knowledge.stephen.algorithm_4_Edition.ch1.queue.GeneralizedQueueByLink1_3_38;
import basic.knowledge.stephen.algorithm_4_Edition.ch1.queue.MyQueue;
import basic.knowledge.stephen.algorithm_4_Edition.exception.SortFailureException;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

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
                throw new SortFailureException("Sort Fails and index is:" + i );
            }
        }
        return true;
    }

    public static boolean isEqual(Comparable a,Comparable b){
        return a.compareTo(b) == 0;
    }

    public static boolean isSorted(MyQueue<Comparable> queue){
        Iterator<Comparable> iterator = queue.iterator();

        Comparable pre =null;
        while(iterator.hasNext()){
            Comparable current = iterator.next();
            if(pre != null && less(current,pre )){
                throw new SortFailureException("排序失败");
            }
            pre = current;
        }
        return true;
    }

    public static void show(Comparable[] a) {
        for(int i = 0; i < a.length; ++i) {
            StdOut.println(a[i]);
        }
    }
}
