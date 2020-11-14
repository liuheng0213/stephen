package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._08arrAndMatrix;

import java.util.Arrays;
import java.util.PriorityQueue;

//数组里的最小的K个数
public class _01MinKInUnorderedArr {
    public static void main(String[] args) {
        _01MinKInUnorderedArr lowestKInUnorderedArr = new _01MinKInUnorderedArr();
        int[] arr = new int[]{2, 13, 45, 13, 22, -4, 0, 8};
        int k = 5;
        int[] res = lowestKInUnorderedArr.getMinK(arr, k);
        int[] res2 = lowestKInUnorderedArr.getMinKBetter(arr, k);
        Arrays.sort(res);
        Arrays.sort(res2);
        System.out.println(Arrays.toString(res));
        System.out.println(Arrays.toString(res2));
    }

    /**
     * O(NlogN) 复杂度并不好
     *
     * @param arr
     * @param k
     * @return
     */
    private int[] getMinK(int[] arr, int k) {
        k = Math.min(arr.length, k);
        int[] res = new int[k];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Integer num : arr) {
            pq.add(num);
        }
        int i = 0;
        while (k > 0) {
            res[i++] = pq.poll();
            k--;
        }
        return res;
    }


    /**
     * O(NlogK) 方法
     *
     * @param arr
     * @param k
     * @return
     */
    private int[] getMinKBetter(int[] arr, int k) {
        k = Math.min(arr.length, k);
        int[] res = new int[k];
        int index = 0;
        for (int i = 0; i < k; i++) {
            res[index] = arr[i];
            heapSwim(res, index++);
        }

        for (int i = k; i < arr.length; i++) {
            if (arr[i] < res[0]) {
                res[0] = arr[i];
                heapSink(res, 0);
            }
        }
        return res;
    }

    private void heapSink(int[] res, int start) {
        int j = 0;
        while ((start * 2) + 1 <= res.length - 1) {
            j = (start * 2) + 1;

            if (j + 1 <= res.length - 1 && res[j + 1] > res[j]) {
                j++;
            }
            if (res[j] > res[start]) {
                swap(res, j, start);
            } else {
                break;
            }

            start = j;
        }
    }

    private void heapSwim(int[] res, int end) {
        int parent = 0;
        while ((end - 1) / 2 >= 0) {
            parent = (end - 1) / 2;
            if (res[parent] < res[end]) {
                swap(res, parent, end);
            } else {
                break;
            }
            end = parent;
        }

    }

    private void swap(int[] res, int parent, int end) {
        int temp = res[parent];
        res[parent] = res[end];
        res[end] = temp;
    }

}

