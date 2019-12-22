package basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch1.app;

import edu.princeton.cs.algs4.In;

import java.io.File;

public class AlgSelfUtilTest {
    public static void main(String[] args) {
        //根据空格分隔单词
        File file = new File("D:\\test1.txt");
        In in = new In(file);

        while(!in.isEmpty()){
            String s = in.readString();
            System.out.println(s);
        }
    }
}
