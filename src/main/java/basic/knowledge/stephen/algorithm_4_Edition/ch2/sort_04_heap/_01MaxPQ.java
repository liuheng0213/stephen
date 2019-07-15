package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_04_heap;

import basic.knowledge.stephen.algorithm_4_Edition.util.SortUtil;

/**
 * 切记不使用items[0]
 *
 * @param <Item>
 */
public class _01MaxPQ<Item extends Comparable<Item>> {
    private Item[] items;
    private int n = 0;


    public _01MaxPQ(int maxN) {
        items = (Item[]) new Comparable[maxN + 1];
    }

    public boolean empty() {
        return this.n == n;
    }

    public int size() {
        return this.n;
    }

    public void insert(Item item) {
        items[++n] = item;
        swim(n);
    }

    public Item delMax() {
        Item max = items[1];
        SortUtil.exch(items, 1, n--);
        items[++n] = null;
        sink(1);
        return max;
    }

    private void sink(int k) {
        while (k * 2 < n) {
            int j = 2 * k;
            if (j < n && SortUtil.less(j, j + 1)) {
                j++;
            }
            if (SortUtil.less(k, j)) {  //k<j
                SortUtil.exch(items, k, j);
            } else { //k >= j
                break;  // 注意  这个情况要跳出循环, 不能继续下去, 没必要了, 后面百分之百是堆有序的 因为Insert 进都是有序的
            }
            k = j;
        }
    }

    private void swim(int k) {
        while (k / 2 >= 1) {
            if (SortUtil.less(items[k / 2], items[k])) {
                SortUtil.exch(items, k / 2, k);
            }
            k = k / 2;
        }
    }
}
