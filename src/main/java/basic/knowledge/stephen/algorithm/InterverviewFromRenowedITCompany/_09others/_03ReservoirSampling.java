package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._09others;

import java.util.Arrays;

//蓄水池算法
public class _03ReservoirSampling {
    public static void main(String[] args) {
        _03ReservoirSampling reservoirSampling = new _03ReservoirSampling();
        int[] res = reservoirSampling.getKNumsRand(3, 10);
        System.out.println(Arrays.toString(res));
    }

    /**
     * rand(i) <= k  这个事件的发生概率为 k / i 是可以证明的
     *
     * @param k
     * @param n
     * @return
     */
    public int[] getKNumsRand(int k, int n) {
        if (k < 1 || n < 1) {
            return null;
        }
        int[] res = new int[Math.min(k,n)];
        for (int i = 0; i < res.length; i++) {
            res[i] = i + 1;
        }
        for (int i = k + 1; i < n + 1; i++) {
            if (rand(i) <= k) {
                res[rand(k) - 1] = i;
            }
        }
        return res;
    }

    private int rand(int i) {
        return (int) (Math.random() * i) + 1;
    }
}
