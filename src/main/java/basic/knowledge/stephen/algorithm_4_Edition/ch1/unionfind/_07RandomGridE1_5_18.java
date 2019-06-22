package basic.knowledge.stephen.algorithm_4_Edition.ch1.unionfind;

import basic.knowledge.stephen.algorithm_4_Edition.ch1.bag.RandomBag;
import edu.princeton.cs.algs4.StdDraw;

import java.util.Arrays;
import java.util.Iterator;

public class _07RandomGridE1_5_18 {
    private int[] ids;
    private int count;
    private int[] treeHeight;
    private static int total;
    private static RandomBag<Connection> bag = new RandomBag<>();

    public _07RandomGridE1_5_18(int count) {
        this.count = count;
        this.ids = new int[count];
        this.treeHeight = new int[count];
        for(int i =0;i<this.ids.length;i++){
            ids[i] = i;
        }
        for(int i =0;i<this.treeHeight.length;i++){
            treeHeight[i] = 0;
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

        int num = 0;
        for(int i = 0;i<args.length;i++){
            if(Integer.valueOf(args[i]) instanceof Integer){
                num = Integer.valueOf(args[i]);
                break;
            }
        }
        num = num * num;

        int[] newArr = generate(num);
        System.out.println(Arrays.toString(newArr));
        System.out.println("================");
        Iterator<Connection> iterator = bag.iterator();
        while(iterator.hasNext()){
            Connection next = iterator.next();
            System.out.println(next.toString());
        }

    }

    private static int[] generate(int num) {
        _07RandomGridE1_5_18 rg = new _07RandomGridE1_5_18(num);
        while(rg.count > 1){
            int p = (int)(Math.random() * num);
            int q = (int)(Math.random() * num);
            int pRoot = rg.find(p);
            int qRoot = rg.find(q);
            if(pRoot == qRoot){
                continue;
            }
            rg.union(p,q);
            bag.add(new Connection(p,q));
            total++;
        }

        return rg.ids;
    }


}

class Connection{
    int p;
    int q;

    public Connection(int p, int q) {
        this.p = p;
        this.q = q;
    }

    @Override
    public String toString() {
        return "Connection{" +
                "p=" + p +
                ", q=" + q +
                '}';
    }
}
