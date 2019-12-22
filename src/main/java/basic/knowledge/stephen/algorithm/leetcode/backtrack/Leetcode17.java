package basic.knowledge.stephen.algorithm.leetcode.backtrack;

import java.util.ArrayList;

/**
 * dict.insert(make_pair<int, string>(2, "abc"));
 * dict.insert(make_pair<int, string>(3, "def"));
 * dict.insert(make_pair<int, string>(4, "ghi"));
 * dict.insert(make_pair<int, string>(5, "jkl"));
 * dict.insert(make_pair<int, string>(6, "mno"));
 * dict.insert(make_pair<int, string>(7, "pqrs"));
 * dict.insert(make_pair<int, string>(8, "tuv"));
 * dict.insert(make_pair<int, string>(9, "wxyz"));
 */
public class Leetcode17 {
    static ArrayList<String> result = new ArrayList<>();


    static StringBuffer resultStrings = new StringBuffer();
    static StringBuffer subResultStrings = new StringBuffer();
    public static void main(String[] args) {
        String press = "23";
        String[][] arr = {{"a", "b", "c"}, {"d", "e", "f"}};
        handleString(arr,0);
        System.out.println(resultStrings);
        System.out.println(result);
    }

    private static void handleString(String[][] arr, int n) {
        if(n == arr.length){
            resultStrings.append(subResultStrings + "\n");
            result.add(subResultStrings.toString());
            return;
        }

        for (int i = 0; i < arr[n].length; i++) {
            subResultStrings.append(arr[n][i]);
            handleString(arr, n + 1);
            subResultStrings.deleteCharAt(subResultStrings.length() - 1);
        }
    }

}
