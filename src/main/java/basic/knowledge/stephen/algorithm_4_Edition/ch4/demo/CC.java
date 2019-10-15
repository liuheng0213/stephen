package basic.knowledge.stephen.algorithm_4_Edition.ch4.demo;


public class CC {
    private Graph graph;
    private int count;// number of components
    private int[] ids;
    private boolean marked[];

    public CC(Graph graph) {
        this.graph = graph;
        marked = new boolean[graph.v()];
        ids = new int[graph.v()];
        for (int i = 0; i < graph.v(); i++) {
            if (!marked[i]) {
                dfs(graph, i);
                count++;
            }
        }
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;
        ids[v] = count;
        for (int w : graph.adj(v))
            if (!marked[w])
                dfs(graph, w);
    }

    public int count() {
        return this.count;
    }

    public int id(int v) {
        return ids[v];
    }

    public boolean connected(int p, int q) {
        return id(p) == id(q);
    }


}
