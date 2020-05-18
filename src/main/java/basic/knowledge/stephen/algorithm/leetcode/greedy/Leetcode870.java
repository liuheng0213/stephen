package basic.knowledge.stephen.algorithm.leetcode.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeMap;

public class Leetcode870 {
    public static void main(String[] args) {
        Leetcode870 leetcode870 = new Leetcode870();
        int[] A = new int[]{2,14,10,15};
        int[] B = new int[]{3,15,14,23};
        //int[] res = leetcode870.advantageCount(A, B);
        int[] res1 = leetcode870.advantageCount_better(A, B);
        System.out.println(res1);
    }

    public int[] advantageCount_better(int[] A, int[] B) {
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (int i : A) {
            m.put(i, m.getOrDefault(i, 0) + 1);
        }
        int[] res = new int[A.length];
        for (int i = 0; i < A.length; ++i) {
            Integer x = m.higherKey(B[i]);
            if (x == null) {
                x = m.firstKey();
            }
            m.put(x, m.get(x) - 1);
            if (m.get(x) == 0) {
                m.remove(x);
            }
            res[i] = x;
        }
        return res;

    }

    /**
     * 思想： 田忌赛马
     * 每次拿A的“当前轮次“的最小值和B的”当前轮次“最小值比较，
     * 若大于，则OK，满足。（1)
     * 若小于，则将A的值去和B的”最大值“配对。(2)
     *
     * @param A
     * @param B
     * @return
     */
    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        LinkedList<Node> listB = new LinkedList<>();
        for (int i = 0; i < B.length; i++) {
            listB.add(new Node(B[i], i));
        }
        Collections.sort(listB, new Comparator<Node>() {
            public int compare(Node n1, Node n2) {
                return n1.value - n2.value;
            }
        });

        // 遍历A即可，将B数组作为输出容器，因为B的信息已经都存在LinkedList里了，这里B数组已经没用了
        for (int i = 0; i < A.length; i++) {
            if (A[i] > listB.getFirst().value) {
                B[listB.removeFirst().index] = A[i]; // 对应思想中的（1）
            } else {
                B[listB.removeLast().index] = A[i]; // // 对应思想中的（2）
            }
        }
        return B;
    }


    class Node {
        int value;
        int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}