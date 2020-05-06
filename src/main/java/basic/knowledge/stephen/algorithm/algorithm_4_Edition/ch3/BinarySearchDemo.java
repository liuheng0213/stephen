package basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch3;

import java.util.Arrays;

public class BinarySearchDemo {
    public static void main(String[] args) {
        BinarySearchDemo binarySearchDemo = new BinarySearchDemo();
        int[] arr = new int[]{2, 5, 7, 10};
        int[] arr1 = new int[]{-2, -1};
        int index = binarySearchDemo.search(arr, 10);
        int jdkIndex = Arrays.binarySearch(arr, 10);// -5 jdk是 返回-(low + 1)
        System.out.println("jdkIndex : " + jdkIndex);
        System.out.println(index);
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
            /*if (arr[mid] == target) {
                return mid;
            } else*/ if (arr[mid] >= target) {
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
