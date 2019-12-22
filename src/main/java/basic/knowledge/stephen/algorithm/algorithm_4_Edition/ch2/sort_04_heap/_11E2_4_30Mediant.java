package basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch2.sort_04_heap;

import basic.knowledge.stephen.algorithm.algorithm_4_Edition.exception.ListIsEmptyException;
import basic.knowledge.stephen.algorithm.algorithm_4_Edition.util.SortUtil;

public class _11E2_4_30Mediant<Item extends Comparable<Item>> {
    public static void main(String[] args) {
        _11E2_4_30Mediant pq = new _11E2_4_30Mediant(2);
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

        System.out.println(pq.delMediant());
        System.out.println(pq.delMediant());
        System.out.println(pq.delMediant());
        System.out.println(pq.delMediant());
        System.out.println(pq.delMediant());
        System.out.println(pq.delMediant());
        System.out.println(pq.delMediant());
        System.out.println(pq.delMediant());
        System.out.println(pq.delMediant());
        System.out.println(pq.delMediant());
        System.out.println(pq.delMediant());


        System.out.println("======================");
        System.out.println("size : " + pq.size());
    }
    private Item mediant;
    private MinPQ minPQ;
    private MaxPQ maxPQ;
    private int n;

    //最通用的
    public _11E2_4_30Mediant(int capacity) {
        minPQ = new MinPQ(capacity);
        maxPQ = new MaxPQ(capacity);
        this.n = 0;
    }

    public int size(){
        return this.n;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    private class MinPQ extends _01MinPQ<Item> {

        public MinPQ(int maxN) {
            super(maxN);
        }

        public MinPQ() {
        }
    }

    private class MaxPQ extends _01MaxPQ<Item> {

        public MaxPQ(int maxN) {
            super(maxN);
        }

        public MaxPQ() {
        }
    }

    public Item getMediant() {
        return this.mediant;
    }

    public void insert(Item item) {
        if(this.n == 0){
            this.mediant = item;
        }else{
            //最终状态, 只有两种:
            //1 max.n == min.n - 1
            //2 max.n == min.n
            if (this.maxPQ.n == this.minPQ.n - 1){
                if(SortUtil.equals(item, this.mediant)){
                    this.maxPQ.insert(item);
                }else if(SortUtil.less(item, this.mediant)){
                    this.maxPQ.insert(item);
                }else{
                    this.minPQ.insert(item);
                    this.maxPQ.insert(this.mediant);
                    this.mediant = this.minPQ.delMin();
                }
            }else {
                if(SortUtil.equals(item, this.mediant)){
                    this.minPQ.insert(item);
                }else if(SortUtil.less(item, this.mediant)){
                    this.maxPQ.insert(item);
                    this.minPQ.insert(this.mediant);
                    this.mediant = this.maxPQ.delMax();
                }else{
                    this.minPQ.insert(item);
                }
            }
        }
        n++;
    }

    public Item delMediant() {
        if (isEmpty()) {
            throw new ListIsEmptyException("MedianPQ underflow!");
        }

        Item item = this.mediant;
        if(this.n == 1){
            n--;
        }else{
            if (this.maxPQ.n == this.minPQ.n - 1){
                this.mediant =  this.minPQ.delMin();
            }else {
                this.mediant = this.maxPQ.delMax();
            }
            n--;
        }
        return item;
    }
}
