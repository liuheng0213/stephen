package basic.knowledge.stephen.algorithm_4_Edition.ch4._01undirected_graph.demo;

/**
 * 每条path都是联通的
 */
public class CC {
    private boolean[] marked;
    private int[] id;
    private int count;


    public CC(Graph graph) {
        this.marked = new boolean[graph.v()];
        this.id = new int[graph.v()];
        this.count = 0;
        for (int s = 0; s < graph.v(); s++) {
            if (!marked[s]) {
                dfs(graph, s);
                count++;
            }
        }
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                dfs(graph, w);
            }
        }
    }

    public boolean isConnected(int v,int w){
        return id[v] == id[w];
    }

    public int id(int v){
        return id[v];
    }

    public int count(){
        return this.count;
    }
}
