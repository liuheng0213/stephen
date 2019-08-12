package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_05_app;

import basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_04_heap._01MaxPQ;
import basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_04_heap._01MinPQ;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 站在投资人的角度,解决这个问题:
 * <p>
 * 优先促使的交易匹配: 高价买, 低价卖-----房产中介就是这么完的
 */
public class _102_5_22Transaction {
    public static final double maxPrice = 2000;
    public static final double minPrice = 100;

    private static class Transaction implements Comparable<Transaction> {
        private Double price;
        private Integer num;        //交易笔数

        @Override
        public int compareTo(Transaction that) {
            return this.price.compareTo(that.price);
        }
    }

    public static void main(String[] args) {
        _01MaxPQ<Transaction> buyer = new _01MaxPQ();
        _01MinPQ<Transaction> seller = new _01MinPQ();
        int n = Integer.parseInt(args[0]);

        for (int i = 0; i < n; i++) {
            Transaction transaction = new Transaction();
            String[] split = StdIn.readLine().split(" ");

            transaction.price = Double.valueOf(split[1]);
            transaction.num = Integer.valueOf(split[2]);
            if (split[0].equals("buy")) {
                buyer.insert(transaction);
            } else {
                seller.insert(transaction);
            }
        }

        while (!buyer.empty() && !seller.empty() ) {
            if (buyer.max().num < seller.min().num) {
                break;
            }

            if(buyer.max().price > maxPrice || seller.min().price < minPrice){
                break;
            }

            Transaction buy = buyer.delMax();
            Transaction sell = seller.delMin();
            //卖价
            System.out.print("sell $" + sell.price + "*" + sell.num);

            if (buy.num > sell.num) {
                System.out.println(" -> " + sell.num + " -> $" + buy.price + " * " + buy.num + " buy");
                buy.num -= sell.num;
                buyer.insert(buy);
            } else if (buy.num < sell.num) {
                sell.num -= buy.num;
                seller.insert(sell);
                System.out.println(" -> " + buy.num + " -> $" + buy.price + " * " + buy.num + " buy");
            } else {
                System.out.println(" -> " + sell.num + " -> $" + buy.price + " * " + buy.num + " buy");
            }
        }

    }


}
