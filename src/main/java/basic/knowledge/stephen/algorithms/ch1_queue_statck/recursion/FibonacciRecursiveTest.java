package basic.knowledge.stephen.algorithms.ch1_queue_statck.recursion;

public class FibonacciRecursiveTest {
    public static void main(String[] args) {
        int result = fibonacciRecursive(5);
        System.out.println(result);
    }

    private static int fibonacciRecursive(int n) {
        if (n < 2)
            return n;
        return (fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2));
    }
}
