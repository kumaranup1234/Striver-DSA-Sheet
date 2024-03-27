package Array;

import java.util.HashSet;

public class firstMissingPositive {
    // Time Complexity O(N)
    // Space Complexity O(N)
    // required space in the question is O(1)
    //
    public static int firstMissingPositiveSol(int[] nums) {
        int max = nums[0];
        HashSet<Integer> hash = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0){
                hash.add(nums[i]);
            }
            if (nums[i] > max){
                max = nums[i];
            }
        }
        // edge case
        if(max < 0){
            return 1;
        }
        for (int i = 1; i <= max; i++) {
             if (!hash.contains(i))
                 return i;
        }
        return max+1;
    }

    // not able to come up with the space optimized sol
    // seen the sol cyclic sort is used
    // will code it later

    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        System.out.println(firstMissingPositiveSol(nums));
    }
}
