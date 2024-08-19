package Stack;

import java.util.Arrays;
import java.util.Stack;

public class nextSmallerElement {
    // TLE
    public static int[] prevSmaller(int[] nums) {
        int n = nums.length;
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        for (int i = n-1; i >= 0; i--) {
            for (int j = i-1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    res[i] = nums[j];
                    break;
                }
            }
        }
        return res;
    }

    // optimized
    public static int[] prevSmallerOptimized(int[] nums) {
        int n = nums.length;
        int[] res = new int[nums.length];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            res[i] = -1;
            while(!s.isEmpty() && nums[i] <= nums[s.peek()]) {
                s.pop();
            }
            if (!s.isEmpty()) {
                res[i] = nums[s.peek()];
            }
            s.push(i);
        }
        return res;
    }



    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(prevSmaller(nums)));
        System.out.println(Arrays.toString(prevSmallerOptimized(nums)));
    }
}
