package basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch1.queue;

import basic.knowledge.stephen.algorithm.algorithm_4_Edition.exception.ListIsEmptyException;

import java.util.Iterator;

/**
 * 练习1.3.38
 */
public class GeneralizedQueueByArray1_3_38<Item> implements Iterable<Item>{
    private int n = 0;  //RandomQueueByArray 的长度
    private Item[] items = (Item[]) new Object[1];

    public GeneralizedQueueByArray1_3_38() {
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void enqueue(Item item) {
        if (items.length == n) {
            //enlarge
            resize(2 * items.length);

        }
        items[n++] = item;
    }

    private void resize(int length) {
        Item[] tempItems = (Item[]) new Object[length];
        System.arraycopy(items, 0, tempItems, 0, items.length);
        items = tempItems;
    }

    public Item dequeue() {
        if (n == 0) {
            throw new ListIsEmptyException("size 为: " + n);
        }
        if (items.length == n / 4) {
            resize(items.length / 2);
        }
        //求出0~ n-1(不含) 之间的随机数
        int random = (int) (Math.random() * (n - 1));
        ///和末位 n-1 交换

        Item temp = items[random];
        items[random] = items[n - 1];
        items[n - 1] = temp;


        //删除并返回末尾元素
        Item item = items[n - 1];
        items[n - 1] = null;
        n--;
        return item;
    }


    @Override
    public Iterator<Item> iterator() {
        return new GeneralizedQueueByArrayIterator<>();
    }

    private class GeneralizedQueueByArrayIterator<Item> implements Iterator {
        private int i = 0;
        private Item[] itemsTemp = (Item[]) items;

        @Override
        public boolean hasNext() {
            return i < n;
        }

        @Override
        public Object next() {
           return items[i++];
        }
    }

    /**
     * 1.3.38
     * @param k
     * @return
     * 删除返回最早插入的元素K
     */
    public Item delete(Item k){
        // 正确套路
        for(int i = 0;i <= this.n -1;i++){
            if(items[i] == k){
                Item[] newItems = (Item[]) new Object[this.n-1];
                System.arraycopy(items, 0, newItems, 0, i);
                System.arraycopy(items, i+1, newItems, i, this.n-i-1);
                this.items = newItems;
                n--;
                return k;
            }
        }

        return null;
    }

}
