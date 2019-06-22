package basic.knowledge.stephen.algorithm_4_Edition.ch1.unionfind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 0-->1-->2-->3  增加0-->3,1-->3,2-->3的三条路径
 */
public class _04PathCompressionQuickUnionE1_5_12 {
    private int count;
    private int[] ids;


    public _04PathCompressionQuickUnionE1_5_12(int count) {
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
        int temp = p; //保留P的值
        while(p != ids[p]){
            p = ids[p];
        }
        int root = p;
        p = temp;  //还原p值
        //set all node's father is root
        //比如:一个while为 0-->1-->2-->3 ,现在要多两条条路径0--->3  1---3  2-->3
        while(root != ids[p]){  //跳出循环的条件为ids[0] ==2
            temp = ids[p];
            ids[p] = root;
            p=temp;
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

        ids[pRoot] = qRoot;

        this.count--;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        _04PathCompressionQuickUnionE1_5_12 unionfind = new _04PathCompressionQuickUnionE1_5_12(n);

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
