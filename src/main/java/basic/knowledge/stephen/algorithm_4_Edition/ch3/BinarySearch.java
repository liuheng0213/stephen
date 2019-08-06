package basic.knowledge.stephen.algorithm_4_Edition.ch3;

import basic.knowledge.stephen.algorithm_4_Edition.mock.MockData;
import basic.knowledge.stephen.algorithm_4_Edition.util.SortUtil;

public class BinarySearch {
    public static void main(String[] args) {
        int i = binarySearch(20, MockData.SORTED_INTEGER);
        System.out.println(i);
    }

    private static int binarySearch(Comparable target, Comparable[] sortedArr) {
        int lo = 0;
        int hi = sortedArr.length - 1;
        int mid = (lo + hi) / 2;


        while (!SortUtil.equals(target, sortedArr[mid])) {
            // no target found
            if (lo > hi) {  //不可以lo >= hi 因为有可能arr[hi] = arr[lo] = arr[mid] = target
                break;
            }
            if (SortUtil.less(target, sortedArr[mid])) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
            mid = (lo + hi) / 2;
        }

        return mid;
    }
}
