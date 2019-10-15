package basic.knowledge.stephen.algorithm_4_Edition.ch4.demo;

public abstract class Search {
    protected Graph graph;
    protected int source;

    public Search(Graph graph, int source) {
        this.graph = graph;
        this.source = source;
    }

    abstract boolean marked(int w);

    abstract int count();



}
