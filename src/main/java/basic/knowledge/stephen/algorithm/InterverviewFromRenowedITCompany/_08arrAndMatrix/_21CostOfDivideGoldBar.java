package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._08arrAndMatrix;

import java.util.PriorityQueue;

//分金条的最小花费
public class _21CostOfDivideGoldBar {
    public static void main(String[] args) {
        _21CostOfDivideGoldBar costOfDivideGoldBar = new _21CostOfDivideGoldBar();
        int[] arr = new int[]{10, 30, 20};
        int res = costOfDivideGoldBar.getMinCost(arr);
        System.out.println(res);

    }

    private int getMinCost(int[] arr) {
        if (arr == null && arr.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            priorityQueue.add(arr[i]);
        }
        int ant = 0;
        while (priorityQueue.size() >= 2) {
            int sum = priorityQueue.poll() + priorityQueue.poll();
            ant += sum;
            priorityQueue.add(ant);
        }
        return ant;
    }
}
