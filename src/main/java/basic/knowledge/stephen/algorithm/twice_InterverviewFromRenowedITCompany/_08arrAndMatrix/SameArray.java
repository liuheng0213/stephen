package basic.knowledge.stephen.algorithm.twice_InterverviewFromRenowedITCompany._08arrAndMatrix;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SameArray {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 2, 4, 8, 22, 46, 127, 3, 4, 24};
        int[] arr2 = new int[]{1, 1, 2, 8, 23, 4};
        //HashSet<Integer> set = new HashSet<>();
        //getSameArr(arr1, arr2, set);
        List<Integer> res = getSameArrHash(arr1, arr2);
        System.out.println(res);
    }

    private static List<Integer> getSameArrHash(int[] arr1, int[] arr2) {
        HashSet<Integer> set1 = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr1.length; i++) {
            if (!set1.contains(arr1[i])) {
                set1.add(arr1[i]);
            }
        }


        for (int i = 0; i < arr2.length; i++) {
            if (set1.contains(arr2[i])) {
                list.add(arr2[i]);
            }
        }
        return list;
    }

    private static void getSameArr(int[] arr1, int[] arr2, HashSet<Integer> res) {
        process(arr1, 0, arr1.length - 1, arr2, 0, arr2.length - 1, res);
    }

    private static void process(int[] arr1, int left1, int right1, int[] arr2, int left2, int right2, HashSet<Integer> res) {
        if (left1 >= right1 && left2 >= right2) {
            if (arr1[left1] == arr2[left2]) {
                res.add(arr1[left1]);
            }
            return;
        } else if (left1 >= right1 && left2 < right2) {
            for (int i = left2; i <= right2; i++) {
                if (arr2[i] == arr1[left1]) {
                    res.add(arr1[left1]);
                }
            }
            return;
        } else if (left2 >= right2 && left1 < right1) {
            for (int i = left1; i <= right1; i++) {
                if (arr1[i] == arr2[left2]) {
                    res.add(arr2[left2]);
                }
            }
            return;
        }
        int mid1 = (right1 + left1) >> 1;
        int mid2 = (right2 + left2) >> 1;
        process(arr1, left1, mid1, arr2, left2, mid2, res);//1左 和 2左
        process(arr1, mid1 + 1, right1, arr2, left2, mid2, res);//1右  2 左
        process(arr1, left1, mid1, arr2, mid2 + 1, right2, res);//1 左   2 右
        process(arr1, mid1 + 1, right1, arr2, mid2 + 1, right2, res);//1右  2 右

    }
}
