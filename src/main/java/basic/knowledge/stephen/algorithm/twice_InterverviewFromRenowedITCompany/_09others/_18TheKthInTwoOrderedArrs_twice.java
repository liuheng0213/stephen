package basic.knowledge.stephen.algorithm.twice_InterverviewFromRenowedITCompany._09others;

public class _18TheKthInTwoOrderedArrs_twice {
    public static void main(String[] args) {
        _18TheKthInTwoOrderedArrs_twice obj = new _18TheKthInTwoOrderedArrs_twice();
        int[] arr1 = new int[]{1, 2, 3};
        int[] arr2 = new int[]{3, 4, 5, 6};
        int res = obj.getRes(arr1, arr2, 4);
        System.out.println(res);
    }

    private int getRes(int[] arr1, int[] arr2, int kth) {
        if (arr1 == null || arr2 == null) {
            throw new RuntimeException();
        }
        int[] longArr = arr1.length > arr2.length ? arr1 : arr2;
        int[] shortArr = longArr == arr1 ? arr2 : arr1;

        int longLen = longArr.length;
        int shotLen = shortArr.length;

        if (kth <= shotLen) {
            return getMedian(shortArr, 0, kth - 1, longArr, 0, kth - 1);
        }

        if (kth > shotLen && kth <= longLen) {
            return getMedian(shortArr, 0, shotLen - 1, longArr, kth - shotLen, kth - 1);
        }


        if (longArr[kth - shotLen - 1] >= shortArr[shotLen - 1]) {
            return longArr[kth - shotLen - 1];
        }

        if (shortArr[kth - longLen - 1] >= longArr[longLen - 1]) {
            return shortArr[kth - longLen - 1];
        }

        return getMedian(shortArr, 0, kth - longLen, longArr, kth - shotLen, longLen - 1);

    }

    private int getMedian(int[] shortArr, int start1, int end1, int[] longArr, int start2, int end2) {
        int mid1;
        int mid2;
        int offset;
        while (start1 < end1) {
            mid1 = (start1 + end1) >> 1;
            mid2 = (start2 + end2) >> 1;
            offset = (end1 - start1 + 1) % 2 == 0 ? 1 : 0;

            if(shortArr[mid1] > longArr[mid2]){
                end1 = mid1;
                start2 = mid2 + offset;
            }else if(shortArr[mid1] < longArr[mid2]){
                start1 = mid1 + offset;
                end2 = mid2;
            }else {
                return shortArr[mid1];
            }
        }

        return Math.min(shortArr[start1],longArr[start2]);
    }
}
