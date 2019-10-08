package basic.knowledge.stephen.algorithm_4_Edition.ch3._05application;

import basic.knowledge.stephen.algorithm_4_Edition.ch1.queue.MyQueue;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * 反向索引不能用String[] words = in.readAllStrings()的数组索引
 * 因为不是一对多了
 */
public class E3_5_21InvertedConcordance {
    private static final int CONTEXT = 5;

    public static void main(String[] args) {
        ST<String, LinkedList<Integer>> st = new ST<>();
        ST<String, LinkedList<StringInArray>> ts = new ST<>();
        In in = new In(args[0]);
        String[] words = in.readAllStrings();
        int lastIndex = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (!st.contains(word)) {
                st.put(word, new LinkedList<Integer>());
            }

            Integer storeIndex = getStoreIndex(word, lastIndex, ts);
            if (storeIndex == null) {
                ts.put(String.valueOf(++lastIndex), new LinkedList<StringInArray>());
                ts.get(String.valueOf(lastIndex)).add(new StringInArray(word, i));
            } else {
                ts.get(String.valueOf(storeIndex)).add(new StringInArray(word, i));
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
            System.out.println("RESULT below is the inverted index SET");
            try {
                if (Integer.valueOf(query).getClass() == Integer.class) {
                    if (ts.contains(query)) {
                        for (StringInArray sia : ts.get(query)) {
                            System.out.println(sia.str + " ,数组中的索引是" + sia.i);
                        }
                    }
                }
            } catch (NumberFormatException e) {
                break;
            }
        }
    }

    /**
     * 获取lastIndex之前是否存储过的索引
     *
     * @param word
     * @param lastIndex
     * @param ts
     * @return
     */
    private static Integer getStoreIndex(String word, int lastIndex, ST<String, LinkedList<StringInArray>> ts) {
        for (int i = 0; i <= lastIndex; i++) {
            if (ts.contains(String.valueOf(i)) && ts.get(String.valueOf(i)).contains(new StringInArray(word))) {
                return i;
            }
        }
        return null;
    }

    private static class StringInArray {
        private String str;
        private int i;

        public StringInArray(String str, int i) {
            this.str = str;
            this.i = i;
        }

        public StringInArray(String str) {
            this.str = str;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof StringInArray)) return false;
            StringInArray that = (StringInArray) o;
            return Objects.equals(str, that.str);
        }

        @Override
        public int hashCode() {
            return Objects.hash(str);
        }
    }
}
