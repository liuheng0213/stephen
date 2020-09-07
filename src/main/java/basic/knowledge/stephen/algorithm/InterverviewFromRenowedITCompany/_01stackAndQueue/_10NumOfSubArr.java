package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._01stackAndQueue;

import java.util.LinkedList;

//最大值减去最小值小于等于Num的 所有子数组的数量
public class _10NumOfSubArr {
    public int numOfSubArr(int[] arr,int num){
        if(arr == null || arr.length == 0){
            return 0;
        }
        LinkedList<Integer> maxQueue = new LinkedList<>();
        LinkedList<Integer> minQueue = new LinkedList<>();

        int i = 0;
        int j = 0;
        int res = 0;
        while(i < arr.length){

            while(j < arr.length){
                while(!minQueue.isEmpty() && arr[minQueue.peekLast()] >= arr[j]){
                    minQueue.pollLast();
                }
                minQueue.addLast(j);
                while(!maxQueue.isEmpty() && arr[maxQueue.peekLast()] <= arr[j]){
                    maxQueue.pollLast();
                }
                maxQueue.addLast(j);
                if(arr[maxQueue.peekFirst()] - arr[minQueue.peekFirst()] > num){
                    break;
                }
                j++;
            }

            res += j - i;

            if(minQueue.peekFirst() == i){
                minQueue.pollFirst();
            }

            if(maxQueue.peekFirst() == i){
                maxQueue.pollFirst();
            }

            i++;
        }

        return res;
    }
}
