package basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch3;

import java.util.Arrays;

public class BinarySearchDemo {
    public static void main(String[] args) {
        BinarySearchDemo binarySearchDemo = new BinarySearchDemo();
        int[] arr = new int[]{2, 5, 7, 11};
        int[] arr1 = new int[]{-2, -1};
        int[] ends = new int[]{0, 1, 3, 4};
        int index = binarySearchDemo.search(arr, 0);
        //int jdkIndex = Arrays.binarySearch(arr, 12);// -5 jdk是 返回-(low + 1)
        //int endsIndex = Arrays.binarySearch(ends, 0, 0, -3);
        //System.out.println("jdkIndex : " + jdkIndex);
        System.out.println(index);
        //System.out.println(endsIndex);
    }

    private int search(int[] arr, int target) {
        return search(arr, 0, arr.length - 1, target);
    }

    /**
     * 要保证 哪怕找不到 也要返回应该在哪个索引中
     *
     * @param arr
     * @param start
     * @param end
     * @param target
     * @return
     */
    private int search(int[] arr, int start, int end, int target) {
        //要小于等于, 如果arr 长度是奇数  小于就行, 但是是偶数 必须小于等于
        while (start <= end) {
            int mid = (start + end) >> 1;
           /*if (arr[mid] == target) {  //有确定值的  不鼓励不给与相等条件的值
                return mid;
            } else*/
            //只有mid 值偏大(当然arr[mid]  偏大)  适合于 end = mid - 1;
            if (arr[mid] >= target) {  // 对于确定值(= 的条件)  只能放于 end 缩小的  情况中
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        //如果target找不到 最后会有start  = end + 1出来
        return start;


        //or
       /* while (start != end - 1) {
            int mid = (start + end) >> 1;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        return end;*/
    }
}
