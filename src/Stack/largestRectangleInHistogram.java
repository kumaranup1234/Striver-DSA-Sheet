package Stack;

import java.util.Arrays;
import java.util.Stack;

public class largestRectangleInHistogram {
    // O(n^2) sol
    // will give tle
    public static int largestRectangleArea(int[] heights) {
        int area = 0;

        for (int i = 0; i < heights.length; i++) {
            int currMax = 0;
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < heights.length; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                currMax = Math.max(currMax, minHeight * (j - i + 1));
            }
            area = Math.max(area, currMax);
        }
        return area;
    }

    // on using Stack we can achieve th optimal sol

    // Main aim is to find the nearest smallest element to the left and the right as
    // that would be the range of width we can extend for A[i]. The height is given to
    // us. We than calculate the maximum area out of all of them.
    public static int largestRectangleAreaOptimized(int[] heights) {
        int area = 0;
        Stack<Integer> s = new Stack<>();
        int[] prevSmaller = new int[heights.length];
        Arrays.fill(prevSmaller, -1);
        int[] nextSmaller = new int[heights.length];
        Arrays.fill(nextSmaller, heights.length);

        // prevSmaller
        for (int i = 0; i < heights.length; i++) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            if (!s.isEmpty()){
                prevSmaller[i] = s.peek();
            }
            s.push(i);
        }
        s.clear();
        // nextSmaller
        for (int i = heights.length-1; i >= 0; i--) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            if (!s.isEmpty()){
                nextSmaller[i] = s.peek();
            }
            s.push(i);
        }

        for (int i = 0; i < heights.length; i++) {
            area = Math.max(area, heights[i] * (nextSmaller[i] - prevSmaller[i] - 1));
        }
        return area;
    }

    public static void main(String[] args) {
        int[] heights = {0, 9};
        System.out.println(largestRectangleArea(heights));
        System.out.println(largestRectangleAreaOptimized(heights));
    }
}
