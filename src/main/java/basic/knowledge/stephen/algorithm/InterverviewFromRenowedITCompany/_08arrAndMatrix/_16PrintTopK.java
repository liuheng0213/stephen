package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._08arrAndMatrix;

import java.util.PriorityQueue;

//打印N个各自有序的数组最大的TopK
//只要有Top K 基本和优先队列联系起来
//永远最多只有arr.length的个数在堆中
public class _16PrintTopK {
    public static void main(String[] args) {
        _16PrintTopK printTopK = new _16PrintTopK();
        int[][] arr = new int[][]{{219, 405, 538, 845, 971}, {148, 558}, {52, 99, 348, 691}, {145, 276, 277, 348, 557}};
        printTopK.getTopK(arr, 17);

    }

    private void getTopK(int[][] arr, int k) {
        int heapSize = arr.length;
        Node[] nodes = new Node[heapSize];
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i].length - 1;
            nodes[i] = new Node(arr[i][index], i, index);
            swim(nodes, i);
        }

        System.out.println("TOP " + k + " : ");
        while (k >= 1) {
            if (heapSize == 0) { //当k 超过所有元素的个数时  进入if
                break;
            }
            System.out.println(nodes[0].value + " ");
            k--;
            if (nodes[0].index != 0) {
                nodes[0].index--;
                nodes[0] = new Node(arr[nodes[0].arrNum][nodes[0].index], nodes[0].arrNum, nodes[0].index);
            } else {
                swap(nodes, 0, --heapSize);
            }
            sink(nodes, 0, heapSize);
        }

    }

    /**
     * 0 下沉
     *
     * @param nodes
     * @param i
     * @param heapSize
     */
    private void sink(Node[] nodes, int i, int heapSize) {
        if (heapSize == 1) {
            return;
        }
        int j = (i + 1) * 2 - 1;
        while (j <= heapSize - 1) {
            if (j < heapSize - 1 && nodes[j].value < nodes[j + 1].value) {
                j++;
            }
            if (nodes[i].value < nodes[j].value) {
                swap(nodes, i, j);
            } else {
                break;
            }
            i = j;
        }

    }

    /**
     * 只上浮arr的最后一个元素
     *
     * @param nodes
     * @param index
     */
    private void swim(Node[] nodes, int index) {
        while (index != 0) {
            int parent = (index - 1) / 2;
            if (nodes[parent].value < nodes[index].value) {
                swap(nodes, parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }

    private void swap(Node[] nodes, int i, int j) {
        Node temp = nodes[i];
        nodes[i] = nodes[j];
        nodes[j] = temp;
    }

    static class Node implements Comparable<Node> {
        public int value;
        public int arrNum;
        public int index;

        public Node(int value, int arrNum, int index) {
            this.value = value;
            this.arrNum = arrNum;
            this.index = index;
        }

        @Override
        public int compareTo(Node that) {
            return this.value - that.value;
        }
    }
}
