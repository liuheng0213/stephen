package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._06bigDatAndSpaceLimitaion;

public class _01IslandIssue {
    public static void main(String[] args) {
        _01IslandIssue obj = new _01IslandIssue();
        int[][] matrix = new int[][]{{1, 0, 1, 1}, {1, 0, 1, 1}, {0, 0, 0, 0}, {1, 0, 1, 0}};
        int times = obj.getTimes(matrix);
        System.out.println(times);
    }

    public int getTimes(int[][] matrix) {
        if (matrix == null || matrix.length == 0
                || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    res++;
                    infect(matrix, i, j, matrix.length, matrix[i].length);
                }
            }
        }

        return res;
    }

    private void infect(int[][] matrix, int i, int j, int rowLen, int colLen) {
        if (i < 0 || i >= rowLen || j < 0 || j >= colLen || matrix[i][j] != 1) {
            return;
        }

        matrix[i][j] = 2;
        infect(matrix, i + 1, j, rowLen, colLen);
        infect(matrix, i - 1, j, rowLen, colLen);
        infect(matrix, i, j + 1, rowLen, colLen);
        infect(matrix, i, j - 1, rowLen, colLen);
    }
}
