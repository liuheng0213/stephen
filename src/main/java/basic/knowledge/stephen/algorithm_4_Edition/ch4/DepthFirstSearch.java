package basic.knowledge.stephen.algorithm_4_Edition.ch4;

public class DepthFirstSearch extends Search {
    private boolean[] marked;
    private int count;//

    public DepthFirstSearch(Graph g,int s) {
        marked = new boolean[g.v()];
        dfs(g,s);
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        count++;
        for(int w:g.adj(v)){
            if(!marked[w]){
                dfs(g,w);
            }
        }
    }


    @Override
    boolean marked(int w) {
        return marked[w];
    }

    @Override
    int count() {
        return count;
    }
}
