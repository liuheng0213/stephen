package basic.knowledge.stephen.algorithm.leetcode.greedy;


/**
 * 一辆汽车加满油后可行驶n公里。旅途中有若干个加油站。设计一个有效算法，指出应
 * 在哪些加油站停靠加油，使沿途加油次数最少。对于给定的n(n <= 5000)和k(k <= 1000)个加油站位置，编程计算最少加油次数。并证明算法能产生一个最优解。
 * 要求：
 * 输入：第一行有2个正整数n和k，表示汽车加满油后可行驶n公里，且旅途中有k个加油站。
 * 接下来的1 行中，有k+1 个整数，表示第k个加油站与第k-1 个加油站之间的距离。
 * 第0 个加油站表示出发地，汽车已加满油。第k+1 个加油站表示目的地。
 * 输出：输出编程计算出的最少加油次数。如果无法到达目的地，则输出”NoSolution”。
 */
public class OilStation {
    public static void main(String[] args) {
        int n = 100;
        int k = 5;

        // 第6 个整数  表示第5 个到第4个加油站的距离
        int[] d = {50, 80, 39, 60, 40, 32};  //50 为0~1之间的距离  d.length = k+ 1
        int result = solution(n, k, d);
        System.out.println(result);
    }

    private static int solution(int n, int k, int[] d) {
        int i = 0;
        int s = 0;
        int num = 0;
        while (i <= k) {
            s += d[i];
            if (s >= n) {
                s = d[i];
                num++;
            }
            i++;
        }
        //出循环则 i > k
        return num;
    }
}
