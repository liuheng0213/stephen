package basic.knowledge.stephen.algorithm_4_Edition.ch4.demo;

import edu.princeton.cs.algs4.Stack;

public class DepthFirstPaths extends Paths {
    private boolean[] marked;
    private int[] edgeTo;
    private int count;//


    public DepthFirstPaths(Graph g, int s) {
        super(g, s);
        marked = new boolean[g.v()];
        edgeTo = new int[g.v()];
        dfs(g, s);
    }

    /**
     * 这个会导致一个问题edgeTo[w] = v有可能会被新的值覆盖,从而导致拿到的不是最短的 而是后的可能路径
     *
     * @param g
     * @param v
     */
    private void dfs(Graph g, int v) {
        marked[v] = true;
        count++;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(g, w);
            }
        }
    }

    @Override
    boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }


}
