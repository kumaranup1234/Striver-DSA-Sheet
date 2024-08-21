package Stack;

// https://leetcode.com/problems/trapping-rain-water/solutions/5010194/2-approaches-simplest-explanation-monotonic-stack-two-pointer/

import java.util.Stack;

public class tappingRainwater {
    // T.C O(N^2)
    // got TLE
    public static int trapBrute(int[] height) {
        int n = height.length;
        int waterTrapped = 0;

        for (int i = 0; i < n; i++) {
            int leftMax = 0;
            int rightMax = 0;
            int j = i;

            while (j >= 0){
                leftMax = Math.max(leftMax, height[j]);
                j--;
            }
            j = i;
            while (j < n){
                rightMax = Math.max(rightMax, height[j]);
                j++;
            }
            waterTrapped += Math.min(leftMax ,rightMax) - height[i];
        }
        return waterTrapped;
    }

    // better sol
    // using prefix sum
    // T.C O(N)
    // S.C O(2*N)
    public static int trapBetter(int[] height) {
        int n = height.length;
        int waterTrapped = 0;
        int[] prefix = new int[n];
        int[] suffix = new int[n];


        prefix[0] = height[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = Math.max(height[i], prefix[i-1]);
        }
        // last element will have the suffix as the element itself
        suffix[n-1] = height[n-1];
        for (int i = n-2; i >= 0; i--) {
            // the i th element will have the suffix as the ith + 1 in the suffix array
            suffix[i] = Math.max(height[i], suffix[i+1]);
        }
        for (int i = 0; i < n; i++) {
            waterTrapped += Math.min(suffix[i], prefix[i]) - height[i];
        }
        return waterTrapped;
    }

    // best approach
    // using Two pointer approach

    public static int trapBest(int[] height) {
        int n = height.length;
        int waterTrapped = 0;

        int leftMax = 0;
        int rightMax = 0;

        int left = 0;
        int right = n-1;

        // left and right will meet at the largest element

        while (left < right) {

            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                }else{
                    waterTrapped += leftMax - height[left];
                }
                left++;
            }else{
                if (height[right] > rightMax) {
                    rightMax = height[right];
                }else{
                    waterTrapped += rightMax - height[right];
                }
                right--;
            }
        }
        return waterTrapped;
    }

    public static int trapStack(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int totalWater = 0;
        for (int right = 0; right < height.length; right++) {
            while (!stack.isEmpty()
                    && height[stack.peek()] < height[right]) {
                int bottom = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                // Identified water trapped = width * height
                int water = (right - left - 1) *
                        (Math.min(height[right], height[left]) - height[bottom]);
                totalWater += water;
            }
            stack.push(right);
        }
        return totalWater;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trapBrute(height));
        System.out.println(trapBetter(height));
        System.out.println(trapBest(height));
        System.out.println(trapStack(height));
    }
}
