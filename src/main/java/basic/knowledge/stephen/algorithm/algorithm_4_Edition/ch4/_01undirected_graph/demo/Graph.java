package basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch4._01undirected_graph.demo;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

public class Graph {
    private int v;
    private int e;
    private Bag<Integer>[] adj;


    public Graph(In in) {
        this.v = in.readInt();
        int totalE = in.readInt();// 这里绝对不能是this. e
        adj = new Bag[this.v];
        for (int i = 0; i < this.v; i++) {
            adj[i] = new Bag<>();
        }
        //add edage
        for (int i = 0; i < totalE; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public Graph(int v) {
        this.v = v;
        this.e = 0;
        adj = new Bag[this.v];
        for (int i = 0; i < this.v; i++) {
            adj[i] = new Bag<>();
        }
    }

    public void addEdge(int v, int w) {
        this.adj[v].add(w);
        this.adj[w].add(v);
        this.e++;
    }


    public int v() {
        return this.v;
    }


    public int e() {
        return this.e;
    }

    public Iterable<Integer> adj(int v) {
        return this.adj[v];
    }
}
