package basic.knowledge.stephen.algorithm.leetcode.greedy;


import java.util.Arrays;
import java.util.Comparator;

/**
 * Leetcode_435. 无重叠区间
 * 题目描述：
 * <p>
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * <p>
 * 注意:
 * <p>
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 * <p>
 * 输出: 1
 * <p>
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * <p>
 * 示例 2:
 * <p>
 * 输入: [ [1,2], [1,2], [1,2] ]
 * <p>
 * 输出: 2
 * <p>
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * <p>
 * 示例 3:
 * <p>
 * 输入: [ [1,2], [2,3] ]
 * <p>
 * 输出: 0
 * <p>
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 */
public class Leetcode435NoOverlapSection {
    public static void main(String[] args) {
        Leetcode435NoOverlapSection noOverlapSection = new Leetcode435NoOverlapSection();
        int[][] arr = new int[][]{{2, 4}, {1, 5}, {4, 6}};
        int[][] arr1 = new int[][]{{2, 4}, {1, 5}, {4, 6}, {5, 7}};
        int res = noOverlapSection.eraseOverlapIntervals(arr);
        System.out.println(res);
    }


    public int eraseOverlapIntervals(int[][] intervals) {

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

        //最多能组成的不重叠区间个数
        int count = 1;

        //前一区间的末端位置
        int end = intervals[0][1];
        int pre = 0;
        for (int i = 0; i < intervals.length; i++) {
            // 原则: 一旦找到  一个 新的非重叠部分  那么找到的当前的i 与之前构成的(end or pre)非重叠 是一个整体了
            // 这一个整体  中有两个不重叠的区间
            // 下一步需要重新开辟
/*

            if (intervals[i][0] < end) {
                continue;
            }
            //两个区间无重叠 修正前一区间末端位置
            //因为事前已经排序 这两个区间不重叠  绝不可能和之前的重叠 所以只用count  + 1就行
            end = intervals[i][1];
            //不重叠区间数+1
            count++;

*/


            /**
             *
             * 我们首先将输入的intervals按照end排序，
             * 然后保证我们每次放入区间的end最小，
             * 也就是对于后面要加入的区间留有更多的余地。
             */
            if(intervals[i][0] >= intervals[pre][1]){
                pre = i;
                count++;
            }
        }

        //总区间数 - 不重叠区间数 = 要删去的区间数
        return  intervals.length - count;
    }
}
