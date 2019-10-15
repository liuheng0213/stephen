package basic.knowledge.stephen.algorithm_4_Edition.ch4.demo;


public class CC  {
    private Graph graph;
    private int count;
    private int[] ids;
    public CC(Graph graph) {
        this.graph = graph;
        count = graph.v();
        ids = new int[count];
        for(int i = 0;i<ids.length;i++){
            ids[i]=i;
        }
    }

    public int count() {
        return this.count;
    }
    public int id(int v){
        return ids[v];
    }
    public boolean connected(int p, int q) {
        return id(p) == id(q);
    }


}
