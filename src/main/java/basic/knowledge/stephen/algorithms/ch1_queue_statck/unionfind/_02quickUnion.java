package basic.knowledge.stephen.algorithms.ch1_queue_statck.unionfind;


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 时间复杂度: 树的高度
 */
public class _02quickUnion {
    private int count;
    private int[] ids;


    public _02quickUnion(int count) {
        this.count = count;
        this.ids = new int[count];
        for(int i =0;i<this.ids.length;i++){
            ids[i] = i;
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

        ids[pRoot] = qRoot;

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
