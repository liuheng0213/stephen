package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._09others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

//分糖果问题
public class _14CandyAllocation {
    public static void main(String[] args) {
        _14CandyAllocation candyDistribution2 = new _14CandyAllocation();
        int[] arr = new int[]{1, 4, 5, 9, 3, 2};//answer  is 49
        //int nums = candyDistribution2.candy(arr);
        int nums = candyDistribution2.longestPalindrome("NTrQdQGgwtxqRTSBOitAXUkwGLgUHtQOmYMwZlUxqZysKpZxRoehgirdMUgy");
        System.out.println(nums);
    }



    public int longestPalindrome(String s) {
        // write your code here
        char[] chs = s.toCharArray();
        int[] text = new int[52];
        Integer[] map = new Integer[256];
        for(int i = 0;i< map.length;i++){
            map[i] = 0;
        }
        for(int i = 0;i< chs.length;i++){
            map[chs[i] - 'A']++;
        }
        Arrays.sort(map,new Comparator<Integer>(){
            public int compare(Integer n1,Integer n2){
                return n2 - n1;
            }
        });

        int palinOdd = 0;
        int palinEven = 0;
        int oddNum = 0;
        for(int i = 0;i< map.length;i++){
            if(map[i] % 2 == 0){
                palinEven+= map[i];
            }else {
                if(oddNum == 0){
                    palinOdd += map[i];
                    oddNum++;
                }
            }

            if(map[i] == 0){
                break;
            }
        }

        return palinOdd + palinEven;

    }

    private int candy(int[] ratings) {



        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        //初始得 res 不涉及到大小怎样加减得问题
        int index = nextMinIndex(ratings, 0);
        int res = getCandyNums(ratings, 0, index++);

        int upSlopes = 1;//1,2,3,4,5
        int downSlopes = 0;//5,4,3,2,1
        int rightCandyNums = 0;
        //刚入 while 必定是arr[index] < arr[index - 1]
        while (index < ratings.length) {
            if (ratings[index] < ratings[index - 1]) {
                int newIndex = nextMinIndex(ratings, index - 1);
                rightCandyNums = getCandyNums(ratings, index - 1, newIndex++);
                downSlopes = newIndex - index + 1;
                res += rightCandyNums + (upSlopes > downSlopes ? -downSlopes : -upSlopes);
                upSlopes = 1;
                index = newIndex;
            } else if (ratings[index] > ratings[index - 1]) {
                res += ++upSlopes;
                index++;
            } else {
                res++;
                upSlopes = 1;
                index++;
            }
        }
        return res;
    }

    private int nextMinIndex(int[] arr, int start) {
        for (int i = start; i < arr.length - 1; i++) {
            if (arr[i] <= arr[i + 1]) {
                return i;
            }
        }
        return arr.length - 1;
    }

    private int getCandyNums(int[] arr, int start, int end) {
        int n = end - start + 1;
        return n + n * (n - 1) / 2;
    }


    private int nextMaxIndex(int[] arr, int start) {
        for (int i = start; i < arr.length - 1; i++) {
            if (arr[i] >= arr[i + 1]) {
                return i;
            }
        }
        return arr.length - 1;
    }
}
