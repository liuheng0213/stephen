package basic.knowledge.stephen.algorithm_4_Edition.ch4.demo;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private int v;
    private int e;
    private List<Integer>[] adj;

    public Graph(int v) {
        this.v = v;
        this.e = 0;
        adj = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public Graph(In in) {
        this(in.readInt());
        int e = in.readInt();
        for (int i = 0; i < e; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v,w);
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        e++;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public int v(){
        return this.v;
    }

    public int e(){
        return this.e;
    }

    public static int degree(Graph G, int v) {
        int degree = 0;
        for (int w : G.adj(v)) degree++;
        return degree;
    }

    public static int maxDegree(Graph G) {
        int max = 0;
        for (int v = 0; v < G.v(); v++)
            if (degree(G, v) > max)
                max = degree(G, v);
        return max;
    }

    public static double averageDegree(Graph G) {
        return 2.0 * G.e() / G.v();
    }

    public static int numberOfSelfLoops(Graph G)
    {
        int count = 0;
        for (int v = 0; v < G.v(); v++)
            for (int w : G.adj(v))
                if (v == w) count++;
        return count/2; // each edge counted twice
    }

    public String toString() {
        String s = v + " vertices, " + e + " edges\n";
        for (int v = 0; v < v; v++) {
            s += v + ": ";
            for (int w : this.adj(v)) {
                s += w + " ";
            }
            s += "\n";
        }
        return s;
    }
}
