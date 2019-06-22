package basic.knowledge.stephen.algorithm_4_Edition.ch1.bag;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class RandomBag<Item> implements Iterable<Item> {

    private Item[] a = (Item[]) new Object[1];
    private int N = 0;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void add(Item x) {
        if (N == a.length)
            resize(2 * a.length);
        a[N++] = x;
    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public Iterator<Item> iterator() {
        // TODO Auto-generated method stub
        return new RandomBagIterator();
    }

    private class RandomBagIterator implements Iterator<Item> {
        private int[] seq = new int[N];
        private int index = 0;

        public RandomBagIterator() {
            for (int i = 0; i < seq.length; i++)
                seq[i] = i;
            StdRandom.shuffle(seq);
        }

        public boolean hasNext() {
            // TODO Auto-generated method stub
            return index < N;
        }

        public Item next() {
            // TODO Auto-generated method stub
            return a[seq[index++]];
        }

        public void remove() {
            // TODO Auto-generated method stub

        }
    }

    public static void main(String[] args) {
        RandomBag<String> randomBag = new RandomBag<String>();
        randomBag.add("我");
        randomBag.add("的");
        randomBag.add("名字");
        randomBag.add("叫");
        randomBag.add("顶级程序员不穿女装");
        randomBag.add("微博:https://m.weibo.cn/p/1005056186766482");

        for (String string : randomBag) {
            System.out.println(string);
        }
    }
}
