package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._08arrAndMatrix;


//找到一个局部最小的位置
public class _14PartialSmallestPosition {
    public static void main(String[] args) {
        _14PartialSmallestPosition partialSmallestPosition = new _14PartialSmallestPosition();
        int[] arr = new int[]{7, 3, 4, 5, 6, 7, 8, 6, 4, 3, 2, 10};
        int res = partialSmallestPosition.getSmallestIndex(arr);
        System.out.println(res);

    }

    private int getSmallestIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        //想想 下面注释代码能删么
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        int n = arr.length;
        if (arr[n - 1] < arr[n - 2]) {
            return n - 1;
        }

        int left = 1;
        int right = arr.length - 2;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid - 1] < arr[mid]) {
                right = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;

    }
}
