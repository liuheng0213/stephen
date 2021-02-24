package basic.knowledge.stephen.algorithm.twice_InterverviewFromRenowedITCompany._08arrAndMatrix;

/**
 * 未排序数组中累加和小于或等于给定值的最长子数组长度
 */
public class _08_02LenOfSubArrSumLessThanDesigantedNum {
    public static void main(String[] args) {
        _08_02LenOfSubArrSumLessThanDesigantedNum obj = new _08_02LenOfSubArrSumLessThanDesigantedNum();
        int[] arr = new int[]{1,2,-1,5,-2,5,3,6,-2,-1,7};
        int res = obj.maxLessThanTarget(arr, 3);
        System.out.println(res);
    }

    private int maxLessThanTarget(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        //helpArr 作用, 记录0 到cur 索引的最大值 , 因为是单调非减数组, 很容易二分找到最大值第一次出现的位置
        int[] helpArr = new int[arr.length + 1];
        helpArr[0] = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            helpArr[i + 1] = Math.max(sum, helpArr[i]);
        }

        sum = 0;
        int preIndex = -1;
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            preIndex = getLessPreIndex(helpArr, sum - target);
            //preIndex = getLessPreIndexAnother(helpArr, sum - target);
            maxLen = Math.max(maxLen, preIndex == -1 ? 0 : i - preIndex + 1);
        }

        return maxLen;
    }

    private int getLessPreIndexAnother(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int mid;

        while (left + 1 < right) {
            mid = (left + right) >> 1;
            if (arr[mid] > target) {
                right = mid;
            } else if (arr[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if(left < arr.length && arr[left] >= target){
            return left;
        }

        if(right >=0 && arr[right] >= target){
            return right;
        }
        return -1;
    }

    private int getLessPreIndex(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        int res = -1;
        while (left <= right) {
            mid = (left + right) >> 1;
            if (arr[mid] > target) {
                res = mid;//为什么这里也要更新?????? 切记, 你求得是大于等于target的第一次出现的点, 而不是等于的点
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                res = mid;
                right = mid - 1;
            }
        }
        return res;
    }
}
