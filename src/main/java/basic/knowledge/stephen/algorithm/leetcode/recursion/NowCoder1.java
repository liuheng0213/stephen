package basic.knowledge.stephen.algorithm.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class NowCoder1 {
    static List<String> res = new ArrayList<>();

    public static void main(String[] args) {

        String s = "12345";

        int sum = solution(s);
        System.out.println(res);
        System.out.println(sum);
    }

    private static int solution(String s) {

        handle(s, "", s.length(), 0);
        int sum = 0;
        for (String str : res) {
            String[] split = str.split("\\+");
            for (String sub : split) {
                sum += Integer.parseInt(sub);
            }
        }
        return sum;
    }

    private static void handle(String s, String result, int n, int k) {
        if (k == n) {
            return;
        }
        if (k == 0) {
            res.add(s);
            handle(s, result, n, k + 1);
        } else {
            for (int i = 1; i < s.length(); i++) {
                String temp = s.substring(0, i);
                String str = s.substring(i);
                temp = result + temp + "+";
                res.add(temp + str);
                handle(str, temp, n, k + 1);
            }
        }
    }

}
