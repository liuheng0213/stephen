package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_05_app;

import basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_01_bubble_select_insert_shell._02SelectionSort;
import basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_02_merge._01MergeSort;
import basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_04_heap._03HeapSort;
import basic.knowledge.stephen.algorithm_4_Edition.mock.MockData;

public class _05E2_5_17 {
    private static class Wrapper<T extends Comparable<T>> implements Comparable<T> {
        private T item;
        private int index;

        public Wrapper(T item, int index) {
            this.item = item;
            this.index = index;
        }


        @Override
        public int compareTo(T that) {
            return this.item.compareTo(that);
        }
    }


    public static void main(String[] args) {
        Double[] doubleForSortMock = MockData.DOUBLE_FOR_SORT_MOCK;
        _01MergeSort.sort(doubleForSortMock);
        boolean stable = checkStability(doubleForSortMock);
        System.out.println(stable);

        doubleForSortMock = MockData.DOUBLE_FOR_SORT_MOCK;
        _02SelectionSort.sort(doubleForSortMock);
        stable = checkStability(doubleForSortMock);
        System.out.println(stable);

        doubleForSortMock = MockData.DOUBLE_FOR_SORT_MOCK;
        _03HeapSort.sort(doubleForSortMock);
        stable = checkStability(doubleForSortMock);
        System.out.println(stable);
    }

    private static boolean checkStability(Double[] doubleForSortMock) {
        Wrapper[] wrappers = new Wrapper[doubleForSortMock.length];
        for (int i = 0; i < wrappers.length; i++) {
            wrappers[i] = new Wrapper(doubleForSortMock[i],i);
        }

        int i = 0;
        while (i < wrappers.length - 1) {
            while (wrappers[i].item.compareTo(wrappers[i + 1].item) == 0) {
                if(wrappers[i].index != wrappers[i + 1].index){
                    return false;
                }
                i++;
            }
            i++;
        }
        return true;

    }
}
