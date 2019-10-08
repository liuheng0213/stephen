package basic.knowledge.stephen.algorithm_4_Edition.ch3._05application;

import basic.knowledge.stephen.algorithm_4_Edition.ch1.queue.MyQueue;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;

/**
 * 缓存入st中
 */
public class E3_5_12LookupCsv {
    public static void main(String[] args) {
        In in = new In(args[0]);
        int keyField = Integer.parseInt(args[1]);
        int valueField = Integer.parseInt(args[2]);
        ST<String, MyQueue<String>> st = new ST<>();
        while (in.hasNextLine()) {
            String[] tokens = null;
            try {
                String line = in.readLine();
                tokens = line.split(",");
                if (!st.contains(tokens[keyField])) {
                    st.put(tokens[keyField], new MyQueue<>());
                }
                st.get(tokens[keyField]).enqueue(tokens[valueField]);
            } catch (Exception e) {
                System.out.println(Arrays.toString(tokens));
                e.printStackTrace();
            }
        }

        while (!StdIn.isEmpty()) {
            String query = StdIn.readString();
            if (st.contains(query)) {
                for (String val : st.get(query)) {
                    System.out.println(val);
                }
            }
        }
    }
}
