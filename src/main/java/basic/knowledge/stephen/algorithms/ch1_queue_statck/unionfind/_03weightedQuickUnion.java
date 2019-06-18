package basic.knowledge.stephen.algorithms.ch1_queue_statck.unionfind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 加权的quick union
 * 复杂度lgN
 */
public class _03weightedQuickUnion {
    private int count;
    private int[] ids;
    private int[] weighted;//加权数组, 标记子树的触点数量, 表示子树的大小, 保证大的子树合并时是父树


    public _03weightedQuickUnion(int count) {
        this.count = count;
        this.ids = new int[count];
        this.weighted = new int[count];
        for(int i =0;i<this.ids.length;i++){
            ids[i] = i;
        }
        for(int i =0;i<this.weighted.length;i++){
            weighted[i] = 1;
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
    //modification 添加路径加权
    public int find(int p){
        int temp = p;

        while(p != ids[p]){
            p = ids[p];
        }
        int root = p;
        p = temp;

        while(ids[p] != root){
            temp = ids[p];
            ids[p] = root;
            p =  temp;
        }
        return root;
    }

    public void union(int p,int q){
        int pRoot = find(p);
        int qRoot = find(q);

        //如果根触点相同, 既p q已经联通
        if(pRoot == qRoot){
            return;
        }

        //pRoot 挂到qRoot下
        if(weighted[pRoot] < weighted[qRoot]){
            ids[pRoot] = qRoot;
            weighted[qRoot] += weighted[pRoot];
        }else{
            ids[qRoot] = pRoot;
            weighted[pRoot] += weighted[qRoot];
        }

        this.count--;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        _02quickUnion unionfind = new _02quickUnion(n);

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
