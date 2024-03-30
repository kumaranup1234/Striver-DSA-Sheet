package Array;

import java.util.HashMap;

// Time Complexity O(N)
// Space Complexity O(N)
public class subArrayWithKDifferentIntegers {
    public static int subarraysWithKDistinct(int[] nums, int k) {
        // the catch is here only
        return atMost(nums, k) - atMost(nums, k-1);
    }

    public static int atMost(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int n = nums.length;
        int ans = 0;

        while (j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while (map.size() > k) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }
            ans += j - i + 1;
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3};
        int k = 2;
        System.out.println(subarraysWithKDistinct(nums, k));
    }
}
