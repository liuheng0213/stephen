package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._09others;

//分糖果问题
public class _14CandyDistribution {
    public static void main(String[] args) {
        _14CandyDistribution candyDistribution = new _14CandyDistribution();
        int[] arr = new int[]{1, 4, 5, 9, 3, 2};
        int nums = candyDistribution.getRes(arr);
        int nums2 = candyDistribution.getResBook(arr);
        System.out.println(nums2);
    }

    public int getResBook(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int index = nextWinIndex(arr, 0);
        int res = getCandyNums(arr, 0, index++);
        int lbase = 1;
        int next = 0;
        int rcands = 0;
        int rbase = 0;
        while (index != arr.length) {
            if (arr[index] > arr[index - 1]) {
                res += ++lbase;
                index++;
            } else if (arr[index] < arr[index - 1]) {
                next = nextWinIndex(arr, index - 1);
                rcands = getCandyNums(arr, index - 1, next++);
                rbase = next - index + 1;
                res += rcands + (rbase > lbase ? -lbase : rbase);
                lbase = 1;
                index = next;
            } else {
                res += 1;
                lbase = 1;
                index++;
            }
        }
        return res;
    }

    private int nextWinIndex(int[] arr, int start) {
        for (int i = start; i < arr.length - 1; i++) {
            if (arr[i] <= arr[i + 1]) {
                return i;
            }
        }
        return arr.length - 1;
    }


    public int getRes(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int index = nextMaxIndex(arr, 0);
        int rightCandyNums = getCandyNums(arr, 0, index++);
        int upSlopes = 1;//1,2,3,4,5
        int downSlopes = 0;//5,4,3,2,1
        int res = rightCandyNums;

        //刚入 while 必定是arr[index] < arr[index - 1]
        while (index < arr.length) {
            if (arr[index] < arr[index - 1]) {
                index++;
                downSlopes++;
                res += downSlopes;
            } else if (arr[index] > arr[index - 1]) {
                int newIndex = nextMaxIndex(arr, index - 1);
                rightCandyNums = getCandyNums(arr, index - 1, newIndex++);
                downSlopes = newIndex - index + 1;
                res += rightCandyNums + (upSlopes > downSlopes ? -downSlopes : -upSlopes);
                upSlopes = 1;
                index = newIndex;
            } else {
                res++;
                upSlopes = 1;
                index++;
            }
        }
        return res;
    }

    private int getCandyNums(int[] arr, int start, int end) {
        int n = end - start + 1;
        return n + n * (n - 1) / 2;
    }


    private int nextMaxIndex(int[] arr, int start) {
        for (int i = start; i < arr.length - 1; i++) {
            if (arr[i] >= arr[i + 1]) {
                return i;
            }
        }
        return arr.length - 1;
    }
}
