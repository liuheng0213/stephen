package basic.knowledge.stephen.algorithms;

public class SortUtil {
    public static void exchange(Integer[] arr,Integer i,Integer j){
        arr[i] = arr[i]^arr[j];
        arr[j] = arr[i]^arr[j];
        arr[i] = arr[i]^arr[j];
    }

    public static boolean isSorted(Integer[] arr){
        for(int i =0;i<arr.length-1;i++){
            if(arr[i+1] < arr[i]){
                return false;
            }
        }
        return true;
    }

    public static void show(Integer[] arr){
        for(int num : arr){
            System.out.println(num);
        }
    }

}
