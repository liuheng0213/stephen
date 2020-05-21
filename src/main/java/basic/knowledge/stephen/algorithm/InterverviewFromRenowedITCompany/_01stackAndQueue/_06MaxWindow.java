package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._01stackAndQueue;

import java.util.Arrays;
import java.util.LinkedList;

public class _06MaxWindow {
    public static void main(String[] args) {
        _06MaxWindow maxWindow = new _06MaxWindow();
        int[] arr = new int[]{4, 3, 5, 4, 3, 3, 6, 7,4,1,3,3,3};
        int[] res = maxWindow.getMaxWindow(arr, 3);
        System.out.println(Arrays.toString(res));
    }

    private int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }

        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];

        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }
            if (i >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }
}
