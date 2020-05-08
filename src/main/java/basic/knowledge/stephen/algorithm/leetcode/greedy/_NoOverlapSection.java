package basic.knowledge.stephen.algorithm.leetcode.greedy;
//Leetcode_435. 无重叠区间

import java.util.Arrays;
import java.util.Comparator;

/**
 * 题目描述：

 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。

 注意:

 可以认为区间的终点总是大于它的起点。
 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。

 示例 1:

 输入: [ [1,2], [2,3], [3,4], [1,3] ]

 输出: 1

 解释: 移除 [1,3] 后，剩下的区间没有重叠。

 示例 2:

 输入: [ [1,2], [1,2], [1,2] ]

 输出: 2

 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。

 示例 3:

 输入: [ [1,2], [2,3] ]

 输出: 0

 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 */
public class _NoOverlapSection {
    public int eraseOverlapIntervals(int[][] intervals) {
        // 特殊情况处理
        if (intervals.length == 0) {
            return 0;
        }
        // 先排序 以区间末端从小到大排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        // 最多能组成的不重叠区间个数
        int count = 1;
        // 前一区间的末端位置
        int end = intervals[0][1];
        for (int i = 0; i < intervals.length; i++) {
            // 两个区间有重叠
            if (intervals[i][0] < end) {
                continue;
            }
            // 两个区间无重叠 修正前一区间末端位置
            end = intervals[i][1];
            // 不重叠区间数+1
            count++;
        }
        // 总区间数 - 不重叠区间数 = 要删去的区间数
        return intervals.length - count;
    }
}
