package basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch1.unionfind;

import basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch1.bag.RandomBag;
import basic.knowledge.stephen.algorithm.algorithm_4_Edition.util.UnionFindUtil;
import edu.princeton.cs.algs4.StdDraw;

import java.util.Arrays;
import java.util.Iterator;

public class _07RandomGridE1_5_18and1_5_19 extends UnionFind {
    private int[] treeHeight;
    private static RandomBag<Connection> bag = new RandomBag<>();


    public _07RandomGridE1_5_18and1_5_19(int count) {
        this.count = count;
        this.ids = new int[count];
        this.treeHeight = new int[count];
        for (int i = 0; i < this.ids.length; i++) {
            ids[i] = i;
        }
        for (int i = 0; i < this.treeHeight.length; i++) {
            treeHeight[i] = 0;
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

        if (treeHeight[pRoot] < treeHeight[qRoot]) {
            ids[pRoot] = qRoot;
        } else if (treeHeight[pRoot] > treeHeight[qRoot]) {
            ids[qRoot] = pRoot;
        } else {  //高度相等
            ids[qRoot] = pRoot;
            treeHeight[pRoot]++;
        }

        //add
        bag.add(new Connection(p, q));

        this.count--;
    }

    private static void draw(RandomBag<Connection> bag, int n) {
        StdDraw.rectangle(0, 0, 1, 1);
        double num = n;
        Iterator<Connection> iterator = bag.iterator();
        while (iterator.hasNext()) {
            Connection current = iterator.next();
            int p = current.p;
            int q = current.q;

            double x0 = (p % n) / num;
            double y0 = (n - 1 - (p - x0) / n) / num;

            double x1 = (q % n) / num;
            double y1 = (n - 1 - (q - x1) / n) / num;

            StdDraw.line(x0, y0, x1, y1);
            System.out.println(current.toString());
        }
    }

    private static int[][] generateTwodimensionArray(int[] newArr, int n) {
        int[][] twoDimensionArr = new int[n][n];
        for (int i = 0; i < newArr.length; i++) {
            int j = i / n;  //第一维坐标
            int k = i % n;  //第二维坐标
            twoDimensionArr[j][k] = newArr[i];
        }
        return twoDimensionArr;
    }


    private static int[] generate(int num) {
        int total = 0;
        _07RandomGridE1_5_18and1_5_19 rg = new _07RandomGridE1_5_18and1_5_19(num);
        while (rg.count > 1) {
            int p = (int) (Math.random() * num);
            int q = (int) (Math.random() * num);
            int pRoot = rg.find(p);
            int qRoot = rg.find(q);
            if (pRoot == qRoot) {
                continue;
            }
            rg.union(p, q);

            total++;
        }

        //UnionFindUtil.checkUnion(rg);

        System.out.println("total===>" + total);
        return rg.ids;
    }


    public static void main(String[] args) {

        int num = 0;
        int n = 0;
        if (Integer.valueOf(args[0]) instanceof Integer) {
            num = Integer.valueOf(args[0]);
        }
        n = num;
        num = num * num;

        int[] newArr = generate(num);

        System.out.println(Arrays.toString(newArr));

        int[][] twodimensionArray = generateTwodimensionArray(newArr, n);

        //E1_5_18
        for (int i = 0; i < twodimensionArray.length; i++) {
            for (int j = 0; j < twodimensionArray[i].length; j++) {
                System.out.print(twodimensionArray[i][j] + " ");
            }
            System.out.println();
        }

        //E1_5_19
        draw(bag, n);


    }


}

class Connection {
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
