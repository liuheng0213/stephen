package basic.knowledge.stephen.algorithm_4_Edition.ch4.demo;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;

/**
 * 符号图形成双向索引
 */
public class SymbolGraph {
    private ST<String, Integer> st;
    private String[] keys;
    private Graph graph;


    public SymbolGraph(String stream, String sp) {
        st = new ST<>();
        In in = new In(stream);
        while (in.hasNextLine()) {
            String[] split = in.readLine().split(sp);
            for (int i = 0; i < split.length; i++) {
                if (!st.contains(split[i])) {
                    st.put(split[i], st.size());
                }
            }
        }

        keys = new String[st.size()];
        for (String name : st.keys()) {
            keys[st.get(name)] = name;
        }


        graph = new Graph(st.size());
        in = new In(stream);
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(sp);
            int v = st.get(a[0]);
            for (int i = 1; i < a.length; i++)
                graph.addEdge(v, st.get(a[i]));
        }
    }


    public boolean contains(String s) {
        return st.contains(s);
    }

    public int index(String s) {
        return st.get(s);
    }

    public String name(int v) {
        return keys[v];
    }

    public Graph G() {
        return graph;
    }
}
