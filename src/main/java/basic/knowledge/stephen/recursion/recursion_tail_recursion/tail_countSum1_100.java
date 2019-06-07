package basic.knowledge.stephen.recursion.recursion_tail_recursion;

/**
 * 尾递归来计算1加到100
 */
public class tail_countSum1_100 {
    public static void main(String[] args) {
        int i = tail_sum(10, 1);
        System.out.println(i);
    }

    public static int tail_sum(int n,int res){
        if (n==1){
            return res;
        }else{
            return tail_sum(n-1, res) +n;
        }
    }
}
