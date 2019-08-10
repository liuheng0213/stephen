package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_05_app;

import basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_01_bubble_select_insert_shell._01BubbleSort;
import basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_01_bubble_select_insert_shell._02SelectionSort;
import basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_01_bubble_select_insert_shell._03InsertSort;
import basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_02_merge._01MergeSort;
import basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_03_quick._01QuickSort;
import basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_04_heap._03HeapSort;
import basic.knowledge.stephen.algorithm_4_Edition.mock.MockData;

/**
 * 强制稳定
 */
public class _06E2_5_18 {
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
        boolean isStable = sortAndStabilize(doubleForSortMock, "quick");

        System.out.println(isStable);
    }

    private static boolean sortAndStabilize(Double[] doubleForSortMock, String sortType) {
        Wrapper[] wrappers = new Wrapper[doubleForSortMock.length];
        for (int i = 0; i < wrappers.length; i++) {
            wrappers[i] = new Wrapper(doubleForSortMock[i], i);
        }

        switch (sortType) {
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
                break;
            case "bubble":
                _01BubbleSort.sort(wrappers);
        }
        int index = 0;
        while (index < wrappers.length - 1) {
            while (index < wrappers.length - 1 && wrappers[index].item.compareTo(wrappers[index + 1].item) == 0) {
                for(int j = index + 1;j >0 && wrappers[j].index < wrappers[j-1].index;j--){
                    if(wrappers[j].item.compareTo(wrappers[j-1].item) != 0){
                        break;
                    }
                    //exchange
                    Wrapper temp = wrappers[j];
                    wrappers[j] = wrappers[j - 1];
                    wrappers[j - 1] = temp;
                }
                index++;
            }
            index++;
        }


      /*

      int i = 0;
        while (i < wrappers.length - 1) {

            int lo = i;
            while (i < wrappers.length - 1 && wrappers[i].item.compareTo(wrappers[i + 1].item) == 0) {

                i++;
            }
            int hi = i;


            if (lo < hi) {
                //排序
                for (int index1 = lo + 1; index1 <= hi; index1++) {
                    for (int index2 = index1; index2 >= lo + 1 && (wrappers[index2].index - wrappers[index2 - 1].index) < 0; index2--) {
                        //exchange
                        Wrapper temp = wrappers[index2];
                        wrappers[index2] = wrappers[index2 - 1];
                        wrappers[index2 - 1] = temp;
                    }
                }
            }
            i++;
        }
*/

        //check
        return check(wrappers);


    }

    private static boolean check(Wrapper[] wrappers) {
        int j = 0;
        while (j < wrappers.length - 1) {
            while (j < wrappers.length - 1 && wrappers[j].item.compareTo(wrappers[j + 1].item) == 0) {
                if (wrappers[j].index > wrappers[j + 1].index) {
                    //System.out.println(i);
                    return false;
                }
                j++;
            }
            j++;
        }
        return true;
    }

}
