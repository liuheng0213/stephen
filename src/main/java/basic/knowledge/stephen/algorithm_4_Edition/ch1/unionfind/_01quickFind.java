package basic.knowledge.stephen.algorithm_4_Edition.ch1.unionfind;

import basic.knowledge.stephen.algorithm_4_Edition.util.UnionFindUtil;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class _01quickFind extends UnionFind{

    public _01quickFind(int n){
        count = n;
        ids = new int[n];
        for(int i = 0;i<ids.length;i++){
            ids[i]=i;
        }
    }

    public int count(){
        return count;
    }

    /**
     * 返回分量
     * @param p
     * @return
     */
    public int find(int p){
        return ids[p];
    }

    /**
     * 分量是否连接
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p,int q){
        return find(p) == find(q);
    }

    /**
     * 连接两分量
     */
    public void union(int p, int q){
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

    public static void main(String[] args) {
        int n = StdIn.readInt();
        _01quickFind unionfind = new _01quickFind(n);

        while(!StdIn.isEmpty()){

            int p = StdIn.readInt();
            int q = StdIn.readInt();

            if(unionfind.connected(p,q )){
                continue;
            }

            unionfind.union(p,q);

            StdOut.println("p = " + p + ", q = " + q);


        }

        UnionFindUtil.checkUnion(unionfind);

        StdOut.println(unionfind.count() + "Components");
    }


}
