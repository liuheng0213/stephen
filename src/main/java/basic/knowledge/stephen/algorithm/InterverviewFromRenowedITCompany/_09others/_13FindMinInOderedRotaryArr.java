package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._09others;

//在有序旋转数组中找到最小值
public class _13FindMinInOderedRotaryArr {
    public static void main(String[] args) {
        _13FindMinInOderedRotaryArr findMinInOderedRotaryArr = new _13FindMinInOderedRotaryArr();
        int[] arr = new int[]{4, 5, 6, 7, 8, 1, 2};
        int res = findMinInOderedRotaryArr.getMin(arr);
        System.out.println(res);
    }

    private int getMin(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while (low < high) {
            //如果只有两个
            if (low == high - 1) {
                break;
            }
            //没有旋转过
            if (arr[low] < arr[high]) {
                return arr[low];
            }
            mid = (low + high) >> 1;
            if (arr[low] > arr[mid]) {
                high = mid;
            } else if (arr[high] < arr[mid]) {
                low = mid;
            } else {// arr[low] == arr[mid] == arr[high]
                while (low < mid) {
                    if (arr[low] == arr[mid]) {
                        low++;
                    } else if (arr[low] < arr[mid]) {
                        return arr[low];
                    } else {
                        high = mid;
                        break;
                    }
                }
            }
        }
        return Math.min(arr[low], arr[high]);
    }
}
