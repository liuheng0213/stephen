package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._09others;

//分糖果问题
public class _14CandyAllocation {
    public static void main(String[] args) {
        _14CandyAllocation candyDistribution2 = new _14CandyAllocation();
        int[] arr = new int[]{1, 4, 5, 9, 3, 2};//answer  is 49
        int nums = candyDistribution2.candy(arr);
        System.out.println(nums);
    }


    private int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        //初始得 res 不涉及到大小怎样加减得问题
        int index = nextMinIndex(ratings, 0);
        int res = getCandyNums(ratings, 0, index++);

        int upSlopes = 1;//1,2,3,4,5
        int downSlopes = 0;//5,4,3,2,1
        int rightCandyNums = 0;
        //刚入 while 必定是arr[index] < arr[index - 1]
        while (index < ratings.length) {
            if (ratings[index] < ratings[index - 1]) {
                int newIndex = nextMinIndex(ratings, index - 1);
                rightCandyNums = getCandyNums(ratings, index - 1, newIndex++);
                downSlopes = newIndex - index + 1;
                res += rightCandyNums + (upSlopes > downSlopes ? -downSlopes : -upSlopes);
                upSlopes = 1;
                index = newIndex;
            } else if (ratings[index] > ratings[index - 1]) {
                res += ++upSlopes;
                index++;
            } else {
                res++;
                upSlopes = 1;
                index++;
            }
        }
        return res;
    }

    private int nextMinIndex(int[] arr, int start) {
        for (int i = start; i < arr.length - 1; i++) {
            if (arr[i] <= arr[i + 1]) {
                return i;
            }
        }
        return arr.length - 1;
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
