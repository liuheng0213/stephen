package basic.knowledge.stephen.algorithm.leetcode.greedy;

import java.util.ArrayList;
import java.util.List;

public class Leetcode728 {
    public static void main(String[] args) {
        Leetcode728 obj = new Leetcode728();
        List<Integer> integers = obj.selfDividingNumbers(1, 22);
        System.out.println(integers);
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividingNumbers(i)) {
                list.add(i);
            }
        }
        return list;
    }

    private boolean isSelfDividingNumbers(int num) {
        String s = String.valueOf(num);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '0') {
                return false;
            } else {
                if(num % Integer.valueOf(c - '0') == 0){
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
