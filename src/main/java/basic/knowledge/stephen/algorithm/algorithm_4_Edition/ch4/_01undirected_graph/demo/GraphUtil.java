package basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch4._01undirected_graph.demo;

public class GraphUtil {
    public static int degree(Graph graph, int v) {
        int degree = 0;
        for (int i : graph.adj(v)) {
            degree++;
        }
        return degree;
    }

    public static int maxDegree(Graph graph) {
        int maxDegree = 0;
        for (int i = 0; i < graph.v(); i++) {
            int degree = degree(graph, i);
            if (maxDegree < degree) {
                maxDegree = degree;
            }
        }
        return maxDegree;
    }

    public static int avgDegree(Graph graph) {
        return 2 * graph.e() / graph.v();
    }

    public static int numberOfSeltLoop(Graph graph) {
        int count = 0;
        for (int v = 0; v < graph.v(); v++) {
            for (int w : graph.adj(v)) {
                if (w == v) {
                    count++;
                }
            }
        }
        return count / 2;
    }

    public static String toString(Graph graph) {
        String s = graph.v() + " vertices, " + graph.e() + " edges\n";
        for (int v = 0; v < graph.v(); v++) {
            s += v + ": ";
            for (int w : graph.adj(v))
                s += w + " ";
            s += "\n";
        }
        return s;
    }
}
