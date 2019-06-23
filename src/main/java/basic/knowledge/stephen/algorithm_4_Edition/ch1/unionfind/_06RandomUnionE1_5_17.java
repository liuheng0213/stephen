package basic.knowledge.stephen.algorithm_4_Edition.ch1.unionfind;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class _06RandomUnionE1_5_17 {
    // number of random edges (with replacement) needed for an n-vertex
    // graph to become connected
    public static int count(int n) {
        int edges = 0;
        _03ScaleWeightedQuickUnion uf = new _03ScaleWeightedQuickUnion(n);
        while (uf.count() > 1) {
            int i = StdRandom.uniform(n);
            int j = StdRandom.uniform(n);
            if(uf.connected(i, j)){
                continue;
            }
            uf.union(i, j);
            edges++;
        }
        return edges;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);          // number of vertices
        int trials = Integer.parseInt(args[1]);     // number of trials
        int[] edges = new int[trials];              // record statistics

        // repeat the experiment trials times
        for (int t = 0; t < trials; t++) {
            edges[t] = count(n);
        }

        // report statistics
        StdOut.println("1/2 n ln n = " + 0.5 * n * Math.log(n));
        StdOut.println("mean       = " + StdStats.mean(edges));
        StdOut.println("stddev     = " + StdStats.stddev(edges));
    }
}
