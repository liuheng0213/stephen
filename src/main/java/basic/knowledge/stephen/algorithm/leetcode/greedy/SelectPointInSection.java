package basic.knowledge.stephen.algorithm.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * leetcode452
 * （2）区间选点问题
 * 数轴上有n个闭区间[ai, bi]，取尽量少的点，使得每个区间内都至少有一个点。（不同区间内含的点可以是同一个，1<=n<=10000，1<=ai<=bi<=10^9）。求最少点的个数。
 * <p>
 * 输入输出同（1）
 * <p>
 * 样例输入1
 * <p>
 * 4
 * <p>
 * 3 13
 * <p>
 * 6 20
 * <p>
 * 4 14
 * <p>
 * 1 10
 * <p>
 * 样例输出1
 * <p>
 * 1
 * <p>
 * 样例输入2
 * <p>
 * 3
 * <p>
 * 4 7
 * <p>
 * 6 8
 * <p>
 * 11 20
 * <p>
 * 样例输出2
 * <p>
 * 2
 * <p>
 * 【分析】若区间i内已经有一个点被取到，则称此区间已经被满足。由于小区间被满足时大区间也一定被满足，所以在区间包含的情况下，大区间不需考虑。
 * <p>
 * 把所有区间按b递增排序（b相同时a递减排序），则如果出现区间包含的情况，小区间一定排在前面。此处的贪心策略：取第一个区间的最后一个点。

 */
public class SelectPointInSection {
    public static void main(String[] args) {
        SelectPointInSection selectPointInSection = new SelectPointInSection();
        int[][] intervals = new int[][]{{4, 7}, {6, 8}, {11, 20}};
        int res = selectPointInSection.solution(intervals);
        System.out.println(res);
    }

    private int solution(int[][] intervals) {
        // 特殊情况处理
        if (intervals.length == 0) {
            return 0;
        }

        //先排序 以区间末端从小到大排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int end = intervals[0][1];
        int count = 1;

        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < end){
                continue;
            }
            end = intervals[i][1];
            count++;
        }
        return count;
    }
}
