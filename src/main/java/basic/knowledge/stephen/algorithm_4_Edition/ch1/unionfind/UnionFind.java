package basic.knowledge.stephen.algorithm_4_Edition.ch1.unionfind;

public abstract class UnionFind {
    public int[] ids;//分量  以触点为索引
    public int count;//分量个数 number of components

    public abstract int count();

    public abstract int find(int p);

    public abstract boolean connected(int p,int q);

    public abstract void union(int p, int q);

}
