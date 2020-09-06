package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._01stackAndQueue;

import java.util.Stack;

//最大子矩形大小
public class _09MaxSubMatrix {

    public int maxSubMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[] heights = new int[matrix[0].length];
        int maxArea = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                heights[j] = matrix[i][j] == 0 ? 0 : heights[j] + 1;
            }
            maxArea = Math.max(maxArea, getMaxArea(heights));
        }

        return maxArea;
    }

    private int getMaxArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int area = 0;
        int popIndex;
        int peekIndex;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                popIndex = stack.pop();
                peekIndex = stack.isEmpty() ? -1 : stack.peek();
                area = Math.max(area, heights[popIndex] * (i - peekIndex + 1));
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            popIndex = stack.pop();
            peekIndex = stack.isEmpty() ? -1 : stack.peek();
            area = Math.max(area, heights[popIndex] * (heights.length - peekIndex + 1));
        }

        return area;
    }
}
