package basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch4._01undirected_graph.demo;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class BreadthFirstPaths implements Paths {
    private boolean[] marked;
    private final int s;
    private int[] edgeTo; // edgeTo[w] = v  means v===> w


    public BreadthFirstPaths(Graph graph, int s) {
        this.s = s;
        this.edgeTo = new int[graph.v()];
        this.marked = new boolean[graph.v()];
        bfs(graph, s);
    }

    private void bfs(Graph graph, int s) {
        Queue<Integer> queue = new Queue<>();
        marked[s] = true;
        queue.enqueue(s);
        while (!queue.isEmpty()) {
            Integer v = queue.dequeue();
            for (int w : graph.adj(v)) {
                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = v;
                    queue.enqueue(w);
                }
            }
        }
    }

    @Override
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> path = new Stack<>();
        for (int i = v; i != s; i = edgeTo[i]) {//先加入的是终点
            path.push(i);
        }
        path.push(s);
        return path;
    }
}
