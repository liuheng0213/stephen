package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_04_heap;

import basic.knowledge.stephen.algorithm_4_Edition.exception.ListIsEmptyException;
import basic.knowledge.stephen.algorithm_4_Edition.util.SortUtil;
import edu.princeton.cs.algs4.StdIn;

public class _09E2_4_28TopM {
    public static void main(String[] args) {
        _09E2_4_28TopM topM = new _09E2_4_28TopM(20);
        int m = Integer.valueOf(args[0]);

        while (!StdIn.isEmpty()) {
            int x = StdIn.readInt();
            int y = StdIn.readInt();
            int z = StdIn.readInt();

            Coordinate coordinate = topM.new Coordinate();
            coordinate.x = x;
            coordinate.y = y;
            coordinate.z = z;

            topM.insert(coordinate);
            System.out.println("coordinate completed ,plz start a new one!");
        }

        System.out.println("get out of print.....");

        topM.showMin(m);
    }

    public _09E2_4_28TopM(int maxN) {
        items = new Coordinate[maxN + 1];
    }

    private class Coordinate implements Comparable<Coordinate> {
        Integer x;
        Integer y;
        Integer z;

        @Override
        public int compareTo(Coordinate that) {  //倒序, 可以保证最小值在堆顶
            return (that.x * that.x + that.y * that.y + that.z * that.z)
                    - (this.x * this.x + this.y * this.y + this.z * this.z);
        }

        @Override
        public String toString() {
            return "Coordinate{" +
                    "x=" + x +
                    ", y=" + y +
                    ", z=" + z +
                    '}';
        }
    }


    private Coordinate[] items;
    private int n = 0;

    public boolean empty() {
        return this.n == n;
    }

    public int size() {
        return this.n;
    }

    private void showMin(int m) {
        while (m >= 1) {
            Coordinate coordinate = delMin();
            m--;
            System.out.println(coordinate);
        }
    }

    public void insert(Coordinate item) {
        if (n == items.length - 1) {
            resize(2 * n);
        }
        items[++n] = item;
        swim(n);
    }

    private void resize(int n) {
        Coordinate[] tempItems = new Coordinate[n + 1];
        System.arraycopy(items, 0, tempItems, 0, this.n + 1);
        items = tempItems;
    }

    public Coordinate delMin() {
        if (n == 0) {
            return null;
            //throw new ListIsEmptyException("size 为: " + n);
        }
        if (n == items.length / 4) {
            resize(2 * n);
        }
        Coordinate min = items[1];
        SortUtil.exch(items, 1, n--);
        items[n + 1] = null;
        sink(1);
        return min;
    }

    public Coordinate min() {
        return items[1];
    }

    private void sink(int k) {
        if (n == 2) {
            int j = 2 * k;
            if (SortUtil.less(items[k], items[j]))
                SortUtil.exch(items, k, j);
        }
        while (k * 2 < n) {
            int j = 2 * k;
            if (j < n && SortUtil.less(items[j], items[j + 1])) {
                j++;
            }
            if (SortUtil.less(items[k], items[j])) {  //k<j
                SortUtil.exch(items, k, j);
            } else { //k >= j
                break;  // 注意  这个情况要跳出循环, 不能继续下去, 没必要了, 后面百分之百是堆有序的 因为Insert 进都是有序的
            }
            k = j;
        }
    }

    private void swim(int k) {
        while (k / 2 >= 1 && SortUtil.less(items[k / 2], items[k])) {
            SortUtil.exch(items, k / 2, k);
            k = k / 2;
        }
    }


}


