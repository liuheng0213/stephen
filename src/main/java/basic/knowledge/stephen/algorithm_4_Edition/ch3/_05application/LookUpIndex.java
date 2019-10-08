package basic.knowledge.stephen.algorithm_4_Edition.ch3._05application;

import basic.knowledge.stephen.algorithm_4_Edition.ch1.queue.MyQueue;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;

public class LookUpIndex {
    public static void main(String[] args) {
        In in = new In(args[0]);
        String sp = args[1];
        ST<String, MyQueue<String>> st = new ST<>();
        ST<String, MyQueue<String>> ts = new ST<>();
        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] tokens = line.split(sp);
            String key = tokens[0];
            for (int i = 1; i < tokens.length; i++) {
                String val = tokens[i];
                if (!st.contains(key)) {
                    st.put(key, new MyQueue<>());
                }
                if (!ts.contains(val)) {
                    ts.put(val, new MyQueue<>());
                }

                st.get(key).enqueue(val);
                ts.get(val).enqueue(key);
            }
        }

        while (!StdIn.isEmpty()) {
            String query = StdIn.readString();
            if (st.contains(query)) {
                for (String val : st.get(query)) {
                    System.out.println(val);
                }
            }
            System.out.println("RESULT below is the inverted index SET");
            if (ts.contains(query)) {
                for (String key : st.get(query)) {
                    System.out.println(key);
                }
            }
        }
    }
}
