package basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch4._01undirected_graph.demo;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class TestPaths {
    public static void main(String[] args)
    {
        Graph G = new Graph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        //Paths search = new DepthFirstPaths(G, s);
        Paths search = new BreadthFirstPaths(G, s);
        for (int v = 0; v < G.v(); v++)
        {
            StdOut.print(s + " to " + v + ": ");
            if (search.hasPathTo(v))
                for (int x : search.pathTo(v))
                    if (x == s) StdOut.print(x);
                    else StdOut.print("-" + x);
            StdOut.println();
        }
    }
}
