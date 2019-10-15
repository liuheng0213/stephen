package basic.knowledge.stephen.algorithm_4_Edition.ch4.demo;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class TestSearch {
    public static void main(String[] args) {
        Graph graph = new Graph(new In(args[0]));
        int s = Integer.parseInt(args[1]);

        Search search = new DepthFirstSearch(graph, s);
        for (int v = 0; v < graph.v(); v++) {
            if (search.marked(v)) {
                StdOut.print(v + " ");
            }
        }
        StdOut.println();
        if (search.count() != graph.v()) {
            StdOut.print("NOT ");
        }
        StdOut.println("connected");
    }
}
