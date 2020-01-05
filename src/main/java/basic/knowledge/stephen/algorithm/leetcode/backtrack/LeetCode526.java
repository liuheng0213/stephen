package basic.knowledge.stephen.algorithm.leetcode.backtrack;

public class LeetCode526 {
    static int totalNum = 0;

    public static void main(String[] args) {
        int total = solution(15);
        System.out.println(total);
    }

    private static int solution(int n) {
        long begin = System.currentTimeMillis();
        boolean[] used = new boolean[n + 1];

        //getTotalBeautifulArrangement(used, 1, n);
        bettergetTotalBeautifulArrangement(used, n, n);// better faster
        long end = System.currentTimeMillis();
        System.out.println("time consumed :" + (end - begin));
        return totalNum;
    }

    private static void bettergetTotalBeautifulArrangement(boolean[] used, int num, int n) {
        if (num == 0) {
            totalNum++;
            return;
        }
        for (int i = 1; i < used.length; i++) {
            if (used[i] == false && (i % num == 0 || num % i == 0)) {
                used[i] = true;
                bettergetTotalBeautifulArrangement(used, num - 1, n);
                used[i] = false;
            }
        }
    }

    private static void getTotalBeautifulArrangement(boolean[] used, int num, int n) {
        if (num == n + 1) {
            totalNum++;
            return;
        }
        for (int i = 1; i < used.length; i++) {
            if (used[i] == false && (i % num == 0 || num % i == 0)) {
                used[i] = true;
                getTotalBeautifulArrangement(used, num + 1, n);
                used[i] = false;
            }
        }
    }
}
