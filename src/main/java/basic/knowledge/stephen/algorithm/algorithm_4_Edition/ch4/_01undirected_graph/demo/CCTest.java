package basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch4._01undirected_graph.demo;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class CCTest {
    public static void main(String[] args)
    {
        Graph G = new Graph(new In(args[0]));
        CC cc = new CC(G);
        int M = cc.count();
        StdOut.println(M + " components");
        Bag<Integer>[] components;
        components = (Bag<Integer>[]) new Bag[M];
        for (int i = 0; i < M; i++)
            components[i] = new Bag<Integer>();
        for (int v = 0; v < G.v(); v++)
            components[cc.id(v)].add(v);
        for (int i = 0; i < M; i++)
        {
            for (int v: components[i])
                StdOut.print(v + " ");
            StdOut.println();
        }
    }
}
