package Recursion;

import java.util.Arrays;

public class perfectSumProblem {
    // recursion approach took more give got tle
    // have to optimize it using dp
    // memoized the sol still getting tle
    public static int perfectSum(int[] arr, int n, int sum) {
        int[][] mem = new int[n][sum+1];
        return countIterative(arr, n, sum);
    }
    public static int count (int[] arr, int sum, int n, int index, int[][] mem){
        if (index == n){
            if (sum == 0) {
                return 1;
            }
            return 0;
        }
        if (sum < 0) {
            return 0;
        }
        if (mem[index][sum] != 0){
            return mem[index][sum];
        }

        int includeCount = count(arr, sum- arr[index], n, index+1, mem);
        int excludeCount = count(arr, sum, n, index+1, mem);
        mem[index][sum] = includeCount + excludeCount;
        return includeCount + excludeCount;
    }

    public static int countIterative(int[] arr, int n, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        int MOD = 1000000007;

        for (int num : arr) {
            for (int currentSum = sum; currentSum >= num; currentSum--) {
                dp[currentSum] = (dp[currentSum] + dp[currentSum - num]) % MOD;
            }
            System.out.println("DP State after including " + num + ": " + Arrays.toString(dp));
        }

        return dp[sum];
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 10, 6, 8};
        int n = arr.length;
        int sum = 10;
        System.out.println(perfectSum(arr, n, sum));
    }
}
