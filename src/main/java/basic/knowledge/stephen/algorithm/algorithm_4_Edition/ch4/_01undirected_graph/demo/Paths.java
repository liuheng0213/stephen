package basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch4._01undirected_graph.demo;

public interface Paths {
    boolean hasPathTo(int v);// dose s has path to v?
    Iterable<Integer> pathTo(int v); //path from s to v ; null if no such path
}
