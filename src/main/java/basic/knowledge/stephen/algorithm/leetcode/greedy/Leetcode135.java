package basic.knowledge.stephen.algorithm.leetcode.greedy;

/**
 * 糖果分配
 */
public class Leetcode135 {
    public static void main(String[] args) {
        Leetcode135 leetcode135 = new Leetcode135();
        int[] arr1 = new int[]{1, 5, 7, 9, 9, 6, 3, 4, 8, 10};
        int res = leetcode135.candy(arr1);
        //摇摆序列做一次 参考SwingSequence.java
        System.out.println(res);
    }

    private int candy(int[] ratings) {
        int index = lastDownDirIndex(ratings, 0);
        int res = getDownCandyes(ratings, 0, index++);
        int downSlopes = 0;
        int upSlopes = 1;
        int downCandys = 0;
        while (index < ratings.length) {
            if (ratings[index] > ratings[index - 1]) {
                res += ++upSlopes;
                index++;
            } else if (ratings[index] < ratings[index - 1]) {
                int newIndex = lastDownDirIndex(ratings, index - 1);
                downCandys = getDownCandyes(ratings, index - 1, newIndex++);
                downSlopes = newIndex - index + 1;
                res += downCandys + (downSlopes > upSlopes ? -upSlopes : -downSlopes);
                upSlopes = 1;
                index = newIndex;
            } else {
                res++;
                index++;
                upSlopes = 1;
            }
        }
        return res;
    }


    public int candy_right(int[] ratings) {
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

    private int getDownCandyes(int[] ratings, int start, int end) {
        int n = end - start + 1;
        return n + n * (n - 1) / 2;
    }

    private int lastDownDirIndex(int[] ratings, int start) {
        for (int i = start; i < ratings.length - 1; i++) {
            if (ratings[i] <= ratings[i + 1]) {
                return i;
            }
        }
        return ratings.length - 1;
    }
}
