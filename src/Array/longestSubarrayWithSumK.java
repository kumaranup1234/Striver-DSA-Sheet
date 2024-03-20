package Array;

import java.util.HashMap;

public class longestSubarrayWithSumK {

    // best solution
    // time complexity O(N)
    // will only work for 0 and positives number
    // for negatives hashmap solution will be optimal
    public static int longestSubarrayWithSumKSol(int[] a, long k) {
        int j = 0;
        long sum = 0;
        int maxl = 0;
        for(int i = 0; i < a.length; i++){
            sum = sum  +a[i];
            if(sum > k){
                while(sum > k){
                    sum = sum - a[j];
                    j++;
                }
            }
            if(sum == k){
                maxl = Math.max(maxl, i-j+1);
            }
        }
        return maxl;
    }

    // hashmap solution
    // not able to understand fully
    // Time Complexity O(N)
    // Space Complexity O(N)

    // copied the sol from coding ninja
    public static int longestSubarrayIncNegatives(int[] nums, int k){
        int n = nums.length;

        // Declare a hashtable 'prefixSumMap'.
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();

        // Initialize a variable 'ANS' with 0.
        int ans = 0;

        // Initialize a variable 'SUM' with 0.
        int sum = 0;

        // Assign -1 to 'prefixSumMap[ 0 ]'.
        prefixSumMap.put(0,-1);

        // Run a loop from 'i' = 0....'N' - 1:
        for (int i = 0; i < n; i++) {
            // Add the value of 'NUMS[ i ]' in variable 'SUM'.
            sum += nums[i];

            // If the value 'SUM' - 'K' is already present in the hashtable
            // then update the value of 'ANS' with maximum of 'ANS' and
            // 'i' - 'prefixSumMap[ SUM - K ]' + 1.
            if (prefixSumMap.containsKey(sum-k)) {
                ans = Math.max(ans, i - prefixSumMap.get(sum - k));
            }

            // If the value of 'SUM' is not present in the hashtable then
            // do 'prefixSumMap[ SUM ]' = 'i'
            if (!prefixSumMap.containsKey(sum)) {
                prefixSumMap.put(sum,i);
            }
        }

        // Return the value of variable 'ANS'.
        return ans;
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 3, 1, 1, 1, 1};
        long l = 3;
        int k = 3;
        System.out.println(longestSubarrayWithSumKSol(num, l));
        System.out.println(longestSubarrayIncNegatives(num, k));
    }
}
