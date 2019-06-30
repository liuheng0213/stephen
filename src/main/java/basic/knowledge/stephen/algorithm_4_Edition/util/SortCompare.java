package basic.knowledge.stephen.algorithm_4_Edition.util;

import basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_01_bubble_select_insert_shell._03InsertSort;
import basic.knowledge.stephen.algorithm_4_Edition.mock.MockData;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class SortCompare {
    public static double time(String alg,Double[] a){
        Stopwatch timer = new Stopwatch();
        if(alg.equals("InsertSort")){
            _03InsertSort.sort(MockData.DOUBLE_FOR_SORT_MOCK);
        }
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg,int N,int T){
        double total = 0.0;
        Double[] a = new Double[N];
        for(int t = 0;t<T;t++){
            for(int i = 0;i<N;i++){
                a[i] = StdRandom.uniform();
            }
            total += time(alg,a);
        }
        return total;
    }

    public static double timeEqualInput(String alg, int N, int T){
        //使用算法alg, 将T个长度为N的数值全部相等的数组排序，所花的时间
        double total = 0.0;
        Double[] a = new Double[N];
        for(int i=0; i<N; i++){
            //由于数组元素都相等，即使排序后，也相等，所以只赋值一次
            a[i] = 1.0;
        }
        for(int t=0; t <T; t++){
            total += time(alg, a);
        }
        return total;
    }

    public static double timeInverseInput(String alg, int N, int T){
        //使用算法alg，将T个长度为N的逆序数组排序，所花的时间
        double total = 0.0;
        Double[] a = new Double[N];
        for(int t=0; t<T; t++){
            for(int i=0; i<N; i++){
                a[i] = 1.0 * (N-i);
            }
            total += time(alg, a);
        }
        return total;
    }



    public static void main(String[] args) {
        String alg1 = args[0];
        String alg2 = args[1];

        int N = Integer.parseInt(args[2]);
        int T = Integer.parseInt(args[3]);

        double t1 = timeRandomInput(alg1, N,T );
        double t2 = timeRandomInput(alg2, N,T );

        StdOut.printf("For %d random Double\n  %s is",N,alg1);
        StdOut.printf("% .If times faster than %s\n",t2/t1,alg2);

        // 数组元素都相等的情况下，插入排序快于选择排序
        double t3 = timeEqualInput(alg1, N, T);
        double t4 = timeEqualInput(alg2, N, T);
        StdOut.printf("for %d equal Doules\n  %s is", N, alg1);
        StdOut.printf(" %.1f times faster than %s\n", t4/t3, alg2);

        //数组元素逆序的情况下，插入排序慢于选择排序
        double t5 = timeInverseInput(alg1, N, T);
        double t6 = timeInverseInput(alg2, N, T);
        StdOut.printf("for %d inverse Doules\n  %s is", N, alg1);
        StdOut.printf(" %.1f times faster than %s\n", t6/t5, alg2);

    }
}
