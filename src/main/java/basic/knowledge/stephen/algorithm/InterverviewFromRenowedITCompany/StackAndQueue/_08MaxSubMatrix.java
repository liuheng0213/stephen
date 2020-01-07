package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany.StackAndQueue;

import java.util.Stack;

public class _08MaxSubMatrix {
    public static void main(String[] args) {
        _08MaxSubMatrix maxSubMatrix = new _08MaxSubMatrix();
        int[][] map = new int[][]{{0, 0, 1, 1}, {0, 1, 0, 1}, {1, 1, 1, 0}};
        int res = maxSubMatrix.maxRecSize(map);
        System.out.println(res);
    }

    private int maxRecSize(int[][] map) {
        if (map == null || map.length == 0 || map[0].length == 0) {
            return 0;
        }
        int[] height = new int[map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
            }
        }
        return maxRecFromBottom(height);
    }

    private int maxRecFromBottom(int[] height) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                int curArea = (i - k - 1) * height[j];
                maxArea = Math.max(maxArea, curArea);
            }
            stack.push(i);
        }

        //清算阶段
        while (!stack.isEmpty()) {
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            int curArea = (height.length - k - 1) * height[j];
            maxArea = Math.max(maxArea, curArea);
        }

        return maxArea;
    }
}
