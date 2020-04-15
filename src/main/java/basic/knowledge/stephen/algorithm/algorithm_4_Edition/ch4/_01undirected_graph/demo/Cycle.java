package basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch4._01undirected_graph.demo;

/**
 * 判断一个图是否有环
 *
 *  v--> w
 *  w--> v
 */
public class Cycle {
    public boolean[] marked;
    public boolean hasCycle;


    public Cycle(Graph graph) {
        this.marked = new boolean[graph.v()];
        for (int s = 0; s < graph.v(); s++) {
            if (!marked[s]) {
                dfs(graph, s, s);
            }
        }
    }

    private void dfs(Graph graph, int v, int u) {  //u ---> v--->w
        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                dfs(graph, w, v);// v---> w
            } else {
                if (w != u) {  //如果v的下家w已经遍历过, 且如果v的上家u和v的下家w不相等, 必有环
                    hasCycle = true;
                }
            }
        }
    }
    public boolean hasCycle(){
        return this.hasCycle;
    }
}
