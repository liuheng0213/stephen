package basic.knowledge.stephen.algorithm_4_Edition.ch4.demo;

/**
 * Graph有没有自环, 或平行多环
 */
public class Cycle {
    private boolean[] marked;
    private boolean hasCycle;

    public Cycle(Graph G) {
        marked = new boolean[G.v()];
        for (int s = 0; s < G.v(); s++)
            if (!marked[s])
                dfs(G, s, s);
    }

    private void dfs(Graph G, int v, int u) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w, v);
            } else if (w != u) {  //一般来说marked之后的邻近节点只有自己, 不是自己的就不正常
                hasCycle = true;
            }
        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }
}
