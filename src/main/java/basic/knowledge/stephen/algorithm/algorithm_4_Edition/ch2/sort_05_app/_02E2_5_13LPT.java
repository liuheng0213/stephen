package basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch2.sort_05_app;

import basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch2.sort_04_heap._01MinPQ;
import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;

public class _02E2_5_13LPT {
    public static void main(String[] args) {
        int m = Integer.valueOf(args[0]);
        int n = StdIn.readInt();

        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(StdIn.readString(), StdIn.readDouble());
        }
        Arrays.sort(jobs);

        _01MinPQ<Processor> minPQ = new _01MinPQ(m);
        for(int i = 0;i < m;i++){
            minPQ.insert(new Processor());
        }
        for (int i = n - 1; i >= 0; i--) {
            Processor processor = minPQ.delMin();
            processor.insert(jobs[i]);
            minPQ.insert(processor);
        }

        while(!minPQ.empty()){
            System.out.println(minPQ.delMin());
        }
    }
}
