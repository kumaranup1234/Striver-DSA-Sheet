package Stack;

import java.util.Arrays;
import java.util.Stack;

// complexity for the brute sol
// T.C O(N*N)
// S.C O(N * 2)

public class nextGreaterElement2 {
    public static int[] nextGreaterElementsBrute(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        int[] numsNew = new int[nums.length * 2];
        for (int i = 0; i < numsNew.length; i++) {
            numsNew[i] = nums[i%nums.length];
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < numsNew.length; j++) {
                if (nums[i] < numsNew[j]) {
                    res[i] = numsNew[j];
                    break;
                }
            }
        }
        return res;
    }

    // optimized approach will use stack to store indices for the elements which  does not have next greater
    //
    public static int[] nextGreaterElementsOptimized(int[] nums) {
        int n = nums.length;
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = n-1; i >= 0; i--) {
            stack.push(i);
        }

        for (int i = n-1; i >= 0; i--) {
            res[i] = -1;


            // element present in the index stored should be greater that current idx element
            while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) {
                stack.pop();
            }

            // if stack not empty means the index stored will be the next greater for that element
            if (!stack.isEmpty()) {
                res[i] = nums[stack.peek()];
            }
            // else push current as maybe it will be next greater for another element
            stack.push(i);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3};
        System.out.println(Arrays.toString(nextGreaterElementsBrute(nums)));
    }
}
