package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._01stackAndQueue;

import java.util.LinkedList;

public class _09GetSubArrNum {
    public static void main(String[] args) {
        _09GetSubArrNum getSubArrNum = new _09GetSubArrNum();
        int[] arr = new int[]{2, 4, 1, 5, 7, 8, 9, 3, 13, 6, 19};
        int count = getSubArrNum.getNum(arr, 7);
        System.out.println(count);
    }

    private int getNum(int[] arr, int num) {
        if (arr == null || arr.length == 0 || num < 0) {
            return 0;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        LinkedList<Integer> qmin = new LinkedList<>();

        int i = 0;
        int j = 0;
        int count = 0;
        while (i < arr.length) {
            while (j >= i && j < arr.length) {
                //不需要判断!= j  不可能的当前J= 2 哪怕加入 Last = 2 j++以后 last怎么都不可能等于2
                //if (qmin.isEmpty() || qmin.peekLast() != j) {
                while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]) {
                    qmin.pollLast();
                }
                qmin.addLast(j);
                while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]) {
                    qmax.pollLast();
                }
                qmax.addLast(j);
                //}
                // }
                if ((arr[qmax.peekFirst()] - arr[qmin.peekFirst()]) > num) {
                    break;
                }
                j++;

            }
            count += j - i;
            //如果存i 需要poll掉 i++以后是不需要的
            if (qmin.peekFirst() == i) {
                qmin.pollFirst();
            }

            if (qmax.peekFirst() == i) {
                qmax.pollFirst();
            }
            i++;
        }

        return count;
    }
}
