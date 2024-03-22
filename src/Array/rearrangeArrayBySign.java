package Array;

import java.util.Arrays;

public class rearrangeArrayBySign {

    // Time Complexity O(N)
    // Space Complexity O(N)
    public static int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        int i = 0;
        int j = 1;
        int k = 0;

        while(k < nums.length){
            if (nums[k] < 0){
                ans[j] = nums[k];
                j = j + 2;
            }else{
                ans[i] = nums[k];
                i = i + 2;
            }
            k++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,-2,-5,2,-4};
        System.out.println(Arrays.toString(rearrangeArray(nums)));
    }
}
