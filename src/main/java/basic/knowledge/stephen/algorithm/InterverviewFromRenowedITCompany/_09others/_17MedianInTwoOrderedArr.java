package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._09others;


//在两个长度相等的有序数组中找到中位数
//时间复杂度 必须为 O(logN)
public class _17MedianInTwoOrderedArr {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 5, 8};
        int[] arr2 = new int[]{3, 5, 7, 9};
        _17MedianInTwoOrderedArr medianInTwoOrderedArr = new _17MedianInTwoOrderedArr();
        int res = medianInTwoOrderedArr.getMedian(arr1, arr2);
        System.out.println(res);
    }

    private Integer getMedian(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null || arr1.length != arr2.length) {
            return null;
        }
        int start1 = 0;
        int end1 = arr1.length - 1;
        int start2 = 0;
        int end2 = arr2.length - 1;
        int offset = 0;
        int mid1 = 0;
        int mid2 = 0;
        while (start1 <= end1) {
            mid1 = (start1 + end1) >> 1;
            mid2 = (start2 + end2) >> 1;
            offset = (end1 - start1 + 1) % 2 == 0 ? 1 : 0;
            if (arr1[mid1] == arr2[mid2]) {
                return arr1[mid1];
            } else if (arr1[mid1] < arr2[mid2]) {//此时中位数在arr1的后半段  以及  arr2 的前半段中
                start1 = mid1 + offset;
                end2 = mid2;
            } else {//此时中位数在arr1的前半段  以及  arr2 的后半段中
                end1 = mid1;
                start2 = mid2 + offset;
            }
        }
        return Math.min(arr1[end1], arr2[end2]);
    }
}
