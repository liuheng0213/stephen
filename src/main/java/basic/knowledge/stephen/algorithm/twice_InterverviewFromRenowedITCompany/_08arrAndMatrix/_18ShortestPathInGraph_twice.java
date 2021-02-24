package basic.knowledge.stephen.algorithm.twice_InterverviewFromRenowedITCompany._08arrAndMatrix;


import java.util.LinkedList;

public class _18ShortestPathInGraph_twice {
    public static void main(String[] args) {
        _18ShortestPathInGraph_twice shortestPathInGraph = new _18ShortestPathInGraph_twice();
        int[][] matrix = new int[][]{{1, 1, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        int res = shortestPathInGraph.minPathValue(matrix);
        System.out.println(res);
    }

    private int minPathValue(int[][] matrix) {
        if (matrix == null || matrix[0] == null) {
            return 0;
        }
        int[][] map = new int[matrix.length][matrix[0].length];

        LinkedList<Integer> rQ = new LinkedList<>();
        LinkedList<Integer> cQ = new LinkedList<>();

        rQ.addLast(0);
        cQ.addLast(0);

        map[0][0] = 1;

        int r;
        int c;
        while (!rQ.isEmpty() || !cQ.isEmpty()) {
            r = rQ.poll();
            c = cQ.poll();

            if (r == matrix.length - 1 && c == matrix[0].length - 1) {
                return map[r][c];
            }

            walkTo(map, matrix, map[r][c], r - 1, c, rQ, cQ);
            walkTo(map, matrix, map[r][c], r + 1, c, rQ, cQ);
            walkTo(map, matrix, map[r][c], r, c - 1, rQ, cQ);
            walkTo(map, matrix, map[r][c], r, c + 1, rQ, cQ);
        }
        return 0;
    }

    private void walkTo(int[][] map, int[][] matrix, int pre, int rTo, int cTo, LinkedList<Integer> rQ, LinkedList<Integer> cQ) {
        if (rTo < 0 || rTo > map.length - 1 || cTo < 0 || cTo > map[0].length - 1
                || map[rTo][cTo] != 0 || matrix[rTo][cTo] != 1) {
            return;
        }
        map[rTo][cTo] = pre + 1;
        rQ.addLast(rTo);
        cQ.addLast(cTo);
    }


}
