package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_05_app;

import basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_03_quick._01QuickSort;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class _09E2_5_21Vector {
    public static void main(String[] args) {
        Vector[] vectors = new Vector[8];
        for (int i = 0; i < vectors.length; i++) {
            vectors[i] = new Vector(getRandomIntegers());
        }
        _01QuickSort.sort(vectors);
        System.out.println(Arrays.toString(vectors));
    }

    private static Integer[] getRandomIntegers() {
        Integer[] integers = new Integer[4];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = StdRandom.uniform(4);
        }
        return integers;
    }

    private static class Vector implements Comparable<Vector> {
        Integer[] datas;
        public Integer length;

        public Vector(Integer[] datas) {
            this.datas = datas;
            this.length = datas.length;
        }

        @Override
        public int compareTo(Vector that) {
            int maxN = Math.max(this.length, that.length);
            for (int i = 0; i < maxN; i++) {
                int comp = this.datas[i].compareTo(that.datas[i]);
                if (comp != 0)
                    return comp;
            }
            return this.length.compareTo(that.length);
        }

        @Override
        public String toString() {
            return "Vector{" +
                    "datas=" + Arrays.toString(datas) +
                    ", length=" + length +
                    '}';
        }
    }
}
