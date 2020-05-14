package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._09others;

//分糖果问题
public class _14CandyDistribution {
    public static void main(String[] args) {
        _14CandyDistribution candyDistribution2 = new _14CandyDistribution();
        int[] arr = new int[]{9, 5, 4, 1, 6, 7, 8, 6, 5, 4, 3, 2, 1, 4, 12, 5};//answer  is 49
        int[] arr1 = new int[]{1, 5, 7, 9, 9, 6, 3, 4, 8, 10};
        int[] arr2 = new int[]{1, 2, 2};
        int[] arr3 = new int[]{1, 3, 2, 2, 1};//answer 7
        int[] arr4 = new int[]{1, 0, 2};//answer 7
        int nums2 = candyDistribution2.candy(arr4);
        System.out.println(nums2);
    }


    private int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        //初始得 res 不涉及到大小怎样加减得问题
        int index = nextMinIndex(ratings,0);
        int res = getCandyNums(ratings,0,index++);

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
