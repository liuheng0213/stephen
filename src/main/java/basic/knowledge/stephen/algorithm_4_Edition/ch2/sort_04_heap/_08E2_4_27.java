package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_04_heap;

import basic.knowledge.stephen.algorithm_4_Edition.exception.ListIsEmptyException;
import basic.knowledge.stephen.algorithm_4_Edition.util.SortUtil;

/**
 * 对_01做出了修改
 * 思路: 为了满足o(1) 空间也是常熟
 * 将min设置为成员变量
 * Insert delMax时注意修改即可
 *
 * @param <Item>
 */
public class _08E2_4_27<Item extends Comparable<Item>> extends _01MaxPQ {

    private Item min;

    public _08E2_4_27(int maxN) {
        super(maxN);
    }

    public static void main(String[] args) {
        _08E2_4_27 pq = new _08E2_4_27(2);
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


        System.out.println(pq.min);

    }

    @Override
    protected void insert(Comparable item) {
        if (n == items.length - 1) {
            resize(2 * n);
        }
        if (n == 0) {
            min = (Item) item;
        }
        if (n == 1 || SortUtil.less(item, min)) {
            min = (Item) item;
        }
        items[++n] = item;
        swim(n);
    }

    @Override
    protected Comparable delMax() {
        if (n == 0) {
            throw new ListIsEmptyException("size 为: " + n);
        }
        if (n == items.length / 4) {
            resize(2 * n);
        }
        Item max = (Item) items[1];
        SortUtil.exch(items, 1, n--);
        items[n + 1] = null;
        if (empty()) {
            min = null;
        }
        sink(1);
        return max;
    }

    public Item min() {
        return this.min;
    }
}
