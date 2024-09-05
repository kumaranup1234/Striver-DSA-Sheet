package Queue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class slidingWindowMaximum {
    // T.C O(n*k)
    // Got tle on this sol
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1){
            return nums;
        }

        int[] res = new int[nums.length - k + 1];
        int max;

        for (int i = 0; i < nums.length - k + 1; i++) {
            max = Integer.MIN_VALUE;
            for (int j = i; j < i+k; j++) {
                    max = Math.max(max, nums[j]);
            }
            res[i] = max;
        }
        return res;
    }

    // the optimized sol will b using queue

    public static int[] maxSlidingWindowSol(int[] nums, int k) {
        if (nums.length == 1){
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        //  deque holds the elements in decreasing order
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {

            // out of range elements
            while (!deque.isEmpty() && deque.peekFirst() <= i-k) {
                deque.pollFirst();
            }

            // smaller elements
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // add the element in the deque
            deque.offerLast(i);
            // if in range add it to the answer array
            // ensures that after exploring whole window size then we store the result
            if (i >= k - 1) {
                // from front the max element will be present for the given window
                res[i-k+1] = nums[deque.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {7, 2, 4};
        // 7, 4
        int k = 2;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
        System.out.println(Arrays.toString(maxSlidingWindowSol(nums, k)));
    }
}
