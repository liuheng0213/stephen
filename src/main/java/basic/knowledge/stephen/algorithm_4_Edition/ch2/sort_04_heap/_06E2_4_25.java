package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_04_heap;

import basic.knowledge.stephen.algorithm_4_Edition.exception.ListIsEmptyException;
import basic.knowledge.stephen.algorithm_4_Edition.util.SortUtil;

public class _06E2_4_25 {

    public static void main(String[] args) {
        _06E2_4_25 pq = new _06E2_4_25(105);
        //System.out.println(pq.size());

        pq.printCubiesEqual();
    }

    private Combination[] items;
    private int n = 0;

    private class Combination implements Comparable<Combination> {
        private Integer soc;  //sum of cubies
        private Integer i;
        private Integer j;


        @Override
        public int compareTo(Combination that) { //倒序, 可以保证最小值在堆顶
            return (that.i * that.i * that.i + that.j * that.j * that.j) - (this.i * this.i * this.i + this.j * this.j * this.j);
        }
    }

    public _06E2_4_25(int N) {
        items = new Combination[N + 2];
        for (int i = 1; i < items.length; i++) {
            Combination combination = new Combination();
            combination.i = i - 1;
            combination.j = 0;
            combination.soc = combination.i * combination.i * combination.i
                    + combination.j * combination.j * combination.j;
            if (combination.soc < 0 || combination.soc > 1000000) {
                System.out.println("n in constructor is  too large and maxN = " + (i - 2));
                break;
            }
            items[i] = combination;
            insert(combination);
        }
    }

    public boolean empty() {
        return this.n == n;
    }

    public int size() {
        return this.n;
    }

    public void printCubiesEqual() {
        int total = 0;
        Combination lastDelMin = delMin();
        while (true) {
            Combination delMin = delMin();

            if (delMin.soc > 1000000) {
                System.out.println("delMin too large, exceeding required max limitation");
                break;
            }
            if (delMin.soc < 0) {
                System.out.println("delMin too large, exceeding the limitation of Integer ");
                break;
            }

            if (lastDelMin.soc.intValue() == delMin.soc.intValue()   // intValue()绝对不能省掉.......
                    && notEqual(lastDelMin.i, lastDelMin.j, delMin.i, delMin.j)) {
                total++;
                System.out.println("lastsoc = " + lastDelMin.soc +
                        " currentSoc = " + delMin.soc +
                        "======>" +
                        " last i = " + lastDelMin.i +
                        " last j = " + lastDelMin.j +
                        " current i = " + delMin.i +
                        " current j = " + delMin.j +
                        " and,  total =" + total);
                continue;

            }
            _06E2_4_25.Combination combination = new _06E2_4_25.Combination();
            combination.i = delMin.i;
            combination.j = delMin.j + 1;
            combination.soc = combination.i * combination.i * combination.i
                    + combination.j * combination.j * combination.j;

            insert(combination);
            lastDelMin = delMin;

        }
    }

    private boolean notEqual(Integer a, Integer b, Integer c, Integer d) {
        if (a == b) {
            return false;
        }
        if (a == c) {
            return false;
        }

        if (a == d) {
            return false;
        }

        if (b == c) {
            return false;
        }

        if (b == d) {
            return false;
        }

        if (c == d) {
            return false;
        }

        return true;
    }


    public void insert(Combination item) {
        if (n == items.length - 1) {
            resize(2 * n);
        }
        items[++n] = item;
        swim(n);
    }

    private void resize(int n) {
        Combination[] tempItems = (Combination[]) new Comparable[n + 1];
        System.arraycopy(items, 0, tempItems, 0, this.n + 1);
        items = tempItems;
    }

    public Combination delMin() {
        if (n == 0) {
            throw new ListIsEmptyException("size 为: " + n);
        }
        if (n == items.length / 4) {
            resize(2 * n);
        }
        Combination min = items[1];
        SortUtil.exch(items, 1, n--);
        items[n + 1] = null;
        sink(1);
        return min;
    }

    public Combination min() {
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
