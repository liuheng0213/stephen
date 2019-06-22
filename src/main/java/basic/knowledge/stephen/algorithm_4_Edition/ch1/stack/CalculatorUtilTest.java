package basic.knowledge.stephen.algorithm_4_Edition.ch1.stack;

//测试时  括号要写全 这个算法需要的
public class CalculatorUtilTest {
    public static void main(String[] args) {
        Double calcResult = CalculatorUtil.getCalcResult("((1+2)*((2 *3) / (3-1)))");
        System.out.println(calcResult);
    }
}
