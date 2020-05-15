package basic.knowledge.stephen.algorithm.leetcode.greedy;


import java.util.Arrays;

//task scheduler
public class Leetcode621 {
    public static void main(String[] args) {
        Leetcode621 leetcode621 = new Leetcode621();
        char[] tasks = new char[]{'A', 'D', 'A', 'D'};
        int res = leetcode621.leastInterval(tasks, 2);
        int res1 = leetcode621.leastInterval_best(tasks, 2);
        System.out.println(res);
        System.out.println(res1);
    }

    /**
     * leastInterval_best 和 leastInterval 想象的置放方式时不一样滴
     * 这里是依据至少interval  也可以比interval大来放的  所有的元素都放到count[max]元素之间
     * @param tasks
     * @param n
     * @return
     */
    private int leastInterval_best(char[] tasks, int n) {
        int[] count = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            count[tasks[i] - 'A']++;
        }

        Arrays.sort(count);

        int maxNum = count[25] - 1;
        int totalInterval = (count[25] - 1) * n;
        for (int i = 24;i >= 0 && count[i] > 0;i--){
            totalInterval -= Math.min(maxNum, count[i]);
        }

        if(totalInterval < 0){
            return tasks.length;
        }else{
            return tasks.length + totalInterval;
        }
    }


    /**
     * 原则 统计数量最多的字母 以它起头 后面跟统计数量次多的字母,后面跟统计数量第三次多的字母... 直到塞满n ;
     * 塞满N 就重新排序, 继续上一步,
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            count[tasks[i] - 'A']++;
        }

        Arrays.sort(count);

        int result = 0;
        while (count[25] > 0) {

            int i = 0;
            while (i < n + 1) {// 0 , i, ...,   n 个 空余时间, 放 N 个任务 但是不要忘记0
                if (count[25] == 0) {
                    break;
                }
                if (i < 26 && count[25 - i] > 0) {
                    count[25 - i]--;
                }
                result++;
                i++;
            }
            //出来时  count[25] == 0
            Arrays.sort(count);
            // 此时 count[25] > 0  不一定还== 0 了 极有可能 count[25] > 0

        }

        return result;
    }
}
