package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._08arrAndMatrix;

//找到数组中未出现的最小正整数
//时间空间 都是O(n)的方法
public class _19MinPositiveInt {
    public static void main(String[] args) {
        _19MinPositiveInt minPositiveInt = new _19MinPositiveInt();
        int[] arr = new int[]{7,6,8,9};
        int res = minPositiveInt.getRes(arr);
        System.out.println(res);
    }

    private int getRes(int[] arr) {
        int len = arr.length;
        int[] aux = new int[len];
        for (int i = 0; i < len; i++) {
            if (arr[i] <= len && arr[i] >= 1) {
                aux[arr[i] - 1] = arr[i];
            }
        }

        for (int i = 0; i < len; i++) {
            if (aux[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }
}
