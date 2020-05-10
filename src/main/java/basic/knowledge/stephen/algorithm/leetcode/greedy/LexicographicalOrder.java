package basic.knowledge.stephen.algorithm.leetcode.greedy;


//字典序问题

import java.io.IOException;

/**
 * 给定长度为N的字符串S, 要构造一个长度为N的字符串T。起初，T是一个空串，随后反复进行下列任意操作：
 * <p>
 * 从S的头部删除一个字符，加到T的尾部
 * <p>
 * 从S的尾部删除一个字符，加到T的尾部
 * 目标是要构造字典序尽可能小的字符串T。
 * <p>
 * 思路：取两端小的，如果两段一样，就比较下一个字符的大小，希望尽早使用更小的字符
 */
public class LexicographicalOrder {
    public static void main(String[] args) throws IOException {
        char arr[] = {'A', 'C', 'D', 'B', 'C', 'B'};
        char arr2[] = {'A', 'C', 'B', 'B'};
        LexicographicalOrder lexicographicalOrder = new LexicographicalOrder();
        String res = lexicographicalOrder.solution(arr);
        System.out.println(res);
    }

    public String solution(char arr[]) {
        int a = 0, b = arr.length - 1;
        String res = "";
        while (a <= b) {
            boolean left = false;
            for (int i = 0; a + i <= b; i++) {
                if (arr[a + i] < arr[b - i]) {
                    left = true;
                    break;
                } else if (arr[a + i] > arr[b - i]) {
                    left = false;
                    break;
                }
            }
            if (left) {
                res += arr[a++];
            } else {
                res += arr[b--];
            }
        }
        return res;
    }
}
