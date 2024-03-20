package Array;

import java.util.Arrays;
import java.util.HashMap;

// Time Complexity O(N)
// Space Complexity O(N)

public class twoSum {
    public static int[] twoSumSol(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int needed = target - num;
            if (map.containsKey(needed)){
                return new int[]{i, map.get(needed)};
            }

            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3};
        int target = 6;
        System.out.println(Arrays.toString(twoSumSol(nums, target)));
    }
}
