package basic.knowledge.stephen.algorithm_4_Edition.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String s = "125";
        char[] chars = s.toCharArray();
        List<String> strList = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            strList.add("" + chars[i]);
        }

        ArrayList<Integer> target = new ArrayList<>();
        handle(target, strList, new StringBuilder(s),0);
        int sum = 0;
        for (Integer i : target) {
            sum += i;
        }
        System.out.println(sum);
    }

    private static void handle(ArrayList<Integer> target, List<String> strList,StringBuilder sb, int n) {
        if (n == strList.size()) {
            return;
        }
        String str = strList.get(n);
        List<Integer> tempList = new ArrayList<>();
        tempList.add(Integer.valueOf(String.valueOf(target.get(target.size() - 1)) + str));
        tempList.add(Integer.valueOf(str));
        tempList.add(Integer.valueOf(sb.toString()));
        sb.deleteCharAt(strList.size() - n - 1);
        target.addAll(tempList);
        handle(target, strList, sb,n + 1);
    }
}
