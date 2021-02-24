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

        int[][] arr = {{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}};

        int[][] arr2 = new int[][]{{1, 6}, {2, 8}, {10, 16}, {7, 12}};

        int res1 = shootBallon.eraseOverlapIntervals1(arr);
        System.out.println(res1);
    }

    private int eraseOverlapIntervals1(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.valueOf(o1[1]).compareTo(Integer.valueOf(o2[1]));
            }
        });
        int ans = 1;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= end) {
                continue;
            }
            ans++;
            end = points[i][1];
        }
        return ans;

    }

}
