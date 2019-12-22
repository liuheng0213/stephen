package basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch1.unionfind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class _05HeightWeightedQuickUnionE1_5_14 {
    private int count;
    private int[] ids;
    private int[] treeHeight;


    public _05HeightWeightedQuickUnionE1_5_14(int count) {
        this.count = count;
        this.ids = new int[count];
        this.treeHeight = new int[count];
        for(int i =0;i<this.ids.length;i++){
            ids[i] = i;
        }
        for(int i =0;i<this.treeHeight.length;i++){
            ids[i] = 0;
        }
    }

    public int count(){
        return this.count;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    /**
     * 找到p的根触点
     * @param p
     * @return
     */
    public int find(int p){
        while(p != ids[p]){
            p = ids[p];
        }
        return p;
    }

    public void union(int p,int q){
        int pRoot = find(p);
        int qRoot = find(q);

        //如果根触点相同, 既p q已经联通
        if(pRoot == qRoot){
            return;
        }

        if(treeHeight[pRoot] < treeHeight[qRoot]){
            ids[pRoot] = qRoot;
        }else if(treeHeight[pRoot] > treeHeight[qRoot]){
            ids[qRoot] = pRoot;
        }else{  //高度相等
            ids[qRoot] = pRoot;
            treeHeight[pRoot]++;
        }


        this.count--;
    }

    public static void main(String[] args) {

        int n = StdIn.readInt();

        _05HeightWeightedQuickUnionE1_5_14 unionfind
                = new _05HeightWeightedQuickUnionE1_5_14(n);

        while(!StdIn.isEmpty()){

            int p = StdIn.readInt();
            int q = StdIn.readInt();

            if(unionfind.connected(p,q )){
                continue;
            }

            unionfind.union(p,q);

            StdOut.println("p = " + p + ", q = " + q);
        }

        StdOut.println(unionfind.count() + "Components");
    }

}
