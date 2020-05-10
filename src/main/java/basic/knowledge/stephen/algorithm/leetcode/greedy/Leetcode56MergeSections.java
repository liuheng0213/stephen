package basic.knowledge.stephen.algorithm.leetcode.greedy;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class Leetcode56MergeSections {
    public static void main(String[] args) {
        Leetcode56MergeSections leetcode56MergeSections = new Leetcode56MergeSections();
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] res = leetcode56MergeSections.mergeSections(intervals);
        System.out.println(res);
    }

    private int[][] mergeSections(int[][] intervals) {
        if (intervals == null || intervals.length == 0
                || intervals[0].length == 0) {
            return new int[0][0];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int pre = 0;
        int start = intervals[pre][0];
        int end = intervals[pre][1];
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subRes = new ArrayList<>();
        subRes.add(start);
        subRes.add(end);
        res.add(subRes);
        for (int i = 1; i < intervals.length; i++) {
            //只更新
            if (end >= intervals[i][0]) {
                start = intervals[pre][0];
                end = Math.max(end, intervals[i][1]);
                subRes.set(0, start);
                subRes.set(1, end);
            }
            //只添加
            else if (intervals[i][0] > end) {
                start = intervals[i][0];
                end = intervals[i][1];
                subRes = new ArrayList<>();
                subRes.add(start);
                subRes.add(end);
                res.add(subRes);
                pre = i;
            }
        }

        int[][] arr = new int[res.size()][subRes.size()];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = res.get(i).get(j);
            }
        }

        return arr;
    }
}
