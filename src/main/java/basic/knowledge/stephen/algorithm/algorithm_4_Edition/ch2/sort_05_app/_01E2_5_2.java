package basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch2.sort_05_app;

import edu.princeton.cs.algs4.StdIn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _01E2_5_2 {
    public static void main(String[] args) {
        _01E2_5_2 e = new _01E2_5_2();
        List<String> strList = new ArrayList<>();
        while (!StdIn.isEmpty()) {
            strList.add(StdIn.readString());
        }
        String[] strArr = (String[]) strList.toArray();
        e.isCombinationAndPrint(strArr);

    }

    private class StrLengthComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.length() - o2.length();
        }
    }

    private void isCombinationAndPrint(String[] strArr) {
        Arrays.sort(strArr, new StrLengthComparator());
        int minLength = strArr[0].length() * 2;

        int combination = -1;
        while (combination < strArr.length - 1) {
            if (strArr[combination++].length() == minLength) {
                break;
            }
        }

        if (combination == -1) {
            return;
        }
        //already found the first combination  iterate 0 ~ combination
        while (combination < strArr.length) {
            int totalLength = strArr[combination].length();
            for (int i = 0; i < combination; i++) {
                int start = binarySearch(strArr, totalLength - strArr[i].length(), 0, combination - 1);
                if (start != -1) {
                    while (strArr[i].length() == strArr[start].length()) {
                        if ((strArr[i] + strArr[start]).equals(strArr[combination])) {
                            System.out.println("combination: strArr[" + combination + "]: " + strArr[combination] + "  orignates from "
                                    + "i: strArr[" + i + "] : " + strArr[i] + " and start: strArr[" + start + "] : " + strArr[start]);
                        } else if ((strArr[start] + strArr[i]).equals(strArr[combination])) {
                            System.out.println("combination: strArr[" + combination + "]: " + strArr[combination] + "  orignates from "
                                    + "start: strArr[" + start + "] : " + strArr[start] + " and i: strArr[" + i + "] : " + strArr[i]);
                        }
                        start++;
                    }
                }
            }
            combination++;
        }
    }

    private int binarySearch(String[] strArr, int length, int lo, int hi) {
        int mid = 0;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if(strArr[mid].length() == length){
                return mid;
            }else if(strArr[mid].length() < length){
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }

        return -1;
    }
}
