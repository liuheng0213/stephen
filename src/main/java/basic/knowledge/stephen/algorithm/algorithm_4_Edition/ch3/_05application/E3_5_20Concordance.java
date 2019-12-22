package basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch3._05application;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;

/**
 * 用语索引
 * key word的索引  对应多个索引
 */
public class E3_5_20Concordance {
    private static final int CONTEXT = 5;

    public static void main(String[] args) {
        ST<String, SET<Integer>> st = new ST<>();
        In in = new In(args[0]);
        String[] words = in.readAllStrings();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (!st.contains(word)) {
                st.put(word, new SET<Integer>());
            }
            st.get(word).add(i);
        }
        //打印key出现的前后四个word
        while (!StdIn.isEmpty()) {
            String query = StdIn.readString();
            if (st.contains(query)) {
                for (int pos : st.get(query)) {
                    for (int i = Math.max(0, pos - CONTEXT + 1); i < pos; i++) {
                        System.out.print(words[i] + " ");
                    }
                    System.out.print("\"" + words[pos] + "\"");
                    for (int i = pos + 1; i < Math.min(words.length, pos + CONTEXT); i++) {
                        System.out.print(" " + words[i]);
                    }
                    System.out.println();
                }
            }
        }
    }
}
