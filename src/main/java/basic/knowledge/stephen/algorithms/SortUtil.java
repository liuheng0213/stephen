package basic.knowledge.stephen.algorithms;

public class SortUtil {
    public static void exchange(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]=temp;
    }

    public static boolean isSorted(int[] arr){
        for(int i =0;i<arr.length-1;i++){
            if(arr[i+1] < arr[i]){
                return false;
            }
        }
        return true;
    }

    public static void show(int[] arr){
        for(int num : arr){
            System.out.println(num);
        }
    }

}
