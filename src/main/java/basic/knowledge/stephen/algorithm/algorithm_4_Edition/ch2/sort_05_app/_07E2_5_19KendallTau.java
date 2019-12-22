package basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch2.sort_05_app;

import basic.knowledge.stephen.algorithm.algorithm_4_Edition.util.SortUtil;

public class _07E2_5_19KendallTau {
    public static void main(String[] args) {
        int num = getKendallTau(new Integer[]{0, 3, 1, 6, 2, 5, 4}, new Integer[]{1, 0, 3, 6, 4, 2, 5});
        System.out.println(num);
    }

    /**
     * 0 3 1 6 2 5 4   a[i]  i = 0 ,1, 2, 3,4,5,6
     * 0 1 2 3 4 5 6   ainv[0] = 0, ainv[3] = 1, ainv[1] = 2, ainv[6] = 3, ainv[2] = 4, ainv[4] = 5, ainv[4] = 6,
     * 1 0 3 6 4 2 5   b[i]  b[0] = 1
     * target : 2 0 1 3 6 4 5   bnew[0] = ainv[b[0]] = ainv[1] =2, bnew[1] = ainv[b[1]]=ainv[0]=0
     */
    private static int getKendallTau(Integer[] a, Integer[] b) {
        if (a.length != b.length) {
            return -1;
        }
        Integer[] ainv = new Integer[a.length];
        for (int i = 0; i < a.length; i++) {
            ainv[a[i]] = i;
        }

        Integer[] bnew = new Integer[b.length];
        for (int i = 0; i < b.length; i++) {
            bnew[i] = ainv[b[i]];
        }

        return calcInverseNum(bnew);

    }

    private static int calcInverseNum(Integer[] bnew) {
        Integer ori = bnew[0];
        int total = 0;
        for (int i = 1; i < bnew.length; i++) {
            if (SortUtil.less(bnew[i], ori)) {
                total++;
            } else if (SortUtil.greater(bnew[i], ori)) {
                ori = bnew[i];
            }
        }
        return total;
    }
}
