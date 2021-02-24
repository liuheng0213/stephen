package basic.knowledge.stephen.algorithm.leetcode.greedy;
//（Ⅲ）乘船问题


import java.util.Arrays;

/**
 *
 * leetcode881
 * 有n个人，第i个人重量为wi，每艘船的最大载重量为C，且最多只能乘两个人。用最少的船装载所有人。题目保证有解。
 * <p>
 * 【样例输入1】
 * <p>
 * 6
 * <p>
 * 5 84 85 80 84 83
 * <p>
 * 85
 * <p>
 * 【样例输出1】
 * <p>
 * 5
 * <p>
 * 【样例输入2】
 * 3
 * <p>
 * 90 45 60
 * <p>
 * 90
 * <p>
 * 【样例输出2】
 * <p>
 * 3
 * <p>
 * 【样例输入3】
 * 5
 * <p>
 * 50 50 90 40 60
 * <p>
 * 100
 * <p>
 * 【样例输出3】
 * <p>
 * 3
 * <p>
 * 【分析】从最轻的人i开始考虑：如果每个人都无法和他一起坐船，则唯一的方法就是每人坐一艘船；
 * 否则，他应该选择能和他一起坐船的人中最重的一个j。
 * 这样的方法是贪心的，因为它只是让“眼前的浪费”最少。
 * <p>
 * 可以用反证法证明此策略的正确性：
 * <p>
 * （1）i不与任何人同船。如果将j拉来与其同船，使用的船数<=原来的船数；
 * <p>
 * （2）i与k同船。由贪心策略，因为此时i是最轻的，j是与i匹配的人中最重的，所以w[k]<=w[j]，
 * 则j加入其它船可能会使其它船超重，用的船数会变多；
 * <p>
 * 综上，说明这样的贪心法不会丢失最优解。
 * <p>
 * 故解题步骤：（循环过程）
 * <p>
 * （1）将所有人的重量进行排序；
 * <p>
 * （2）从当前最轻的人i开始考虑，找能跟其坐一艘船的最重的人j；
 * <p>
 * （3）比最重的人j都重的人都单独坐一个船；
 * <p>
 * 需要特别注意的是：循环过程中若发现i=j，表明仅剩1人待安排，此时这个人自己一船。
 */

/**
 * 原则: 让最重的  搭配一个最轻的人做一条船 否则最重的自己一条船  总之 要充分利用船的载重
 */
public class Ship {

    public static void main(String[] args) {
        Ship ship = new Ship();
        int[] arr = new int[]{5, 84, 85, 80, 84, 83};
        int res = ship.solution(arr, 85);
        System.out.println(res);
    }

    private int solution(int[] arr, int maxLoad) {
        Arrays.sort(arr);
        int boatCount = 0;
        //int n = arr.length; //乘员总数
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            if (left == right) {
                boatCount++;
                break;
            }

            if (arr[left] + arr[right] > maxLoad) {
                right--;
                //n--;
                boatCount++;
            } else {
                left++;
                right--;
                //n = n - 2;     //  一次载两个人，so -2
                boatCount++;
            }
        }
        return boatCount;
    }
}
