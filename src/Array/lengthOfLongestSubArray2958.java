package Array;

import java.util.HashMap;
import java.util.Map;

public class lengthOfLongestSubArray2958 {
    // got the optimal solution
    // as i am using O(N) space in this
    // but my thinking was nearest only with the slightest mistake.
    // simple approach was to maintain count of frequency and if any time
    // my current element frequency exceeds k will move i and reduce the count
    // until the count of j comes again to less than or equal to k
    // and every time inner  loop end i check for max subarray length
    // loop will continue the length of array
    public static int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int max = 0;
        while (j < nums.length){
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while (map.get(nums[j]) > k) {
                map.put(nums[i], map.get(nums[i]) - 1);
                i++;
            }
            max = Math.max(max, j - i + 1);
            j++;
        }
        return max;
    }



    public static void main(String[] args) {
        int[] nums = {1,1,1,3};
        int k = 2;
        System.out.println(maxSubarrayLength(nums, k));
    }
}
