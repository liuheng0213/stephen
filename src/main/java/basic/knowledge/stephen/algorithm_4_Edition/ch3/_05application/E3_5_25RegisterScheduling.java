package basic.knowledge.stephen.algorithm_4_Edition.ch3._05application;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.ST;

import java.util.Date;

/**
 * 一个老师对应多个班级,每个班级对应多个时间
 */
public class E3_5_25RegisterScheduling {
    public static void main(String[] args) {
        //老师,班级,时间
        ST<String, ST<String, SET<String>>> st = new ST<>();
        In in = new In(args[0]);
        while (!in.isEmpty()) {
            String line = in.readLine();
            String[] arr = line.split(",");
            if (!st.contains(arr[0])) {
                st.put(arr[0], new ST<>());
            }

            if (!st.get(arr[0]).contains(arr[1])) {
                st.get(arr[0]).put(arr[1], new SET<>());
            }

            if (!st.get(arr[0]).get(arr[1]).contains(arr[2])) {
                st.get(arr[0]).get(arr[1]).add(arr[2]);
            } else {
                System.out.println("该时间: " + arr[2] +
                        "该老师 : " + arr[0] + "已经在教室: " + arr[1] + " 安排过课程");
            }
        }
    }
}
