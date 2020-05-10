package basic.knowledge.stephen.algorithm.leetcode.greedy;


import java.util.Arrays;
import java.util.Comparator;

/**
 * 题目描述：每个坐标表示气球存在的区间，要求用最少的箭（射箭方向垂直坐标轴 ）射完所有的气球。
 * <p>
 * 输入:
 * [[10,16], [2,8], [1,6], [7,12]]
 * <p>
 * 输出:
 * 2
 * <p>
 * 解释:
 * 对于该样例，我们可以在x = 6（射爆[2,8],[1,6]两个气球）和 x = 11（射爆另外两个气球）。
 */
public class Leetcode452ShootBalloon {
    public static void main(String[] args) {
        Leetcode452ShootBalloon shootBallon = new Leetcode452ShootBalloon();
        int[][] arr2 = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int res1 = shootBallon.eraseOverlapIntervals1(arr2);
        System.out.println(res1);
    }

    private int eraseOverlapIntervals1(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });


        int count = 1;
        int pre = 0;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] > points[pre][1]) {
                pre = i;
                count++;
            }
        }
        return count;

    }

}
