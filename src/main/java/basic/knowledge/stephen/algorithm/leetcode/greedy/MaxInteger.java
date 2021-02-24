package basic.knowledge.stephen.algorithm.leetcode.greedy;


//最大整数问题

import java.util.Arrays;
import java.util.Comparator;

/**
 * （1）最大整数【拼数问题】
 * <p>
 * 设有n个正整数（n≤20），将它们联接成一排，组成一个最大的多位整数。
 * <p>
 * 例如：n=3时，3个整数13，312，343联接成的最大整数为：34331213；
 * <p>
 * 又如：n=4时，4个整数7，13，4，246联接成的最大整数为：7424613
 * <p>
 * 输入
 * <p>
 * n
 * <p>
 * n个数
 * <p>
 * 输出
 * <p>
 * 连接成的多位数
 * <p>
 * 样例输入
 * <p>
 * 3
 * <p>
 * 13 312 343
 * <p>
 * 样例输出
 * <p>
 * 34331213
 * <p>
 * 【分析】字符串排序的规则：首先按字典序，然后看串长度。如7>414 321>32
 */
public class MaxInteger {
    public static void main(String[] args) {
        MaxInteger maxInteger = new MaxInteger();
        String[] arr = new String[]{"7", "2463", "4", "246"};
        String res = maxInteger.solution(arr);
        String res2 = maxInteger.solution2(arr);
        System.out.println(res == res2);
    }

    private String solution(String[] arr) {
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o2.compareTo(o1);
                } else {
                    String smaller = o1.length() > o2.length() ? o2 : o1;
                    String longer = o1.length() < o2.length() ? o2 : o1;
                    String lognerRight = longer.substring(smaller.length());
                    String lognerLeft = longer.substring(0, smaller.length());
                    if (lognerLeft.compareTo(smaller) != 0) {
                        return o2.compareTo(o1);
                    } else {
                        return lognerRight.compareTo(smaller);
                    }
                }
            }
        });

        String res = "";
        for (String str : arr) {
            res += str;
        }

        return res;
    }

    /**
     * 不行的
     *
     * @param arr
     * @return
     */
    private String solution2(String[] arr) {
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });

        String res = "";
        for (String str : arr) {
            res += str;
        }

        return res;
    }
}
