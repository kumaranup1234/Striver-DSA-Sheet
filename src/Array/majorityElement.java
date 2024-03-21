package Array;

import java.util.HashMap;
import java.util.Map;

public class majorityElement {

    // Time Complexity O(N)
    // Space Complexity O(N)
    public static int majorityElementSol(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        n = n / 2;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n){
                return entry.getKey();
            }
        }
        return 0;
    }

    // Space can be reduced further to constant
    // Time Complexity O(N)
    // Space Complexity O(N)
    // This will use Moore Voting Algorithm
    // for revision about how this algo works goto this link
    // https://leetcode.com/problems/majority-element/solutions/3676530/3-method-s-beats-100-c-java-python-beginner-friendly/

    public static int majorityElementOptimized(int[] nums){
        int count = 0;
        int candidate = nums[0];

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count++;
            } else {
                count--;
            }

        }
        return candidate;
    }




    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElementSol(nums));
        System.out.println(majorityElementOptimized(nums));
    }
}
