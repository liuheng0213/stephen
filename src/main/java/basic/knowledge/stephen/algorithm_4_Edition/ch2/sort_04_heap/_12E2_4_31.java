package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_04_heap;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Swim方法改成二分查找
 */
public class _12E2_4_31<Item> extends _01MinPQ {
    public _12E2_4_31(int maxN) {
        super(maxN);
    }

    public static void main(String[] args) {
        _12E2_4_31 pq = new _12E2_4_31(2);
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
        pq.insert(6);
        pq.insert(70);
        pq.insert(-45);
        pq.insert(16);
        pq.insert(19);

        System.out.println("size : " + pq.size());

    }

    protected void swim(int k) {
        if (k == 1) {
            return;
        }
        if (k == 2 && greater(items[k - 1], items[k])) {
            exch(items, k - 1, k);
            return;
        }

        //形成路径  path存储的是items的索引
        ArrayList<Integer> path = new ArrayList<>();
        int temp = k;
        while (temp >= 1) {
            path.add(temp);
            temp = temp / 2;
        }

        //Collections.reverse(path);

        int lo = 1;
        int hi = path.size() - 1;
        int mid = (lo + hi) / 2;
        while (lo <= hi) {
            if (greater(items[path.get(mid)], items[k])) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
            mid = (lo + hi) / 2;
        }

        for (int i = 1; i < lo; i++) {
            exch(items,path.get(i - 1),path.get(i));
        }
    }
}
