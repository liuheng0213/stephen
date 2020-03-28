package basic.knowledge.stephen.algorithm;

public class IsPrime {
    public static void main(String[] args) {
        boolean isPrime = isPrime(997);
        System.out.println(isPrime);
    }

    /**
     * 其实质数还有一个特点，就是它总是等于 6x-1 或者 6x+1，其中 x 是大于等于1的自然数。
     * 如何论证这个结论呢，其实不难。首先 6x 肯定不是质数，
     * 因为它能被 6 整除；其次 6x+2 肯定也不是质数，因为它还能被2整除；
     * 依次类推，6x+3 肯定能被 3 整除；6x+4 肯定能被 2 整除。
     * 那么，就只有 6x+1 和 6x+5 (即等同于6x-1) 可能是质数了。
     * 所以循环的步长可以设为 6，然后每次只判断 6 两侧的数即可。
     * @param n
     * @return
     */
    private static boolean isPrime(int n) {
        if (n <= 3) {
            return n > 1;
        }

        if (n % 6 != 5 && n % 6 != 1) {
            return false;
        }

        /**
         * 如果num能走到for循环这,那么这个数肯定是在6的两侧(n % 6 == 5 || n % 6 == 1),
         * 也肯定这个数不是2,3的倍数,
         * 那么这个数只剩下这么两种可能:可以被分解成
         * (6x-1)(6y-1),(6x-1)(6y+1),(6x+1)(6y-1),(6x+1)(6y+1)这四种式子,
         * 不能被分解(那就是质数).这也就解释了这个for循环体为什么要这么写.
         */
        int sqrt = (int) Math.sqrt(n);
        for (int i = 5; i <= sqrt; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;

    }
}
