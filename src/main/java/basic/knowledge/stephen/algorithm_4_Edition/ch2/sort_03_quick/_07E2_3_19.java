
package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_03_quick;

import basic.knowledge.stephen.algorithm_4_Edition.mock.MockData;
import basic.knowledge.stephen.algorithm_4_Edition.util.SortUtil;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 优化:五取样切分
 */
public class _07E2_3_19 {
    public static void main(String[] args) {
        sort(MockData.SHORT_INTEGER);
        SortUtil.isSorted(MockData.SHORT_INTEGER);
//        int t = 0;
//        boolean flag = true;
//        while(flag){
//            try {
//                sort(MockData.INTEGER_FOR_SORT_MOCK);
//                System.out.println("t==>" + (++t));
//                SortUtil.isSorted(MockData.INTEGER_FOR_SORT_MOCK);
//            } catch (Exception e) {
//                flag = false;
//                break;
//            }
//        }
    }

    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
        System.out.println();
    }

    private static void sort(Comparable[] arr, int lo, int hi) {
        if (hi - lo <= 3) {  //这里一定要注意三取样如果子数组是小于3的长度时  会出问题.
            insertSort(arr, lo, hi);
            return;
        }

        int j = partition(arr, lo, hi);

        sort(arr, lo, j - 1);
        sort(arr, j + 1, hi);
    }

    private static int partition(Comparable[] arr, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        //0,1,2,3,4
        if (SortUtil.less(arr[lo + 4], arr[lo + 3])) {  //3<4
            SortUtil.exch(arr, lo + 4, lo + 3);
        }

        if (SortUtil.less(arr[lo + 2], arr[lo + 1])) { //1 <2
            SortUtil.exch(arr, lo + 2, lo + 1);
        }

        if (SortUtil.less(arr[lo + 3], arr[lo + 1])) {
            SortUtil.exch(arr, lo + 3, lo + 1);
            SortUtil.exch(arr, lo + 4, lo + 2);
        }

        //now 1 在1,2,3,4中最小 且 3<4
        //现在还0,1  重新比较1,2并排序
        SortUtil.exch(arr, lo + 1, lo);

        if (SortUtil.less(arr[lo + 2], arr[lo + 1])) {
            SortUtil.exch(arr, lo + 2, lo + 1);
        }

        if (SortUtil.less(arr[lo + 3], arr[lo + 1])) {
            SortUtil.exch(arr, lo + 3, lo + 1);
            SortUtil.exch(arr, lo + 4, lo + 2);
        }

        if (SortUtil.less(arr[lo + 3], arr[lo + 2])) {
            SortUtil.exch(arr, lo + 3, lo + 2);
        }


        //中位数就是2
       /* 取样完毕后，0 1 是最小值和次小值（这里没有对应关系，0 也可以是次小值）。
        3. 4 次序不一定但都比2大。
        我们把 3 和 4放到数组的最后作为哨兵，去掉右边界的判断。*/
        /**
         *  为什么要lo +3,hi 换?
         *  以SHORT_INTEGER 为例  最后的5~10是 8 7 7 13 11 7
         *  如果把lo +3 这个比切分点 给Hi - 1 就是 11 13 7  此时 本质上是  lo +3  和  lo +4 交换  ,
         *  这是不对的  Hi比 中位数小就不行了 , hi比中位数大到无所谓
         *  lo +4 给 hi 就是 11 7 13  那么7 就比中位数小了 这是不对的
         *
         *  所以要先将lo + 3 给hi   8 7 7 7 11 13
         *  lo + 4给 hi - 1
         */
        SortUtil.exch(arr, lo + 2, lo);
        SortUtil.exch(arr, lo + 3, hi);//为什么这里不可以是hi - 1 ,如果非要放hi - 1 sort里的收敛条件必须够大
        SortUtil.exch(arr, lo + 4, hi - 1);


        j -= 2;
        i += 2;
        Comparable v = arr[lo];

        while (true) {
            while (SortUtil.less(arr[++i], v)) ;
            while (SortUtil.less(v, arr[--j])) ;

            if (i >= j) {
                break;
            }

            SortUtil.exch(arr, i, j);
        }

        SortUtil.exch(arr, lo, j);
        return j;
    }

    private static void insertSort(Comparable[] arr, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            for (int j = i; j >= lo + 1; j--) {
                if (SortUtil.less(arr[j], arr[j - 1])) {
                    SortUtil.exch(arr, j, j - 1);
                }
            }
        }
    }
}
