package basic.knowledge.stephen.algorithm_4_Edition.ch4.demo;

public abstract class Paths {
    protected Graph graph;
    protected int s;


    public Paths(Graph graph, int s) {
        this.graph = graph;
        this.s = s;
    }

    abstract  boolean hasPathTo(int v); //is there a path from s to v ?
    abstract  Iterable<Integer> pathTo(int v);//path from s to v ; null if no such path
}
