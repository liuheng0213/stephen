package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_05_app;

import basic.knowledge.stephen.algorithm_4_Edition.exception.ListIsEmptyException;

public class _11E2_5_24StableMinPQ<Item extends Comparable<Item>> {

    public _11E2_5_24StableMinPQ() {
        this(1);
    }

    public static void main(String[] args) {
        _11E2_5_24StableMinPQ<Integer> pq = new _11E2_5_24StableMinPQ<>(2);
        pq.insert(12);
        pq.insert(4);
        pq.insert(5);
        pq.insert(6);
        pq.insert(1);
        pq.insert(7);
        pq.insert(27);
        pq.insert(-45);

        System.out.println(pq.delMin());
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
    protected Integer[] sequence;
    protected Integer count;


    public _11E2_5_24StableMinPQ(int maxN) {
        items = (Item[]) new Comparable[maxN + 1];
        sequence = new Integer[maxN + 1];
        count = 0;
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
        sequence[n] = ++count;
        swim(n);
    }

    protected void resize(int n) {
        Item[] tempItems = (Item[]) new Comparable[n + 1];
        Integer[] tempSequence = new Integer[n + 1];
        System.arraycopy(items, 0, tempItems, 0, this.n + 1);
        System.arraycopy(sequence, 0, tempSequence, 0, this.n + 1);
        items = tempItems;
        sequence = tempSequence;
    }

    public Item min() {
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
        exch(1, n--);
        items[n + 1] = null;
        sequence[n + 1] = null;
        sink(1);
        return max;
    }

    protected void sink(int k) {
        if (n == 2) {
            int j = 2 * k;
            if (greaterOrEqual(k, j))
                exch(k, j);
            return;
        }
        while (k * 2 < n) {
            int j = 2 * k;
            if (j < n && greaterOrEqual(j, j + 1)) {
                j++;
            }
            if (greaterOrEqual(k, j)) {  //k<j
                exch(k, j);
            } else { //k >= j
                break;  // 注意  这个情况要跳出循环, 不能继续下去, 没必要了, 后面百分之百是堆有序的 因为Insert 进都是有序的
            }
            k = j;
        }
    }

    protected void swim(int k) {
        while (k / 2 >= 1 && greaterOrEqual(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }


    protected void exch(int i, int j) {
        Item swap = this.items[i];
        this.items[i] = this.items[j];
        this.items[j] = swap;

        Integer temp = sequence[i];
        sequence[i] = sequence[j];
        sequence[j] = temp;
    }


    protected boolean greaterOrEqual(int v, int w) {
        int cmp = items[v].compareTo(items[w]);
        if(cmp == 0){
            return sequence[v].compareTo(sequence[w]) >0;
        }
        return items[v].compareTo(items[w]) > 0 ;
    }


}