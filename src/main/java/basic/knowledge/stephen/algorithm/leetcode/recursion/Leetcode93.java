package basic.knowledge.stephen.algorithm.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class Leetcode93 {
    static List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        List<String> res = restoreIpAddresses("0000");
        System.out.println(res);
    }

    static List<String> restoreIpAddresses(String s) {
        restoreIpAddresses(s, "", 3);
        return res;
    }

    static void restoreIpAddresses(String s, String result, int k) {
        if (s.length() < k + 1 || s.length() > (k + 1) * 3) {
            return;
        }

        if (k == 0) {
            if ((s.startsWith("0")  && s.length() >= 2)|| Integer.parseInt(s) >= 256) {
                return;
            }
            res.add(result + "." + s);
            return;
        }
        String temp;
        for (int i = 1; i <= s.length(); i++) {
            temp = s.substring(0, i);
            if (temp.startsWith("0") && temp.length() >= 2) {
                break;
            }
            if (Integer.parseInt(temp) < 256) {
                String str= s.substring(i);  //这里不能s = s.substring(i); 因为只能在递归下分割, 同层的i =2 ,3 还是要保留s
                // go on
                if(result.length() > 0){
                    temp = result + "." + temp;
                }
                restoreIpAddresses(str, temp, k - 1);
            } else {
                break;
            }
        }
    }
}
