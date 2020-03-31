package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._08arrAndMatrix;

import java.util.Arrays;
import java.util.PriorityQueue;

//数组里的最小的K个数
public class _01MinKInUnorderedArr {
    public static void main(String[] args) {
        _01MinKInUnorderedArr lowestKInUnorderedArr = new _01MinKInUnorderedArr();
        int[] arr = new int[]{2,13,45,13,22,-4,0,8};
        int[] res = lowestKInUnorderedArr.getMinK(arr,5);
        System.out.println(Arrays.toString(res));
    }

    private int[] getMinK(int[] arr, int k) {
        int[] res = new int[k];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Integer num : arr){
            pq.add(num);
        }
        int i = 0;
        while(k > 0){
            res[i++] = pq.poll();
            k--;
        }
        return res;
    }
}
