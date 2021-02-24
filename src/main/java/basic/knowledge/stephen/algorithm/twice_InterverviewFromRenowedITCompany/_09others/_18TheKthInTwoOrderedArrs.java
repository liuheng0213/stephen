package basic.knowledge.stephen.algorithm.twice_InterverviewFromRenowedITCompany._09others;


//在两个排序数组中找到第K小的数
//时间复杂度 必须为O(log(min{M,N}))
public class _18TheKthInTwoOrderedArrs {
    public static void main(String[] args) {
        _18TheKthInTwoOrderedArrs theKthInTwoOrderedArrs = new _18TheKthInTwoOrderedArrs();
        int[] arr1 = new int[]{1, 2, 3};
        int[] arr2 = new int[]{3, 4, 5, 6};
        int res = theKthInTwoOrderedArrs.getRes(arr1, arr2, 4);
        System.out.println(res);
    }

    private int getRes(int[] arr1, int[] arr2, int kth) {
        if (arr1 == null || arr2 == null) {
            throw new RuntimeException("");
        }

        if (kth < 1 || kth > arr1.length + arr2.length) {
            throw new RuntimeException("");
        }
        int[] longs = arr1.length >= arr2.length ? arr1 : arr2;
        int[] shorts = arr1.length < arr2.length ? arr1 : arr2;
        int lenL = longs.length;
        int lenS = shorts.length;
        if (kth <= lenS) {
            return getMedian(longs, 0, kth - 1, shorts, 0, kth - 1);
        }

        if (kth > lenL) {
            if (longs[kth - lenS - 1] >= shorts[lenS - 1]) {
                return longs[kth - lenS - 1];
            }
            if (shorts[kth - lenL - 1] >= longs[lenL - 1]) {
                return shorts[kth - lenL - 1];
            }
            return getMedian(longs, kth - lenS, lenL - 1, shorts, kth - lenL, lenS - 1);
        }
        // lenS<kth<=lenL
        if (longs[kth - lenS - 1] >= shorts[lenS - 1]) {
            return longs[kth - lenS - 1];
        }

        return getMedian(shorts, 0, lenS - 1, longs, kth - lenS, kth - 1);
    }


    private Integer getMedian(int[] arr1, int start1, int end1, int[] arr2, int start2, int end2) {
        int offset = 0;
        int mid1 = 0;
        int mid2 = 0;
        while (start1 < end1) {
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
