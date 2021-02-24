package basic.knowledge.stephen.algorithm.leetcode.greedy;

public class Leetcode738 {
    public static void main(String[] args) {
        Leetcode738 obj = new Leetcode738();
        int res = obj.monotoneIncreasingDigits(1234);
        System.out.println(res);
    }

    public int monotoneIncreasingDigits(int N) {
        char[] chs = String.valueOf(N).toCharArray();
        int n = chs.length, j = chs.length;
        for (int i = n - 1; i > 0; i--) {
            if (chs[i] >= chs[i - 1]) continue;
            --chs[i - 1];
            j = i;
        }
        for (int i = j; i < n; i++) {
            chs[i] = '9';
        }
        return Integer.valueOf(String.valueOf(chs));

    }
}
