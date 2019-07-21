package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_04_heap;

import basic.knowledge.stephen.algorithm_4_Edition.exception.ListIsEmptyException;
import basic.knowledge.stephen.algorithm_4_Edition.util.SortUtil;

public class _10E2_4_29<Item extends Comparable<Item>> {

    public static void main(String[] args) {
        _10E2_4_29 pq = new _10E2_4_29(3);
        pq.insert(2);
        pq.insert(4);
        pq.insert(12);
        pq.insert(13);
        pq.insert(22);
        pq.insert(-12);
        pq.insert(26);
        pq.insert(7);
        pq.insert(9);
    }


    private boolean small = false;  //big堆顶最大
    private TwoItems[] itemsBigger;
    private TwoItems[] itemsSmaller;
    private int n = 0;

    private class IndexCombin {
        Integer bigIndex;
        Integer smallIndex;
    }

    private class Item{


    }
    private class TwoItems implements Comparable<TwoItems> {
        Item item;
        int index;  //指相关联的另一个元素所在的数组对应的索引

        public TwoItems() {
            item = (Item) new Object();
        }

        @Override
        public int compareTo(TwoItems that) {
            return small == false ? this.item.compareTo(that.item) : that.item.compareTo(this.item);
        }


    }

    public _10E2_4_29(int maxN) {
        itemsBigger =
                
        itemsSmaller = (TwoItems[]) new Object[maxN + 1];
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void insert(Item item) {
        TwoItems twoItems = new TwoItems();
        twoItems.item = item;
        if (n == itemsBigger.length - 1) {
            resizeBigger(2 * n);
        }

        if (n == itemsSmaller.length - 1) {
            resizeSmaller(2 * n);
        }

        itemsBigger[++n] = twoItems;
        itemsSmaller[++n] = twoItems;
        IndexCombin indexCombin = swim(n); //大堆上浮 小堆下沉  t同时进行,但要返回小堆的元素上浮后所在堆的索引

        //create link
        itemsBigger[indexCombin.bigIndex].index = indexCombin.smallIndex;
        itemsSmaller[indexCombin.smallIndex].index = indexCombin.bigIndex;
    }

    //删大堆顶的, 同时把小堆对应的index的删掉
    public Item delMax() {
        if (n == 0) {
            throw new ListIsEmptyException("size 为: " + n);
        }
        if (n == itemsBigger.length / 4) {
            resizeBigger(2 * n);
        }
        TwoItems max = itemsBigger[1];
        SortUtil.exch(itemsBigger, 1, n--);
        itemsBigger[n + 1] = null;
        sink(1, false);


        removeAnother(max.index, true);
        return max.item;
    }


    public Item delMin() {
        if (n == 0) {
            throw new ListIsEmptyException("size 为: " + n);
        }
        if (n == itemsSmaller.length / 4) {
            resizeBigger(2 * n);
        }
        TwoItems max = itemsSmaller[1];
        SortUtil.exch(itemsSmaller, 1, n--);
        itemsSmaller[n + 1] = null;
        sink(1, true);


        removeAnother(max.index, false);
        return max.item;
    }

    private void removeAnother(int index, boolean small) {
        if (small) {
            SortUtil.exch(itemsSmaller, index, itemsSmaller.length - 1);
            itemsSmaller[itemsSmaller.length - 1] = null;
            sink(index, true);
        } else {
            SortUtil.exch(itemsBigger, index, itemsBigger.length - 1);
            itemsBigger[itemsBigger.length - 1] = null;
            sink(index, true);
        }
    }


    private void sink(int k, boolean small) {
        if (small == false) {
            if (n == 2) {
                int j = 2 * k;
                if (SortUtil.less(itemsBigger[k], itemsBigger[j]))
                    SortUtil.exch(itemsBigger, k, j);
            }
            while (k * 2 < n) {
                int j = 2 * k;
                if (j < n && SortUtil.less(itemsBigger[j], itemsBigger[j + 1])) {
                    j++;
                }
                if (SortUtil.less(itemsBigger[k], itemsBigger[j])) {  //k<j
                    SortUtil.exch(itemsBigger, k, j);
                } else { //k >= j
                    break;  // 注意  这个情况要跳出循环, 不能继续下去, 没必要了, 后面百分之百是堆有序的 因为Insert 进都是有序的
                }
                k = j;
            }
        } else {
            if (n == 2) {
                int j = 2 * k;
                if (SortUtil.less(itemsSmaller[k], itemsSmaller[j]))
                    SortUtil.exch(itemsSmaller, k, j);
            }
            while (k * 2 < n) {
                int j = 2 * k;
                if (j < n && SortUtil.less(itemsSmaller[j], itemsSmaller[j + 1])) {
                    j++;
                }
                if (SortUtil.less(itemsSmaller[k], itemsSmaller[j])) {  //k<j
                    SortUtil.exch(itemsSmaller, k, j);
                } else { //k >= j
                    break;  // 注意  这个情况要跳出循环, 不能继续下去, 没必要了, 后面百分之百是堆有序的 因为Insert 进都是有序的
                }
                k = j;
            }
        }
    }

    private IndexCombin swim(int k) {

        //if small = true 返回小堆最后上浮确定最终位置的索引
        int orik = k;
        this.small = false;
        while (k / 2 >= 1) {
            if (SortUtil.less(itemsBigger[k / 2], itemsBigger[k])) {
                SortUtil.exch(itemsBigger, k / 2, k);
            }
            k = k / 2;
        }

        this.small = true;
        while (orik / 2 >= 1) {
            if (SortUtil.less(itemsSmaller[orik / 2], itemsSmaller[orik])) {
                SortUtil.exch(itemsSmaller, orik / 2, orik);
            }
            orik = orik / 2;
        }

        IndexCombin indexCombin = new IndexCombin();
        indexCombin.bigIndex = k;
        indexCombin.smallIndex = orik;
        return indexCombin;

    }

    private void resizeSmaller(int i) {
        TwoItems[] tempItems = (TwoItems[]) new Comparable[n + 1];
        System.arraycopy(itemsSmaller, 0, tempItems, 0, this.n + 1);
        itemsSmaller = tempItems;
    }

    private void resizeBigger(int i) {
        TwoItems[] tempItems = (TwoItems[]) new Comparable[n + 1];
        System.arraycopy(itemsBigger, 0, tempItems, 0, this.n + 1);
        itemsBigger = tempItems;
    }


}

