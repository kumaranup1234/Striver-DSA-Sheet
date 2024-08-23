package Stack;

import java.util.Arrays;
import java.util.Stack;

public class SumOfSubarrayRanges {
    // brute sol
    // accepted but can be optimized
    // T.C O(N^2)
    public static long subArrayRanges(int[] nums) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int currentMin = nums[i];
            int currentMax = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < currentMin) {
                    currentMin = nums[j];
                }
                if (nums[j] > currentMax) {
                    currentMax = nums[j];
                }
                sum += currentMax - currentMin;
            }
        }
        return sum;
    }

    public static long subArrayRangesOptimized(int[] nums){
        int max = sumSubarrayMaxsOptimized(nums);
        int min = sumSubarrayMinsOptimized(nums);
        return max - min;
    }

    // optimized sol
    public static int sumSubarrayMinsOptimized(int[] arr) {
        int mod = (int) 1e9 + 7;
        int n = arr.length;

        int[] prevSmall = new int[arr.length];
        // Initialize with -1 to handle the case with no smaller element on the left
        Arrays.fill(prevSmall, -1);
        // Initialize with n to handle the case with no smaller element on the right
        int[] nextSmall = new int[arr.length];
        Arrays.fill(nextSmall, n);
        Stack<Integer> stack = new Stack<>();

        // set the prevSmall of every element

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                prevSmall[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();
        // next smaller for every element
        for (int i = n-1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                nextSmall[i] = stack.peek();
            }
            stack.push(i);
        }

        System.out.println(Arrays.toString(prevSmall));
        System.out.println(Arrays.toString(nextSmall));

        long sum = 0;
        for (int i = 0; i < n; i++) {
            long count = (long) (i - prevSmall[i]) * (nextSmall[i] - i) % mod;
            sum = (sum + arr[i] * count) % mod;
        }
        return (int) sum;
    }

    // optimized sol
    public static int sumSubarrayMaxsOptimized(int[] arr) {
        int mod = (int) 1e9 + 7;
        int n = arr.length;

        int[] preLarge = new int[arr.length];
        // Initialize with -1 to handle the case with no smaller element on the left
        Arrays.fill(preLarge, -1);
        // Initialize with n to handle the case with no smaller element on the right
        int[] nextLarge = new int[arr.length];
        Arrays.fill(nextLarge, n);
        Stack<Integer> stack = new Stack<>();

        // set the prevSmall of every element

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                preLarge[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();
        // next smaller for every element
        for (int i = n-1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                nextLarge[i] = stack.peek();
            }
            stack.push(i);
        }

        System.out.println(Arrays.toString(preLarge));
        System.out.println(Arrays.toString(nextLarge));

        long sum = 0;
        for (int i = 0; i < n; i++) {
            long count = (long) (i - preLarge[i]) * (nextLarge[i] - i) % mod;
            sum = (sum + arr[i] * count) % mod;
        }
        return (int) sum;
    }

    public static void main(String[] args) {
        int[] nums = {4,-2,-3,4,1};
        System.out.println(subArrayRanges(nums));
        System.out.println(subArrayRangesOptimized(nums));
    }
}
