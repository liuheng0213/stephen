package basic.knowledge.stephen.algorithm_4_Edition.ch1.queue;

import basic.knowledge.stephen.algorithm_4_Edition.exception.ListIsEmptyException;

import java.util.Iterator;

/**
 * 1.3.35   1.3.36
 */
public class RandomQueueByArray1_3_35and1_3_36<Item> implements Iterable<Item> {
    public static void main(String[] args) {
        RandomQueueByArray1_3_35and1_3_36<Integer> integerRandomQueueByArray = new RandomQueueByArray1_3_35and1_3_36<>();
        integerRandomQueueByArray.enqueue(2);
        integerRandomQueueByArray.enqueue(10);
        integerRandomQueueByArray.enqueue(1);
        integerRandomQueueByArray.enqueue(4);
        integerRandomQueueByArray.enqueue(5);
        integerRandomQueueByArray.enqueue(12);
        integerRandomQueueByArray.enqueue(7);
        integerRandomQueueByArray.enqueue(3);
        integerRandomQueueByArray.enqueue(2);
        integerRandomQueueByArray.enqueue(0);
        System.out.println(integerRandomQueueByArray.size());

        System.out.println(integerRandomQueueByArray.dequeue());

        System.out.println(integerRandomQueueByArray.size());

        System.out.println("=====================================");
        Iterator<Integer> iterator = integerRandomQueueByArray.iterator();
        while (iterator.hasNext()){
            Integer current = iterator.next();
            System.out.println(current);
        }
    }

    private int n;  //RandomQueueByArray 的长度
    private Item[] items = (Item[]) new Object[1];

    public RandomQueueByArray1_3_35and1_3_36() {
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
        items[n] = item;
        n++;
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
        return new RandomQueueByArrayIterator<>();
    }

    private class RandomQueueByArrayIterator<Item> implements Iterator {
        private int i = n;
        private Item[] itemsTemp = (Item[]) items;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Object next() {
            int randomIndex = (int) (Math.random() * (i));
            itemsTemp[i--] = itemsTemp[randomIndex];
            return itemsTemp[i];
        }
    }
}
