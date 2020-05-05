package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._09others;


import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

//两个有序数组间相加和的topK问题
public class _19TopKOfSum {
    public static void main(String[] args) {
        _19TopKOfSum topKOfSum = new _19TopKOfSum();
        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        int[] arr2 = new int[]{3, 5, 7, 9, 11};
        int[] res = topKOfSum.topKOfSum(arr1, arr2, 4);
        System.out.println(Arrays.toString(res));
    }

    private int[] topKOfSum(int[] arr1, int[] arr2, int topK) {
        if (arr1 == null || arr2 == null || topK < 1) {
            return null;
        }
        topK = Math.min(topK, arr1.length * arr2.length);//arr1.length * arr2.length 是最大组合数
        int[] res = new int[topK];
        //初始值
        int i1 = arr1.length - 1;
        int i2 = arr2.length - 1;
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new MaxHeapComparator());
        HashSet<String> positionSet = new HashSet<>();//标记坐标组合, 同样的坐标位置  不要再进来了
        priorityQueue.add(new Node(i1, i2, arr1[i1] + arr2[i2]));
        positionSet.add(i1 + "_" + i2);

        int resIndex = 0;
        while (resIndex != topK) {
            Node cur = priorityQueue.poll();
            res[resIndex++] = cur.value;
            i1 = cur.index1;
            i2 = cur.index2;
            if (!positionSet.contains((i1 - 1) + "_" + i2)) {
                positionSet.add((i1 - 1) + "_" + i2);
                priorityQueue.add(new Node(i1 - 1, i2, arr1[i1 - 1] + arr2[i2]));
            }

            if (!positionSet.contains(i1 + "_" + (i2 - 1))) {
                positionSet.add(i1 + "_" + (i2 - 1));
                priorityQueue.add(new Node(i1, i2 - 1, arr1[i1] + arr2[i2 - 1]));
            }
        }
        return res;
    }

    class Node {
        public int index1;
        public int index2;
        public int value;

        public Node(int index1, int index2, int value) {
            this.index1 = index1;
            this.index2 = index2;
            this.value = value;
        }
    }

    class MaxHeapComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o2.value - o1.value;
        }
    }
}
