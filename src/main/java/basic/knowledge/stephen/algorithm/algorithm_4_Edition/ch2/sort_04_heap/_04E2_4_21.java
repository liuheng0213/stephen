package basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch2.sort_04_heap;

/**
 * 用有限队列,实现队列
 * size empty enqueue dequeue
 * 原理: 不能根据item 使堆有序,而应该根据元素插入的顺序给堆排序,
 * 队列是先进先出的, 所以先进的元素要给个大的标记,排在堆父节点
 */
public class _04E2_4_21<Item extends Comparable<Item>> {
    private _01MaxPQ<Mark> pq;
    private int n;
    private int total;

    private class Mark implements Comparable<Mark> {
        Item item;
        int index;

        @Override
        public int compareTo(Mark that) {
            return this.index - that.index ;  //this that 更换就变成栈
        }
    }

    public _04E2_4_21(int n) {
        total = n;
        pq = new _01MaxPQ<>(n);

    }

    public boolean emprty(){
        return n ==0;
    }

    public int size(){
        return this.n;
    }

    public void enqueue(Item item){

        Mark mark = new Mark();
        mark.item = item;
        mark.index = total - n;

        pq.insert(mark);
        n++;
    }

    public Item dequeue(){
        Item item = pq.delMax().item;
        n--;
        return item;
    }

    public static void main(String[] args) {
        _04E2_4_21 queue = new _04E2_4_21(10);
        queue.enqueue(-114);
        queue.enqueue(4);
        queue.enqueue(2);
        queue.enqueue(9);
        queue.enqueue(2);
        queue.enqueue(10);


        System.out.println("result====>"+queue.dequeue());//expected -114
        System.out.println("size====>"+queue.size());//expected 5
    }
}




