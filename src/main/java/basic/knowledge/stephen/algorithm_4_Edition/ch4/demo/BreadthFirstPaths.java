package basic.knowledge.stephen.algorithm_4_Edition.ch4.demo;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class BreadthFirstPaths extends Paths {
    private boolean[] marked;
    private int[] edgeTo;
    private int count;//


    public BreadthFirstPaths(Graph g, int s) {
        super(g, s);
        marked = new boolean[g.v()];
        edgeTo = new int[g.v()];
        bfs(g, s);
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

    /**
     * 1 确保每个都检查了一遍
     * 2 保证获取到所有点到s 的最短路径都存在了edageTo中
     * 3 与深度搜索不同,没当停留在v时 就遍历其子节点, 找到所有的路径.
     * @param g
     * @param s
     */
    private void bfs(Graph g, int s) {
        Queue<Integer> queue = new Queue<Integer>();
        marked[s] = true; // Mark the source
        queue.enqueue(s); // and put it on the queue.
        while (!queue.isEmpty()) {
            int v = queue.dequeue(); // Remove next vertex from the queue.
            for (int w : g.adj(v)) {
                if (!marked[w]) { // For every unmarked adjacent vertex,
                    edgeTo[w] = v; // save last edge on a shortest path,
                    marked[w] = true; // mark it because path is known,
                    queue.enqueue(w); // and add it to the queue.
                }
            }
        }
    }
}
