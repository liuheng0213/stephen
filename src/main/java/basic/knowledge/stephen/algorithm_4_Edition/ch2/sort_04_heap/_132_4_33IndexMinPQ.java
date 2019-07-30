package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_04_heap;

/**
 * pq[1] = 2
 * pq[2] = 4
 * pq[3] = 9
 * <p>
 * qp[2] = 1
 * qp[4] = 2
 * qp[9] = 3
 * <p>
 * 2, 4, 9 是Items的索引
 * 1 ,2,3 是2, 4, 9的索引
 *
 * @param <Item>
 */
public class _132_4_33IndexMinPQ<Item extends Comparable<Item>> {
    private Integer[] pq;
    private Integer[] qp;
    private Item[] items;
    private Integer n;


    public _132_4_33IndexMinPQ(Integer n) {
        this.pq = new Integer[n + 1];
        this.qp = new Integer[n + 1];
        this.items = (Item[]) new Comparable[n + 1];
        this.n = n;
        for (int i = 0; i <= n; i++) {
            qp[i] = -1;
        }
    }

    public boolean isEmpty() {
        return this.n == 0;
    }

    public int size() {
        return this.n;
    }

    public boolean contains(int k) {
        return qp[k] != -1;
    }

    public Item min(){
        return items[pq[1]];
    }

    public Integer delMin(){
        int indexOfMinItem = pq[1];
        exch(1, n--);
        sink(1);

        items[pq[n+1]] = null;
        qp[pq[n+1]] = -1;
        pq[n+1] = null;
        return indexOfMinItem;
    }

    public int minIndex(){
        return pq[1];
    }

    public void change(int k, Item item){
        items[k] = item;
        swim(qp[k]);
        sink(qp[k]);
    }

    public void delete(int k){

    }

    private void sink(int i) {
        if (n == 2) {
            int j = 2 * i;
            if (greater(pq[i], pq[j]))
                exch( i, j);
            return;
        }
        while (i * 2 < n) {
            int j = 2 * i;
            if (j < n && greater(pq[j], pq[j + 1])) {
                j++;
            }
            if (greater(pq[i], pq[j])) {  //k<j
                exch(i, j);
            } else { //k >= j
                break;  // 注意  这个情况要跳出循环, 不能继续下去, 没必要了, 后面百分之百是堆有序的 因为Insert 进都是有序的
            }
            i = j;
        }
    }

    public void insert(int k, Item item) {
        pq[++n] = k;
        qp[k] = n;
        items[k] = item;
        swim(n);//注意: 上浮不再是上浮item而是上浮item的索引 如2 ,4, 9,基于Pq[]
    }

    private void swim(Integer n) {
        while (n / 2 >= 1 && greater(pq[n / 2], pq[n])) {
            exch(n / 2, n);
            n = n / 2;
        }
    }


    public void exch(int i, int j) {
        Integer temp  = pq[qp[i]];
        pq[qp[i]] = pq[qp[j]];
        pq[qp[j]] = temp;

        Integer swap = qp[i];
        qp[i] = qp[j];
        qp[j] = swap;
    }


    public boolean greater(Integer v, Integer w) {
        return items[v].compareTo(items[w]) > 0;
    }


}
