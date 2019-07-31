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

    public static void main(String[] args) {
        _132_4_33IndexMinPQ pq = new _132_4_33IndexMinPQ(25);
        pq.insert(1,-111);//
        pq.insert(2,-51);//
        pq.insert(3,2);
        pq.insert(4,7);//
        pq.insert(9,17);
        pq.insert(8,-19);
        pq.insert(15,21);
        pq.insert(23,31);
        pq.insert(22,8);
        pq.insert(1,-31);
        pq.insert(24,1);
        pq.insert(11,6);//
        pq.insert(17,70);
        pq.insert(2,-45);
        pq.insert(4,16);
        pq.insert(11,180);
        pq.insert(10,-16);
        pq.insert(7,19);


        pq.delete(10);
        pq.delete(11);
        pq.delete(15);

        System.out.println(pq.delMin());
        System.out.println(pq.delMin());
        System.out.println(pq.delMin());
        System.out.println(pq.delMin());
        System.out.println(pq.delMin());
        System.out.println(pq.delMin());
        System.out.println(pq.delMin());
        System.out.println(pq.delMin());
        System.out.println(pq.delMin());
        System.out.println(pq.delMin());
        System.out.println(pq.delMin());
        System.out.println("size ()== " + pq.size());
    }
    private Integer[] pq;
    private Integer[] qp;
    private Item[] items;
    private Integer n;


    public _132_4_33IndexMinPQ(Integer n) {
        this.pq = new Integer[n + 1];
        this.qp = new Integer[n + 1];
        this.items = (Item[]) new Comparable[n + 1];
        this.n = 0;
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
        Integer index = qp[k];
        swim(index);
        sink(index);
    }

    public void delete(int k){
        int index = qp[k];
        exch(index,n--);
        swim(index);
        sink(index);

        items[pq[n+1]] = null;
        qp[pq[n+1]] = -1;
        pq[n+1] = null;


    }

    private void sink(int i) {
        if (n == 2) {
            int j = 2 * i;
            if (greater(i, j))
                exch( i, j);
            return;
        }
        while (i * 2 < n) {
            int j = 2 * i;
            if (j < n && greater(j, j + 1)) {
                j++;
            }
            if (greater(i, j)) {  //k<j
                exch(i, j);
            } else { //k >= j
                break;  // 注意  这个情况要跳出循环, 不能继续下去, 没必要了, 后面百分之百是堆有序的 因为Insert 进都是有序的
            }
            i = j;
        }
    }

    public void insert(int k, Item item) {
        if(qp[k] != -1){
            change(k,item);
            return;
        }


        pq[++n] = k;
        qp[k] = n;
        items[k] = item;
        swim(n);//注意: 上浮不再是上浮item而是上浮item的索引 如2 ,4, 9,基于Pq[]
    }

    private void swim(Integer n) {
        while (n / 2 >= 1 && greater(n / 2, n)) {
            exch(n / 2, n);
            n = n / 2;
        }
    }


    public void exch(int i, int j) {
        Integer temp  = qp[pq[i]];
        qp[pq[i]] = qp[pq[j]];
        qp[pq[j]] = temp;

        Integer swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }


    public boolean greater(Integer v, Integer w) {
        if(pq[v] == null){
            System.out.println("v:" + v );
        }

        if(pq[w] == null){
            System.out.println("w:" + w );
        }
        return items[pq[v]].compareTo(items[pq[w]]) > 0;
    }


}
