package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_03_quick;

import basic.knowledge.stephen.algorithm_4_Edition.mock.MockData;
import basic.knowledge.stephen.algorithm_4_Edition.util.SortUtil;

import java.util.Stack;

/**
 * 菲递归的快速排序
 * 将子数组的首尾下标, 依次从大子数组,...到小子数组,存入栈中,需要的时候从小数组,到大数组依次弹出来
 * 其实本质上和递归差不多
 */
public class _08E2_3_20 {
    public static void main(String[] args) {
        sort(MockData.DOUBLE_FOR_SORT_MOCK);
        SortUtil.isSorted(MockData.DOUBLE_FOR_SORT_MOCK);
    }

    private static void sort(Comparable[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(arr.length -1);

        while(!stack.empty()){
            Integer hi = stack.pop();
            Integer lo = stack.pop();

            if(lo >= hi){
                continue;
            }

            int j = partition(arr,lo,hi);

            if(hi- j >= j-lo){
                stack.push(j+1);
                stack.push(hi);

                stack.push(lo);
                stack.push(j-1);
            }else{
                stack.push(j+1);
                stack.push(hi);

                stack.push(lo);
                stack.push(j-1);

            }
        }
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        Comparable v = a[lo];
        int i = lo;
        int j = hi + 1;

        while (true) {
            while (SortUtil.less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }


            while (SortUtil.less(v, a[--j])) {
//                if (j == lo) {    //去掉边界检查无论如何  a[lo] 不可能大于v  永远进不了while
//                    break;
//                }
            }

            if (i >= j) {
                break;
            }

            SortUtil.exch(a, i, j);
        }

        SortUtil.exch(a, lo, j);
        return j;
    }
}
