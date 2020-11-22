package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._09others;

public class _22Artisan_twice {
    public static void main(String[] args) {
        _22Artisan_twice artisan = new _22Artisan_twice();
        int[] arr = new int[]{3, 3, 4, 3, 6, 5, 4, 2};
        int num = 2;
        int res2 = artisan.solution4ByDivideAndConquer(arr, num);
        System.out.println("二分查找 : " + res2);
    }

    private int solution4ByDivideAndConquer(int[] arr, int num) {
        int right = arr[0];
        int left = arr[0];
        for (int i = 1; i < arr.length; i++) {
            right += arr[i];
            left = Math.max(left, arr[i]);
        }

        if (arr.length + 1 <= num) {
            return left;
        } else {
            int mid;


            while (left <= right) {
                mid = (left + right) >> 1;
                if (getNeedsNum(arr, mid) > num) {//mid 偏小
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }

    }

    private int getNeedsNum(int[] arr, int limit) {
        int num = 1;
        int time = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > limit) {
                return Integer.MAX_VALUE;//返回最大 ,
            }
            time += arr[i];
            if(time > limit){
                num++;
                time = arr[i];
            }
        }
        return num;
    }

}
