package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;

//跳跃游戏
public class _18JumpGame {

    public static void main(String[] args) {
        _18JumpGame jumpGame = new _18JumpGame();
        int[] arr = new int[]{3, 2, 3, 1, 1, 4};
        int[] arr2 = new int[]{1, 1, 2, 1, 1, 1};
        int[] arr3 = new int[]{5, 4, 3, 2, 1, 0, 3, 2, 1, 5};
        int res = jumpGame.jump(arr);
        System.out.println(res);
//        boolean flag = jumpGame.jumpB(arr3);
//        System.out.println(flag);
    }

    /**
     * // 最后在做一些说明。这里应用贪心算法，，第一，一定遍历所有元素，而不是跳跃。第二注意maxreach的更新方法：
     * 是上一个循环能够达到的最大值，和当前能够达到的最大值即i+nums[i]之间的较大者。
     *
     * @param arr
     * @return
     */
    private boolean jumpB(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }

        int N = arr.length;
        int maxreach = 0; //注意是下标值，而不是元素值
        for (int i = 0; i < N; ++i) {
            if (i > maxreach) {//注意false的条件，就是maxreach停止了，而i仍然在增加，一直到超过maxreach也没有停止，对应题目中的反例很好理解, 这就是i i(不含)之前的所有位置起跳都到不了 i 的情况
                return false;
            }
            maxreach = Math.max(maxreach, i + arr[i]);  //注意更新方法
            if (maxreach >= N - 1) {  //一个小细节，要写成>=而不是写成==
                return true;
            }
        }
        return false;
    }

    private int jump(int[] arr) {
        int times = 0;
        int cur = 0;
        int next = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i > cur) {
                times++;
                cur = next;
            }
            next = Math.max(next, arr[i] + i);
        }
        return times;
    }


}
