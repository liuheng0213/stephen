package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_04_heap;

import java.lang.reflect.Array;
import java.util.Arrays;

public class _10E2_4_29TwoDImensionPriorityQueue<Item extends Comparable<Item>> {

    public static void main(String[] args) {
        _10E2_4_29TwoDImensionPriorityQueue pq = new _10E2_4_29TwoDImensionPriorityQueue(2);
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
        System.out.println(pq.delMin());
        System.out.println(pq.delMax());
        System.out.println(pq.delMin());
        System.out.println(pq.delMin());
        System.out.println(pq.delMax());
        System.out.println(pq.delMin());
        System.out.println(pq.delMin());
        System.out.println(pq.delMin());
        System.out.println(pq.delMin());
        System.out.println(pq.delMin());

        System.out.println("======================");
        System.out.println("size : " + pq.size());
    }

    private MinPQ minPQ;
    private MaxPQ maxPQ;
    private int n;

    //最通用的
    public _10E2_4_29TwoDImensionPriorityQueue(int capacity) {
        minPQ = new MinPQ(capacity);
        maxPQ = new MaxPQ(capacity);
        this.n = 0;
    }

    //构造单一元素的堆
    public _10E2_4_29TwoDImensionPriorityQueue() {
        this(1);
    }


    //小顶堆
    private class MinPQ extends _01MinPQ<MinMaxNode> {
        public MinPQ(int maxN) {
            MinMaxNode[] minMaxNodes = (MinMaxNode[]) Array.newInstance(MinMaxNode.class, maxN + 1);
            this.items = minMaxNodes;

        }

        //resize 一定要重写......否则调整数组后 classcastexception
        protected void resize(int n) {
            MinMaxNode[] minMaxNodes = (MinMaxNode[]) Array.newInstance(MinMaxNode.class, n + 1);
            System.arraycopy(items, 0, minMaxNodes, 0, this.n + 1);
            this.items = minMaxNodes;
        }


        //类同单向队列,只交换Item
        //这里交换Item和pair
        public void exch(Object[] a,int i, int j) {
            //交换另一个堆所对应的自身数组对应关系
            this.items[i].pair.pair = items[j];
            this.items[j].pair.pair = items[i];

            MinMaxNode tempNode = this.items[i].pair;
            Item tempItem = this.items[i].item;

            this.items[i].pair = this.items[j].pair;
            this.items[i].item = this.items[j].item;

            this.items[j].pair = tempNode;
            this.items[j].item = tempItem;
        }

        public void remove(int k) {
            if (k == this.n) {
                this.items[n--] = null;
                return;
            } else if (this.n <= 2) {
                exch(null,1, this.n);
                this.items[n--] = null;
                return;
            }

            //other situation
            exch(null,k, this.n--);
            this.items[n + 1] = null;
            swim(k);
            sink(k);
        }
    }

    //大顶堆
    private class MaxPQ extends _01MaxPQ<MinMaxNode> {
        public MaxPQ(int maxN) {
            MinMaxNode[] minMaxNodes = (MinMaxNode[]) Array.newInstance(MinMaxNode.class, maxN + 1);
            this.items = minMaxNodes;
        }
        
        //resize 一定要重写......否则调整数组后 classcastexception
        protected void resize(int n) {
            MinMaxNode[] minMaxNodes = (MinMaxNode[]) Array.newInstance(MinMaxNode.class, n + 1);
            System.arraycopy(items, 0, minMaxNodes, 0, this.n + 1);
            this.items = minMaxNodes;
        }

        //类同单向队列,只交换Item
        //这里交换Item和pair
        //要保证ovverride一定要参数和父类的一致, 虽然没用到a
        public void exch(Object[] a,int i, int j) {
            //交换另一个堆所对应的自身数组对应关系
            this.items[i].pair.pair = items[j];
            this.items[j].pair.pair = items[i];

            MinMaxNode tempNode = this.items[i].pair;
            Item tempItem = this.items[i].item;

            this.items[i].pair = this.items[j].pair;
            this.items[i].item = this.items[j].item;

            this.items[j].pair = tempNode;
            this.items[j].item = tempItem;
        }

        public void remove(int k) {
            if (k == this.n) {
                this.items[n--] = null;
                return;
            } else if (this.n <= 2) {
                exch(null,1, this.n);
                this.items[n--] = null;
                return;
            }

            //other situation
            exch(null,k, this.n--);
            this.items[n + 1] = null;
            swim(k);
            sink(k);
        }
    }

    private class MinMaxNode implements Comparable<MinMaxNode> {
        private MinMaxNode pair;
        private Item item;
        private int index; //数组中的索引

        public MinMaxNode() {
        }

        public MinMaxNode(Item item, int index) {
            this.item = item;
            this.index = index;
        }

        @Override
        public int compareTo(MinMaxNode that) {
            return this.item.compareTo(that.item);
        }

    }

    public int size() {
        return this.n;
    }

    public Item delMax() {
        this.minPQ.remove(this.maxPQ.max().pair.index);//必须先删除对应的再删自己
        Item max = this.maxPQ.max().item;
        this.maxPQ.delMax();
        this.n--;
        return max;
    }

    public Item delMin() {
        this.maxPQ.remove(this.minPQ.min().pair.index);
        Item min = this.minPQ.min().item;
        this.minPQ.delMin();
        this.n--;
        return min;
    }

    public void insert(Item item) {
        // create link
        MinMaxNode minNode = new MinMaxNode(item, ++this.n);
        MinMaxNode maxNode = new MinMaxNode(item, n);

        minNode.pair = maxNode;
        maxNode.pair = minNode;

        this.minPQ.insert(minNode);
        this.maxPQ.insert(maxNode);
    }

    public Item min(){
        return this.minPQ.min().item;
    }

    public Item max(){
        return this.maxPQ.max().item;
    }

}