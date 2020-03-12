package basic.knowledge.stephen.algorithm.redEnvelopeAlgrithm;

import java.math.BigDecimal;
import java.util.Random;

public class RedEnvelopeAlgrithm {
    public static void main(String[] args) {
        RedEnvelopeAlgrithm redEnvelopeAlgrithm = new RedEnvelopeAlgrithm();
        RedEnvelope redEnvelope = new RedEnvelope(new BigDecimal(66), 10);

        while (redEnvelope.getRemainSize() > 0) {
            double num = redEnvelopeAlgrithm.getRandomMoney(redEnvelope);
            System.out.println(num);
        }
    }

    /**
     * 二倍均值法
     * 保证每次随机金额的期望都是相等
     * @param redEnvelope
     * @return
     */
    private double getRandomMoney(RedEnvelope redEnvelope) {
        if (redEnvelope.remainSize == 1) {
            redEnvelope.remainSize--;
            return Math.round(redEnvelope.remainMoney.doubleValue() * 100) / 100;
        }

        Random random = new Random();
        double min = 0.01;
        double max = redEnvelope.remainMoney.doubleValue() / redEnvelope.remainSize * 2;
        double money = random.nextDouble() * max; //生成0 ~ max区间的数
        money = money < 0.01 ? min : money;
        money = Math.floor(money * 100) / 100;// floor 向下取整
        redEnvelope.remainSize--;
        redEnvelope.remainMoney = redEnvelope.remainMoney.subtract(new BigDecimal(money));
        return money;
    }


    static class RedEnvelope {
        BigDecimal remainMoney;
        int remainSize;

        public RedEnvelope(BigDecimal remainMoney, int remainSize) {
            this.remainMoney = remainMoney;
            this.remainSize = remainSize;
        }

        public BigDecimal getRemainMoney() {
            return remainMoney;
        }

        public void setRemainMoney(BigDecimal remainMoney) {
            this.remainMoney = remainMoney;
        }

        public int getRemainSize() {
            return remainSize;
        }

        public void setRemainSize(int remainSize) {
            this.remainSize = remainSize;
        }
    }
}
