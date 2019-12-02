package basic.knowledge.stephen.algorithm_4_Edition.ch4._01undirected_graph.demo;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class TestSearch {
    public static void main(String[] args)
    {
        Graph G = new Graph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        Search search = new DepthFirstSearch(G, s);
        for (int v = 0; v < G.v(); v++)
            if (search.marked(v))
                StdOut.print(v + " ");
        StdOut.println();
        if (search.count() != G.v())
            StdOut.print("(s: "+s+") NOT ");
        StdOut.println("connected the whole graph");
    }
}
