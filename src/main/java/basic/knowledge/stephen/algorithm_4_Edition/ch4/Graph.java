package basic.knowledge.stephen.algorithm_4_Edition.ch4;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private int v;
    private int e;
    private List<Integer>[] adj;

    public Graph(int V) {
        this.v = v;
        this.e = e;
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
}
