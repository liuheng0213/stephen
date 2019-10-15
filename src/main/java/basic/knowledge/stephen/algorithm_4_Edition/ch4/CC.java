package basic.knowledge.stephen.algorithm_4_Edition.ch4;

import basic.knowledge.stephen.algorithm_4_Edition.ch1.unionfind.UnionFind;

public class CC extends UnionFind {
    private Graph graph;
    public CC(Graph graph) {
        this.graph = graph;
        count = graph.v();
        ids = new int[count];
        for(int i = 0;i<ids.length;i++){
            ids[i]=i;
        }
    }

    @Override
    public int count() {
        return this.count;
    }

    @Override
    public int find(int p) {
        return ids[p];
    }
    public int id(int v){
        return ids[v];
    }
    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void union(int p, int q) {
        int pComponent = find(p);
        int qComponent = find(q);

        //已在相同分量中
        if(pComponent == qComponent){
            return;
        }

        for(int i = 0; i<ids.length;i++){
            if(ids[i]==pComponent){//至少有这一个
                ids[i] = qComponent;  //所有的pComponent  对应的ids[i] 换成qComponent
            }
        }

        this.count++;
    }
}
