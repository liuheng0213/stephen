package basic.knowledge.stephen.algorithm.leetcode.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Leetcode406 {
    public static void main(String[] args) {
        Leetcode406 leetcode406 = new Leetcode406();
        int[][] arr = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] res = leetcode406.reconstrcutQueue(arr);
        System.out.println(res);
    }

    public int[][] reconstrcutQueue(int[][] arr) {
        if (arr == null || arr.length == 0 || arr[0].length == 0) {
            return new int[0][0];
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o2[0] - o1[0];
            }
        });
        // [7,0],[7,1],[6,1],[5,0],[5,2],[4,4]
        // [7,0],[6,1],[7,1],.... list add 后会这样 add 这个方法对于排序后的arr 有这个效果:
        // 如果 arr[i][1]更大  add方法不改变相对位置  如果一样大 后来的  即arr[0][i] 更大的  将把其更小的挤后面
        int n = arr.length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(arr[i][1], new int[]{arr[i][0], arr[i][1]});
        }

        int[][] res = new int[n][arr[0].length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][0] = list.get(i)[0];
                res[i][1] = list.get(i)[1];
            }
        }
        return res;
    }
}
