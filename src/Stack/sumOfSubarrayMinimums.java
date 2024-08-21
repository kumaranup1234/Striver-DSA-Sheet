package Stack;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class sumOfSubarrayMinimums {
    // T.C O(n^2)
    // got tle
    public static int sumSubarrayMinsBrute(int[] arr) {
        int min;
        int sum = 0;
        int MOD = 1_000_000_007;

        for (int i = 0; i < arr.length; i++) {
            min = arr[i];
            sum = (sum + min) % MOD;
            for (int j = i + 1; j < arr.length; j++) {
                min = Math.min(min, arr[j]);
                sum = (sum + min) % MOD;
            }
        }
        return sum;
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
    public static void main(String[] args) {
        int[] arr = {11,81,94,43,3};
        System.out.println(sumSubarrayMinsBrute(arr));
        System.out.println(sumSubarrayMinsOptimized(arr));
    }
}
