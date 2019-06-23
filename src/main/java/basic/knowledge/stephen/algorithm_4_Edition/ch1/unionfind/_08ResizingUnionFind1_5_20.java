package basic.knowledge.stephen.algorithm_4_Edition.ch1.unionfind;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * 用可调整大小的数组实现quickunion算法 实现动态生长
 */
public class _08ResizingUnionFind1_5_20 {
    private int[] ids;
    private int count;
    private int[] weighted;
    private static int DEFAULT_COUNT = 5;

    public _08ResizingUnionFind1_5_20(int count) {
        this.count = count;
        this.ids = new int[count];
        this.weighted = new int[count];
        for (int i = 0; i < this.ids.length; i++) {
            ids[i] = i;
        }
        for (int i = 0; i < this.weighted.length; i++) {
            weighted[i] = 1;
        }
    }

    public _08ResizingUnionFind1_5_20() {
        this.count = DEFAULT_COUNT;
        this.ids = new int[DEFAULT_COUNT];
        this.weighted = new int[DEFAULT_COUNT];
        for (int i = 0; i < this.ids.length; i++) {
            ids[i] = i;
        }
        for (int i = 0; i < this.weighted.length; i++) {
            weighted[i] = 1;
        }
    }

    public int count() {
        return this.count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 找到p的根触点
     *
     * @param p
     * @return
     */
    public int find(int p) {
        if(p >ids.length - 1){
            int[] newIds = new int[p+1];
            int originalLength = this.ids.length;
            System.arraycopy(ids, 0, newIds, 0, originalLength);
            this.ids = newIds;
            for(int i = originalLength;i< p+1;i++){
                ids[i] = i;
            }

            int[] newWeighted = new int[p+1];
            int oriLength = this.weighted.length;
            System.arraycopy(weighted, 0, newWeighted, 0, oriLength);
            this.weighted = newWeighted;
            for(int i = oriLength;i< p+1;i++){
                ids[i] = 1;
            }
        }
        while (p != ids[p]) {
            p = ids[p];
        }
        return p;
    }

    public void union(int p, int q) {

        int pRoot = find(p);
        int qRoot = find(q);

        //如果根触点相同, 既p q已经联通
        if (pRoot == qRoot) {
            return;
        }

        if (weighted[pRoot] < weighted[qRoot]) {
            ids[pRoot] = qRoot;
            weighted[qRoot] += weighted[pRoot];
        } else  {
            ids[qRoot] = pRoot;
            weighted[pRoot] += weighted[qRoot];
        }

        this.count--;
    }

    public static void main(String[] args) {


        int total = 0;
        _08ResizingUnionFind1_5_20 rg = new _08ResizingUnionFind1_5_20();
        while (rg.count > 1) {
            int p = StdRandom.uniform(12);
            int q = StdRandom.uniform(12);
            int pRoot = rg.find(p);
            int qRoot = rg.find(q);
            if (pRoot == qRoot) {
                continue;
            }
            rg.union(p, q);
            System.out.println("count===" +rg.count);
            total++;
        }
        System.out.println("total===>" + total);

        System.out.println(Arrays.toString(rg.ids));


    }



}
