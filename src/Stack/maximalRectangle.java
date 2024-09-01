package Stack;

import java.util.Stack;

public class maximalRectangle {
    public static int maximalRectangleSol(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int[] heights = new int[n + 1]; // Extra space to handle stack pop at the end
        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            Stack<Integer> s = new Stack<>();
            for (int j = 0; j <= n; j++) {
                if (j < n) {
                    if (matrix[i][j] == '1') {
                        heights[j] += 1;
                    } else {
                        heights[j] = 0;
                    }
                }

                // Calculate area with heights in the stack for each column element
                // Monotonically Increasing stack
                //  stack maintains indices in increasing order of heights
                while (!s.isEmpty() && heights[s.peek()] > heights[j]) {
                    int height = heights[s.pop()];
                    // we want to exclude the jth bar so -1 extra
                    int width = s.isEmpty() ? j : j - s.peek() - 1;
                    maxArea = Math.max(maxArea, height * width);
                }
                s.push(j);
            }
        }

        // This is because a smaller height to the right means that the rectangle
        // with the height from the top of the stack must end there. Thus,
        // it triggers a calculation of the area.

        return maxArea;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(maximalRectangleSol(matrix));
    }
}
