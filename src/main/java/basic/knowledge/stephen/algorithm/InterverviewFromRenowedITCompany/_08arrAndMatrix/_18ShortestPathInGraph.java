package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._08arrAndMatrix;


import java.util.LinkedList;
import java.util.Queue;

//求最短通路图
public class _18ShortestPathInGraph {
    public static void main(String[] args) {
        _18ShortestPathInGraph shortestPathInGraph = new _18ShortestPathInGraph();
        int[][] matrix = new int[][]{{1, 1, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        int res = shortestPathInGraph.minPathValue(matrix);
        System.out.println(res);
    }

    private int minPathValue(int[][] matrix) {
        if (matrix == null || matrix.length == 0
                || matrix[0].length == 0 || matrix[0][0] != 1
                || matrix[matrix.length - 1][matrix[0].length - 1] != 1) {
            return 0;
        }

        int[][] map = new int[matrix.length][matrix[0].length];
        map[0][0] = 1;
        Queue<Integer> rQueue = new LinkedList<>();
        Queue<Integer> cQueue = new LinkedList<>();
        rQueue.add(0);
        cQueue.add(0);
        while (!rQueue.isEmpty() || !cQueue.isEmpty()) {
            int r = rQueue.poll();
            int c = cQueue.poll();
            if (r == matrix.length - 1 && c == matrix[0].length - 1) {
                return map[r][c];
            }
            walkTo(map[r][c], r - 1, c, matrix, map, rQueue, cQueue);
            walkTo(map[r][c], r + 1, c, matrix, map, rQueue, cQueue);
            walkTo(map[r][c], r, c - 1, matrix, map, rQueue, cQueue);
            walkTo(map[r][c], r, c + 1, matrix, map, rQueue, cQueue);
        }
        return 0;
    }

    private void walkTo(int pre, int r, int c, int[][] matrix, int[][] map,
                        Queue<Integer> rQueue, Queue<Integer> cQueue) {
        //matrix[r][c] == 1 不能走
        // map[r][c] == 0  走过
        if (r < 0 || r == matrix.length || c < 0 || c == matrix[0].length
                || matrix[r][c] != 1 || map[r][c] != 0) {
            return;
        }
        map[r][c] = pre + 1;
        rQueue.add(r);
        cQueue.add(c);
    }
}
