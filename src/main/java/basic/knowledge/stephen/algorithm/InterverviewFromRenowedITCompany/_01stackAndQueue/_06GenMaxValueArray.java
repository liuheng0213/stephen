package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._01stackAndQueue;

import java.util.Arrays;
import java.util.LinkedList;

public class _06GenMaxValueArray {
    public static void main(String[] args) {
        _06GenMaxValueArray obj = new _06GenMaxValueArray();
        int[] arr = new int[]{4, 3, 5, 4, 3, 3, 6, 7};
        int[] res = obj.getMaxValueArray(arr, 3);
        System.out.println(Arrays.toString(res));
    }



    public int[] getMaxValueArray(int[] arr, int w) {
        if (arr == null || arr.length == 0 || w < 1) {
            return null;
        }
        w = Math.min(w, arr.length);
        int[] res = new int[arr.length - w + 1];

        int index = 0;
        LinkedList<Integer> indexQueue = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            while (!indexQueue.isEmpty() && arr[indexQueue.peekLast()] <= arr[i]) {
                indexQueue.pollLast();
            }
            indexQueue.addLast(i);
            if (indexQueue.peekFirst() < i - w + 1) {
                indexQueue.pollFirst();
            }

            if (i >= w - 1) {
                res[index++] = arr[indexQueue.peekFirst()];
            }
        }

        return res;
    }
}
