package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_04_heap;

import basic.knowledge.stephen.algorithm_4_Edition.util.SortUtil;

/**
 * 学习这个思路
 *
 * @param <Item>
 */
public class _07E2_4_26<Item extends Comparable<Item>> extends _01MaxPQ {
    public _07E2_4_26(int maxN) {
        super(maxN);
    }

    public static void main(String[] args) {
        _07E2_4_26 pq = new _07E2_4_26(2);
        pq.insert(11);
        pq.insert(-51);
        pq.insert(2);
        pq.insert(7);
        pq.insert(17);
        pq.insert(-19);
        pq.insert(21);
        pq.insert(31);
        pq.insert(8);
        pq.insert(-31);
        pq.insert(1);

        System.out.println("size : " + pq.size());
        System.out.println("======================");

        System.out.println(pq.delMax());
        System.out.println(pq.delMax());
        System.out.println(pq.delMax());
        System.out.println(pq.delMax());
        System.out.println(pq.delMax());
        System.out.println(pq.delMax());
        System.out.println(pq.delMax());
        System.out.println(pq.delMax());
        System.out.println(pq.delMax());
        System.out.println(pq.delMax());
        System.out.println(pq.delMax());

        System.out.println("======================");
        System.out.println("size : " + pq.size());
    }

    @Override
    public void sink(int k) {
        if (n == 2) {
            int j = 2 * k;
            if (SortUtil.less(items[k], items[j])) {
                Comparable temp = items[k];
                items[k] = items[j];
                items[j] = temp;
            }
        }

        Comparable item = this.items[k];
        while (k * 2 < n) {
            int j = 2 * k;
            if (j < n && SortUtil.less(items[j], items[j + 1])) {
                j++;
            }
            if (SortUtil.less(item, items[j])) {  //k<j
                this.items[k] = this.items[j];//exchange first
            } else { //k >= j
                break;  // 注意  这个情况要跳出循环, 不能继续下去, 没必要了, 后面百分之百是堆有序的 因为Insert 进都是有序的
            }
            k = j;
        }
        this.items[k] = item;// exchange twice
    }

    //这个与sink不一样  这个一定遍历要到顶
    @Override
    public void swim(int k) {
        Comparable item = this.items[k];//initial
        while (k / 2 >= 1 && SortUtil.less(items[k/2], item)) {
            this.items[k] = this.items[k/2];// first exchange
            this.items[k/2] = item;
            k = k/2;
        }
    }
}
