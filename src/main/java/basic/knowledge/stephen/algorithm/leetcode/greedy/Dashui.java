package basic.knowledge.stephen.algorithm.leetcode.greedy;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 3. 排队打水问题
 * <p>
 * 有n个人排队到r个水龙头去打水，他们装满水桶的时间t1，t2，…，tn为整数且各不相等，应如何安排他们的打水顺序才能使他们总共花费的时间最少？这里每个人的花费时间=每个人装满水桶的时间+等待时间。
 * <p>
 * 输入
 * <p>
 * 　　第一行n，r (n<=500,r<=75)
 * <p>
 * 　　第二行为n个人打水所用的时间Ti (Ti<=100)；
 * <p>
 * 输出
 * <p>
 * 　　最少的花费时间
 * <p>
 * 样例输入
 * <p>
 * 3 2
 * <p>
 * 1 2 3
 * <p>
 * 样例输出
 * <p>
 * 7
 * <p>
 * 【分析】由于排队时，越靠前面的计算的次数越多，显然越小的排在越前面得出的结果越小 因为后面那位等的时间最短（可以用数学方法简单证明，这里就不再赘述），
 * 所以这道题可以用贪心法解答，基本步骤：
 * <p>
 * (1)将输入的时间按从小到大排序；
 * <p>
 * (2)将排序后的时间按顺序依次放入每个水龙头的队列中；
 * <p>
 * (3)统计，输出答案。
 */
public class Dashui {
    public static void main(String[] args) {
        Dashui dashui = new Dashui();
        int[] arr = new int[]{1, 2, 3, 4};
        int res = dashui.timeConsume(arr, 2);
        System.out.println(res);
    }

    private int timeConsume(int[] arr, int r) {
        Arrays.sort(arr);
        LinkedList<Integer> queue = new LinkedList<>();
        int time = 0;
        for (int i = 0; i < arr.length; i++) {
            if (queue.size() < r) {
                queue.add(arr[i]);
            } else {
                Integer first = queue.pollFirst();
                time += first;// 前面打水的
                time += first;//后面等的  r = 2  时  i= 3 等的是第一个人打水的时间
                queue.add(arr[i]);
            }
        }

        while (queue.size() != 0) {
            time += queue.pollFirst();
        }

        return time;
    }

}
