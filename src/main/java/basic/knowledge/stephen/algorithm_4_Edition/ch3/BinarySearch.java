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


        int i = mid;
        while (!SortUtil.equals(target, sortedArr[i])) {
            if (SortUtil.less(target, sortedArr[i])) {
                hi = i - 1;
            } else {
                lo = i + 1;
            }
            mid = (lo + hi) / 2;

            i = mid;

            // no target foundt
            if (lo > hi) {  //不可以lo >= hi 因为有可能arr[hi] = arr[lo] = arr[mid] = target
                break;
            }
        }

        return i;
    }
}
