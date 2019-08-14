package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_05_app;

import basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_03_quick._01QuickSort;
import basic.knowledge.stephen.algorithm_4_Edition.mock.MockData;

import java.util.Arrays;

public class _12E2_5_27 {
    private class Wrapper<T extends Comparable<T>> implements Comparable<Wrapper> {
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
        _12E2_5_27 e2_5_27 = new _12E2_5_27();
        Integer[] indexArr = e2_5_27.getIndexArr(MockData.SHORT_INTEGER);
        System.out.println(Arrays.toString(indexArr));
    }

    //并非真正的排列arr,
    public Integer[] getIndexArr(Comparable[] arr){
        Wrapper[] wrappers = new Wrapper[arr.length];
        for (int i = 0; i < wrappers.length; i++) {
            wrappers[i] = new Wrapper(arr[i], i);
        }

        _01QuickSort.sort(wrappers);
        Integer[] indexArr = new Integer[arr.length];
        for(int i = 0;i<arr.length;i++){
            indexArr[i] = wrappers[i].index;
        }
        return indexArr;
    }
}
