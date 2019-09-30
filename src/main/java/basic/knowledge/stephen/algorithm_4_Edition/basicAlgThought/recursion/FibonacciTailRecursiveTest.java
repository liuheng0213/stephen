package basic.knowledge.stephen.algorithm_4_Edition.basicAlgThought.recursion;

public class FibonacciTailRecursiveTest {
    public static void main(String[] args) {
        int result = fibonacciTailRecursive(5,0,1);
        System.out.println(result);
    }

    //思路:
    //刚进入时才有ret1, ret2的参数顺序
    //接下来 ret1 +ret2相当于f(n) + f(n+1)
    // 进入后赋值为f(n+1) 给参数一  f(n) + f(n+1)给参数2
    // 所以n == 0时  是f(n)  n最大时的值了  就是result
    //参数一 才是真正需要的值
    private static int fibonacciTailRecursive(int n, int ret1, int ret2) {

        if (n == 0)
            return ret1;

        return fibonacciTailRecursive(n - 1, ret2, ret1 + ret2);
    }




}
