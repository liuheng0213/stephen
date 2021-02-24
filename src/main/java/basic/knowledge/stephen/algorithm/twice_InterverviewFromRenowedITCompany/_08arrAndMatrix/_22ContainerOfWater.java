package basic.knowledge.stephen.algorithm.twice_InterverviewFromRenowedITCompany._08arrAndMatrix;

//容器盛水问题
//方法1 : 时间O(N^2)
//方法2 : 时间O(N)  空间O(N)
//方法3 : 时间O(N)  空间O(1)
//无论如何要找到leftMax  rightMax
public class _22ContainerOfWater {
    public static void main(String[] args) {
        _22ContainerOfWater containerOfWater = new _22ContainerOfWater();
        int[] arr = new int[]{9, 2, 4, 1, 6, 2, 8, 4, 9};
        /*int res1 = containerOfWater.getWater1(arr);
        System.out.println(res1);*/
        /*int res2 = containerOfWater.getWater2(arr);
        System.out.println(res2);*/
        int res3 = containerOfWater.getWater3(arr);
        System.out.println(res3);
    }
    //方法3 : 时间O(N)  空间O(1)
    //双指针
    public int getWater3(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int res = 0;
        int leftMax = arr[0];
        int rightMax = arr[arr.length - 1];
        int left = 1;
        int right = arr.length - 2;
        while (left <= right) {
            if (leftMax <= rightMax) {
                res += Math.max(leftMax - arr[left], 0);
                //update leftMax
                leftMax = Math.max(leftMax, arr[left++]);
            } else {
                res += Math.max(rightMax - arr[right], 0);
                //update rightMax
                rightMax = Math.max(rightMax, arr[right--]);
            }
        }
        return res;
    }

    //方法2 : 时间O(N)  空间O(N)
    public int getWater2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] leftMax = new int[arr.length];//记录arr[i] 左边的最大值
        int[] rightMax = new int[arr.length];//记录arr[i] 右边的最大值
        leftMax[0] = arr[0];
        rightMax[arr.length - 1] = arr[arr.length - 1];
        for (int i = 1; i < arr.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }
        int res = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            res += Math.max(Math.min(leftMax[i - 1], rightMax[i + 1]) - arr[i], 0);
        }
        return res;

    }

    //方法1 : 时间O(N^2)
    public int getWater1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            int leftMax = 0;
            int rightMax = 0;
            for (int l = 0; l < i; l++) {
                leftMax = Math.max(arr[l], leftMax);
            }
            for (int r = i + 1; r < arr.length; r++) {
                rightMax = Math.max(arr[r], rightMax);
            }
            res += Math.max(0, Math.min(leftMax, rightMax) - arr[i]);
        }
        return res;
    }

}

