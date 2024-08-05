package Recursion;

// https://www.naukri.com/code360/problems/subset-sum_630213?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

import java.util.Arrays;

public class subsetSum {
    public static boolean isSubsetPresent(int n, int k,int []arr) {
        return countIterative(arr, k) > 0;
    }
    public static int countIterative(int[] arr, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        int MOD = 1000000007;

        for (int num : arr) {
            for (int currentSum = sum; currentSum >= num; currentSum--) {
                dp[currentSum] = (dp[currentSum] + dp[currentSum - num]) % MOD;
            }
        }

        return dp[sum];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int k = 5;
        int n = arr.length;
        System.out.println(isSubsetPresent(n, k, arr));
    }
}
