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
     * totalInterval > 0 就是Interval 没填满
     * totalInterval <= 0 就是nterva 填满了
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
            while (i <= n) {// 0 , i, ...,   n 个 空余时间, 放 N 个任务 但是不要忘记0
                if (count[25] == 0) {
                    break;
                }
                if (i < 26 && count[25 - i] > 0) {
                    count[25 - i]--;
                }
                result++;
                i++;
            }
            //一定要重新排序 保证count[25] 是最大数目的那个字符
            // 因为出来上面这个while 已经是把一开始最多的搞定,现在搞定第二多的
            Arrays.sort(count);

        }

        return result;
    }
}
