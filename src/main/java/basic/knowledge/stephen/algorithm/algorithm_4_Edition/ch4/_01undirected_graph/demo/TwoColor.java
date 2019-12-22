package basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch4._01undirected_graph.demo;

public class TwoColor {
    private boolean[] marked;
    private boolean[] color;
    private boolean isTwoColorable = true;

    public TwoColor(Graph G) {
        marked = new boolean[G.v()];
        color = new boolean[G.v()];
        for (int s = 0; s < G.v(); s++)
            if (!marked[s])
                dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v))
            if (!marked[w]) {
                color[w] = !color[v];
                dfs(G, w);
            } else if (color[w] == color[v]) {
                isTwoColorable = false;
            }
    }

    public boolean isBipartite() {
        return isTwoColorable;
    }
}
