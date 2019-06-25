package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort;

import basic.knowledge.stephen.algorithm_4_Edition.mock.MockData;
import basic.knowledge.stephen.algorithm_4_Edition.util.SortUtil;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class SortCompare {
    public static double time(String alg,Double[] a){
        Stopwatch timer = new Stopwatch();
        if(alg.equals("_03InsertSort")){
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


    public static void main(String[] args) {
        String alg1 = args[0];
        String alg2 = args[1];

        int N = Integer.parseInt(args[2]);
        int T = Integer.parseInt(args[3]);

        double t1 = timeRandomInput(alg1, N,T );
        double t2 = timeRandomInput(alg2, N,T );

        StdOut.printf("For %d random Double\n  %s is",N,alg1);
        StdOut.printf("% .If times faster than %s\n",t2/t1,alg2);

    }
}
