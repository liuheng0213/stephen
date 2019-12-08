package basic.knowledge.stephen.algorithm_4_Edition.basicAlgThought.greedy;

public class OilStation {
    public static void main(String[] args) {
        int n = 100;
        int k = 5;
        int[] d = {50, 80, 39, 60, 40, 32};  //80 为0~1之间的举例
        int result = solution(n, k, d);
        System.out.println(result);
    }

    private static int solution(int n, int k, int[] d) {
        int i = 0;
        int s = 0;
        int num = 0;
        while (i <= k) {
            s += d[i];
            if (s >= n) {
                s = d[i];
                num++;
            }
            i++;
        }
        return num;
    }
}
