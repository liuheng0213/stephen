package basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch4._01undirected_graph.demo;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;

public class SymbolGraph {
    private ST<String, Integer> st;
    private String[] keys;
    private Graph graph;


    public
    SymbolGraph(String stream, String split) {
        //第一遍遍历, 简历符号表
        st = new ST<>();
        In in = new In(stream);
        while (in.hasNextLine()) {
            String[] strs = in.readLine().split(split);
            for (int i = 0; i < strs.length; i++) {
                if (!st.contains(strs[i])) {
                    st.put(strs[i], st.size());
                }
            }
        }
        //拿到反向索引的数组形式
        this.keys = new String[st.size()];
        for (String str : st.keys()) {
            keys[st.get(str)] = str;
        }

        //第二遍遍历 简历图关系  因为graph 只能int int addedge 所以需要反向索引
        graph = new Graph(st.size());
        in = new In(stream);
        while (in.hasNextLine()) {
            String[] strs = in.readLine().split(split);
            int v = st.get(strs[0]);
            for (int i = 1; i < strs.length; i++) {
                graph.addEdge(v, st.get(strs[i]));
            }
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

    public Graph g() {
        return graph;
    }
}
