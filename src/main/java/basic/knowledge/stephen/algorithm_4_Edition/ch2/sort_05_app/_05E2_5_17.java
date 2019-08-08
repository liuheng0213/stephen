package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_05_app;

import basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_01_bubble_select_insert_shell._02SelectionSort;
import basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_01_bubble_select_insert_shell._03InsertSort;
import basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_02_merge._01MergeSort;
import basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_03_quick._01QuickSort;
import basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_04_heap._03HeapSort;
import basic.knowledge.stephen.algorithm_4_Edition.mock.MockData;

public class _05E2_5_17 {
    private static class Wrapper<T extends Comparable<T>> implements Comparable<Wrapper> {
        private T item;
        private int index;

        public Wrapper(T item, int index) {
            this.item = item;
            this.index = index;
        }


        @Override
        public int compareTo(Wrapper that) {
            return this.item.compareTo((T) that.item);
        }
    }


    public static void main(String[] args) {
        Double[] doubleForSortMock = MockData.DOUBLE_FOR_SORT_MOCK;
        boolean stable = checkStability(doubleForSortMock, "merge");
        System.out.println(stable);

        doubleForSortMock = MockData.DOUBLE_FOR_SORT_MOCK;
        stable = checkStability(doubleForSortMock, "insert");
        System.out.println(stable);

        doubleForSortMock = MockData.DOUBLE_FOR_SORT_MOCK;
        stable = checkStability(doubleForSortMock, "select");
        System.out.println(stable);

        doubleForSortMock = MockData.DOUBLE_FOR_SORT_MOCK;
        stable = checkStability(doubleForSortMock, "heap");
        System.out.println(stable);

        doubleForSortMock = MockData.DOUBLE_FOR_SORT_MOCK;
        stable = checkStability(doubleForSortMock, "quick");
        System.out.println(stable);
    }

    private static boolean checkStability(Comparable[] doubleForSortMock, String type) {
        Wrapper[] wrappers = new Wrapper[doubleForSortMock.length];
        for (int i = 0; i < wrappers.length; i++) {
            wrappers[i] = new Wrapper(doubleForSortMock[i], i);
        }

        switch (type) {
            case "merge":
                _01MergeSort.sort(wrappers);
                break;
            case "select":
                _02SelectionSort.sort(wrappers);
                break;
            case "heap":
                _03HeapSort.sort(wrappers);
                break;
            case "quick":
                _01QuickSort.sort(wrappers);
                break;
            case "insert":
                _03InsertSort.sort(wrappers);
        }


        int i = 0;
        while (i < wrappers.length - 1) {
            while (i < wrappers.length - 1 && wrappers[i].item.compareTo(wrappers[i + 1].item) == 0) {
                if (wrappers[i].index > wrappers[i + 1].index) {
                    System.out.println(i);
                    return false;
                }
                i++;
            }
            i++;
        }
        return true;

    }
}
