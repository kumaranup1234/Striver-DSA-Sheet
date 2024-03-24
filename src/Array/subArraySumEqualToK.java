package Array;


// not very intuitive solution

import java.util.HashMap;
import java.util.Map;

// Time Complexity O(N) + the time for getting the element from the hashmap
// Space Complexity O(N)

// we are putting 0,1 initially in the map bcz we can get the case when the complement required
// will be 0 like presum = k that time we are getting the sum but if we don't put 0,1
// we will not update the count and that will produce wrong answer

public class subArraySumEqualToK {
        public static int subarraySum(int[] nums, int k) {
            // Create a HashMap to store the prefix sum frequencies
            Map<Integer, Integer> map = new HashMap<>();
            // Initialize the map with the prefix sum 0 and frequency 1
            map.put(0, 1);
            // Initialize variables to track prefix sum, count of sub-arrays, and current prefix sum
            int preSum = 0;
            int count = 0;
            // Iterate through the array
            for (int i = 0; i < nums.length; i++) {
                // Calculate the current prefix sum by adding the current element to the previous prefix sum
                preSum = preSum + nums[i];
                // Calculate the complement value needed to reach the target sum k
                int complement = preSum - k;
                // Increment the count by the frequency of the complement value from the map
                count += map.getOrDefault(complement, 0);
                // Update the map with the current prefix sum and its frequency
                map.put(preSum, map.getOrDefault(preSum, 0) + 1);
            }
            // Return the total count of sub-arrays whose sum equals k
            return count;
        }


    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 2;
        System.out.println(subarraySum(nums, k));
    }
}
