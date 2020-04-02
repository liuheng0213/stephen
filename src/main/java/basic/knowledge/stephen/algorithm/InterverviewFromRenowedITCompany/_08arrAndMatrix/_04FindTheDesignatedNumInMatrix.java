package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._08arrAndMatrix;

//在行列都排好序的矩阵中找指定数
public class _04FindTheDesignatedNumInMatrix {
    public static void main(String[] args) {
        _04FindTheDesignatedNumInMatrix findTheDesignatedNumInMatrix = new _04FindTheDesignatedNumInMatrix();
        int[][] arr = new int[][]{{0, 1, 2, 5}, {2, 3, 4, 7}, {4, 4, 4, 8}, {5, 7, 7, 9}};
        boolean res = findTheDesignatedNumInMatrix.findNum(arr, 6);
        System.out.println(res);
    }

    // 已经排好序的  从arr[0][arr[0].length - 1] 开始往左下角找
    private boolean findNum(int[][] arr, int k) {
        int i = 0;
        int j = arr[0].length - 1;
        while (i < arr.length && j > -1) {
            if (arr[i][j] == k) {
                return true;
            } else if (arr[i][j] > k) {
                j--;
            }else {
                i++;
            }
        }
        return false;
    }
}
