package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_05_app;

import basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_04_heap._01MaxPQ;
import basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_04_heap._01MinPQ;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 买家希望最低价买
 * 卖家希望最高价卖
 */
public class _102_5_22Transaction {
    private _01MinPQ buyer;
    private _01MaxPQ seller;
    private static class Transaction implements Comparable<Transaction>{
        private Integer maxBuyPrice;
        private Integer minSellPrice;
        private Integer num;        //交易笔数

        public Transaction(Integer maxBuyPrice, Integer minSellPrice, Integer num) {
            this.maxBuyPrice = maxBuyPrice;
            this.minSellPrice = minSellPrice;
            this.num = num;
        }

        public Integer getMaxBuyPrice() {
            return maxBuyPrice;
        }

        public void setMaxBuyPrice(Integer maxBuyPrice) {
            this.maxBuyPrice = maxBuyPrice;
        }

        public Integer getMinSellPrice() {
            return minSellPrice;
        }

        public void setMinSellPrice(Integer minSellPrice) {
            this.minSellPrice = minSellPrice;
        }

        public Integer getNum() {
            return num;
        }

        public void setNum(Integer num) {
            this.num = num;
        }

        @Override
        public int compareTo(Transaction o) {
            return 0;
        }
    }

    public _102_5_22Transaction(int n) {
        for(int i = 0 ;i<n;n++){
            buyer.insert(StdRandom.uniform(n));
            seller.insert(StdRandom.uniform(n));
        }
    }

    public static void main(String[] args) {
        Transaction transaction = new Transaction(20, 5, 12);

    }
}
