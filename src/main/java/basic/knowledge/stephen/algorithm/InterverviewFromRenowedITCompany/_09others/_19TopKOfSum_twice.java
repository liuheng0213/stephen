package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._09others;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class _19TopKOfSum_twice {
    public static void main(String[] args) {
        _19TopKOfSum_twice topKOfSum = new _19TopKOfSum_twice();
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
        int index = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>(new NodeComparator());

        int index1 = arr1.length - 1;
        int index2 = arr2.length - 1;
        queue.add(new Node(index1,index2,arr1[index1] + arr2[index2]));

        HashSet<String> filter = new HashSet<>();
        filter.add(index1 + "_" + index2);
        while(topK != 0){
            Node curNode = queue.poll();
            res[index++] = curNode.value;
            index1= curNode.index1;
            index2= curNode.index2;
            if(!filter.contains(index1 - 1 + "_" + index2)){
                filter.add(index1 - 1 + "_" + index2);
                queue.add(new Node(index1 - 1,index2,arr1[index1 - 1] + arr2[index2]));
            }

            if(!filter.contains(index1 + "_" + (index2 - 1))){
                filter.add(index1 + "_" + (index2 - 1));
                queue.add(new Node(index1,index2 - 1,arr1[index1] + arr2[index2 - 1]));
            }
            topK--;
        }

        return res;
    }


    class NodeComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o2.value - o1.value;
        }
    }

    class Node {
        int index1;
        int index2;
        int value;

        public Node(int index1, int index2, int value) {
            this.index1 = index1;
            this.index2 = index2;
            this.value = value;
        }
    }
}
