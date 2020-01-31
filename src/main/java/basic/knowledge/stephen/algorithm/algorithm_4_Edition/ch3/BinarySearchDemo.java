package basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch3;

public class BinarySearchDemo {
    public static void main(String[] args) {
        BinarySearchDemo binarySearchDemo = new BinarySearchDemo();
        int[] arr = new int[]{2, 5, 7, 10, 12, 16, 19, 21, 25, 26};
        int[] arr1 = new int[]{-2,-1};
        int index = binarySearchDemo.search(arr1, -1);
        System.out.println(index);
    }

    private int search(int[] arr, int target) {
        return search(arr, 0, arr.length - 1, target);
    }

    private int search(int[] arr, int start, int end, int target) {
        while(start <= end){
            int mid = (start + end) / 2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }
}
