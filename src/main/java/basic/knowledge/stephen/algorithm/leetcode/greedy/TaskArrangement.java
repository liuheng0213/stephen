package basic.knowledge.stephen.algorithm.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 4.  区间问题
 * 就是leetcode 435
 * 能找到几个不重合的区间
 * <p>
 * （1）不相交区间选择问题【区间调度问题】
 * <p>
 * 有n项工作，每项工作分别在si时间开始，在ti时间结束。对于每项工作，你都可以选择参与与否。如果选择了参与，那么自始至终都必须全程参与。此外，参与工作的时间段不能重叠（即使是开始与结束的瞬间重叠也是不允许的）。
 * <p>
 * 你的目标是参与尽可能多的工作，那么最多能参与多少项工作呢？1<=n<=100000，1<=si<=ti<=10^9。
 * <p>
 * 输入
 * <p>
 * n
 * <p>
 * n项工作的开始与结束时间
 * <p>
 * 输出
 * <p>
 * 最多参与的工作项数
 * <p>
 * 样例输入1
 * <p>
 * 5
 * <p>
 * 1 3
 * <p>
 * 2 5
 * <p>
 * 4 7
 * <p>
 * 6 9
 * <p>
 * 8 10
 * <p>
 * 样例输出1
 * <p>
 * 3
 * <p>
 * 样例输入2
 * <p>
 * 3
 * <p>
 * 5 20
 * <p>
 * 14 17
 * <p>
 * 8 11
 * <p>
 * 样例输出2
 * <p>
 * 2
 * <p>
 * 【分析】
 * <p>
 * 此问题可通过贪心算法求解，我们容易想到以下3种算法
 * <p>
 * （1）在可选的工作中，每次都选取开始时间最早的工作
 * <p>
 * （2）在可选的工作中，每次都选取结束时间最早的工作
 * <p>
 * （3）在可选的工作中，每次都选取用时最短的工作
 * <p>
 * （4）在可选的工作中，每次都选取与最少可选工作有重叠的工作
 * <p>
 * 显然（2）是正确的，其它3种算法都易举出反例；或者说在有些情况下，它们并不一定能得到最优解。
 */
public class TaskArrangement {
    public static void main(String[] args) {
        TaskArrangement taskArrangement = new TaskArrangement();
        int[][] intervals = new int[][]{{1, 3}, {2, 5}, {4, 7}, {6, 9}, {8, 10}};
        int res = taskArrangement.solution(intervals);
        System.out.println(res);
    }

    /**
     * @param intervals
     * @return
     */
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

        for (int i = 0; i < intervals.length; i++) {
            if(intervals[i][0] <= end){
                continue;
            }
            end = intervals[i][1];
            count++;
        }
        return count;
    }

}
