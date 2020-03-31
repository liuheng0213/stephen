package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._08arrAndMatrix;

//需要排序的最短子数组
public class _02ShortestSubArrNeededToBeSorted {
    public static void main(String[] args) {
        _02ShortestSubArrNeededToBeSorted shortestSubArrNeededToBeSorted = new _02ShortestSubArrNeededToBeSorted();
        int[] arr = new int[]{9,10,7,5,6,8};
        int res = shortestSubArrNeededToBeSorted.getMinlen(arr);
        System.out.println(res);
    }

    private int getMinlen(int[] arr) {
        if(arr == null || arr.length == 0){
            return 0;
        }

        int min = arr[arr.length - 1];
        int minIndex = -1;
        for(int i = arr.length - 2;i >= 0;i--){
            if(arr[i] > min){
                minIndex = i;
            }else{
                min = Math.min(min,arr[i]);
            }
        }
        if(minIndex == -1){
            return 0;
        }
        int max = arr[0];
        int maxIndex = -1;
        for(int i = 1;i < arr.length;i++){
            if(arr[i] < max){
                maxIndex = i;
            }else{
                max = Math.max(max,arr[i]);
            }
        }
        return maxIndex - minIndex + 1;
    }
}
