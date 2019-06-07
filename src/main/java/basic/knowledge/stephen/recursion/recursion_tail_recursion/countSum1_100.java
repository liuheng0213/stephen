package basic.knowledge.stephen.recursion.recursion_tail_recursion;

public class countSum1_100 {
    public static void main(String[] args) {
        int sum = getSum(100);
        System.out.println(sum);
    }

    private static int getSum(int i) {
        if(i==1){
            return 1;
        }else{
            return getSum(i-1)+i;
        }
    }
}
