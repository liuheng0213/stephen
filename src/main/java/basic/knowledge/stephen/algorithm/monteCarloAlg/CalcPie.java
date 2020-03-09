package basic.knowledge.stephen.algorithm.monteCarloAlg;

/**
 * 蒙特卡洛模拟计算圆周率
 */
public class CalcPie {
    public static void main(String[] args) {
        CalcPie calcPie = new CalcPie();
        Double res = calcPie.calcPie();
        System.out.println(res);
    }

    private double calcPie() {
        double inCircle = 0;
        double inSqu = 0;
        for (int i = 0; i <= 1000000000; i++) {
            inSqu++;
            double a = Math.random();
            double b = Math.random();
            if (((a - 0.5) * (a - 0.5) + (b - 0.5) * (b - 0.5)) <= 0.5 * 0.5) {
                inCircle++;
            }
        }

        return ((inCircle / inSqu) * 4);
    }
}
