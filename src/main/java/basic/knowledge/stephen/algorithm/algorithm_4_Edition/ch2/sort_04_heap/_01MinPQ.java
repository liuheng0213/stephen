package basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch2.sort_04_heap;

import basic.knowledge.stephen.algorithm.algorithm_4_Edition.exception.ListIsEmptyException;
import basic.knowledge.stephen.algorithm.algorithm_4_Edition.util.SortUtil;

public class _01MinPQ<Item extends Comparable<Item>> {

    public _01MinPQ() {
        this(1);
    }

    public static void main(String[] args) {
        _01MinPQ<Integer> pq = new _01MinPQ<>(2);
        pq.insert(12);
        pq.insert(4);
        pq.insert(5);
        pq.insert(6);
        pq.insert(1);
        pq.insert(7);
        pq.insert(27);


        System.out.println(pq.delMin());
        System.out.println(pq.delMin());
        System.out.println(pq.delMin());
        System.out.println(pq.delMin());
        System.out.println(pq.delMin());
        System.out.println(pq.delMin());
        System.out.println(pq.delMin());


        System.out.println("size ====>" + pq.size());

    }

    protected Item[] items;
    protected int n = 0;


    public _01MinPQ(int maxN) {
        items = (Item[]) new Comparable[maxN + 1];
    }

    public boolean empty() {
        return this.n == 0;
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

    protected void resize(int n) {
        Item[] tempItems = (Item[]) new Comparable[n + 1];
        System.arraycopy(items, 0, tempItems, 0, this.n + 1);
        items = tempItems;
    }

    public Item min(){
        return items[1];
    }
    public Item delMin() {
        if (n == 0) {
            throw new ListIsEmptyException("size 为: " + n);
        }
        if (n == items.length / 4) {
            resize(2 * n);
        }
        Item max = items[1];
        exch(items, 1, n--);
        items[n + 1] = null;
        sink(1);
        return max;
    }

    protected void sink(int k) {
        if (n == 2) {
            int j = 2 * k;
            if (greater(items[k], items[j]))
                exch(items, k, j);
            return;
        }
        while (k * 2 < n) {
            int j = 2 * k;
            if (j < n && greater(items[j], items[j + 1])) {
                j++;
            }
            if (greater(items[k], items[j])) {  //k<j
                exch(items, k, j);
            } else { //k >= j
                break;  // 注意  这个情况要跳出循环, 不能继续下去, 没必要了, 后面百分之百是堆有序的 因为Insert 进都是有序的
            }
            k = j;
        }
    }

    protected void swim(int k) {
        while (k / 2 >= 1 && greater(items[k / 2], items[k])) {
            exch(items, k / 2, k);
            k = k / 2;
        }
    }



    protected   void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


    protected   boolean greater(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
    }

   
}
