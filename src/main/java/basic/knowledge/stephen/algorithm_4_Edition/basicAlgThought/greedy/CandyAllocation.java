package basic.knowledge.stephen.algorithm_4_Edition.basicAlgThought.greedy;

import java.util.Arrays;

/**
 * 某个糖果如果不能满足某个孩子，则该糖果也一定不能满足需求因子更大的孩子

 某个孩子可以用更小的糖果满足，则没必要用更大糖果满足，因为可以保留更大的糖果满足需求因子更大的孩子
 孩子的需求因子更小则其更容易被满足，故优先从需求因子小的孩子尝试，
 可以得到正确的结果(因为我们追求更多的孩子被满足，所以用一个糖果满足需求因子较小或较大的孩子都是一样的)。
 算法设计：

 (1)对需求因子数组g和糖果大小数组s进行从小到大的排序
 (2)按照从小到大的顺序使用各糖果尝试是否可满足某个孩子，每个糖果只尝试1次，只有尝试成功时，换下一个孩子尝试，直到发现没更多的孩子或者没有更多的糖果，循环结束。
    求最多可分几个孩子
 */
public class CandyAllocation {
    public static void main(String[] args) {
        int[] g = {5,10,2,9,15,9};
        int[] s = {6,1,20,3,8};

        Arrays.sort(g);
        Arrays.sort(s);

        int child = 0;
        int candy = 0;

        while(child != g.length && candy != s.length){
            if(g[child] <= s[candy]){
                child++;
            }
            candy++;
        }
        System.out.println(candy);
    }
}
