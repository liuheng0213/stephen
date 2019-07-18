package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_04_heap;

import basic.knowledge.stephen.algorithm_4_Edition.exception.ListIsEmptyException;
import basic.knowledge.stephen.algorithm_4_Edition.util.SortUtil;

/**
 * 切记不使用items[0]
 *
 * @param <Item>
 */
public class _01MaxPQ<Item extends Comparable<Item>> {

    public static void main(String[] args) {
        _01MaxPQ<Integer> pq = new _01MaxPQ<>(2);
        pq.insert(12);
        pq.insert(4);
        pq.insert(5);
        pq.insert(6);
        pq.insert(1);
        pq.insert(7);
        pq.insert(27);


        System.out.println(pq.delMax());
        System.out.println(pq.delMax());
        System.out.println(pq.delMax());
        System.out.println(pq.delMax());
        System.out.println(pq.delMax());
        System.out.println(pq.delMax());
        System.out.println(pq.delMax());


        System.out.println("size ====>" + pq.size());

    }

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
        if (n == items.length - 1) {
            resize(2 * n);
        }
        items[++n] = item;
        swim(n);
    }

    private void resize(int n) {
        Item[] tempItems = (Item[]) new Comparable[n + 1];
        System.arraycopy(items, 0, tempItems, 0, this.n + 1);
        items = tempItems;
    }

    public Item delMax() {
        if (n == 0) {
            throw new ListIsEmptyException("size 为: " + n);
        }
        if (n == items.length / 4) {
            resize(2 * n);
        }
        Item max = items[1];
        SortUtil.exch(items, 1, n--);
        items[n+1] = null;
        sink(1);
        return max;
    }

    private void sink(int k) {
        if (n == 2) {
            int j = 2 * k;
            if (SortUtil.less(items[k], items[j]))
                SortUtil.exch(items, k, j);
        }
        while (k * 2 < n) {
            int j = 2 * k;
            if (j < n && SortUtil.less(items[j], items[j + 1])) {
                j++;
            }
            if (SortUtil.less(items[k], items[j])) {  //k<j
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
