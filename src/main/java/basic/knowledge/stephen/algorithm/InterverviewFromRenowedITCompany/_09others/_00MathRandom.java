package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._09others;

public class _00MathRandom {
    public static void main(String[] args) {
        _00MathRandom mathRandom = new _00MathRandom();
        double i1 = 0;
        double i2 = 0;
        double i3 = 0;
        double i4 = 0;
        double i5 = 0;
        double total = 0;
        while (total <=10000000) {
            int res = mathRandom.rand1To5();
            if (res == 1) {
                i1++;
            } else if (res == 2) {
                i2++;
            } else if (res == 3) {
                i3++;
            } else if (res == 4) {
                i4++;
            } else if (res == 5) {
                i5++;
            }
            total++;
        }
        System.out.println(i1/total);
        System.out.println(i2/total);
        System.out.println(i3/total);
        System.out.println(i4/total);
        System.out.println(i5/total);
    }

    /**
     * 等概率p = 1/5的概率产生1~5
     * p(1) = 0.2
     * p(2) = 0.2
     * p(3) = 0.2
     * p(4) = 0.2
     * p(5) = 0.2
     *
     * @return
     */
    private int rand1To5() {
        return (int) (Math.random() * 5) + 1;
    }
}
