package basic.knowledge.stephen.algorithm_4_Edition.ch4.demo;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class CCTest {
    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        CC cc = new CC(G);
        int M = cc.count();
        StdOut.println(M + " components");
        Queue<Integer>[] components;
        components = (Queue<Integer>[]) new Queue[M];
        for (int i = 0; i < M; i++) {
            components[i] = new Queue<Integer>();
        }
        for (int v = 0; v < G.v(); v++) {
            components[cc.id(v)].enqueue(v);
        }
        for (int i = 0; i < M; i++) {
            StdOut.print(i + ": ");
            for (int v : components[i]) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        }
    }
}
