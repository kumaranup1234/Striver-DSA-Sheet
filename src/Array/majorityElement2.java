package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class majorityElement2 {
    // Time Complexity O(N)
    // Space Complexity O(N)
    public static List<Integer> majority(int[] nums){
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        n = n / 3;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n){
                ans.add(entry.getKey());
            }
        }
        return ans;
    }

    // the main part is to solve this in constant space
    // 1. find the candidates
    // 2. count the occurrences
    // 3. add is they appear n / 3 times

    public static List<Integer> majoritySpace(int[] nums){
        int n = nums.length;
        int count1 = 0, count2 = 0;
        Integer candidate1 = null, candidate2 = null;

        // Find candidates
        for (int num : nums) {
            if (candidate1 != null && candidate1 == num) {
                count1++;
            } else if (candidate2 != null && candidate2 == num) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Reset counts
        count1 = 0;
        count2 = 0;

        // Count occurrences
        for (int num : nums) {
            if (candidate1 != null && num == candidate1) {
                count1++;
            }
            if (candidate2 != null && num == candidate2) {
                count2++;
            }
        }

        List<Integer> result = new ArrayList<>();
        if (count1 > n / 3) {
            result.add(candidate1);
        }
        if (count2 > n / 3) {
            result.add(candidate2);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2};
        System.out.println(majority(nums));
        System.out.println(majoritySpace(nums));
    }
}
