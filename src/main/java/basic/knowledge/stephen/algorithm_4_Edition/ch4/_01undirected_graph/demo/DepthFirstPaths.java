package basic.knowledge.stephen.algorithm_4_Edition.ch4._01undirected_graph.demo;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class DepthFirstPaths implements Paths {
    private boolean[] marked;
    private final int s;
    private int[] edgeTo; // edgeTo[w] = v  means v===> w

    public DepthFirstPaths(Graph graph,int s) {
        this.s = s;
        this.edgeTo = new int[graph.v()];
        this.marked = new boolean[graph.v()];
        dfs(graph,s);
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;
        for(int w : graph.adj(v)){
            if(!marked[w]){
                edgeTo[w] = v;
                dfs(graph,w);
            }
        }
    }


    @Override
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
        if(!hasPathTo(v)){
            return null;
        }
        Stack<Integer> path = new Stack<>();
        for(int i = v; i != s; i = edgeTo[i]){//先加入的是终点
            path.push(i);
        }
        path.push(s);
        return path;
    }
}
