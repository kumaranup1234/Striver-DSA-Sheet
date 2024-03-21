package Array;

import java.util.Arrays;

// Time Complexity O(N)
// Medium question
// pretty much state forward

public class sortColors {
    public static void sortColorsSol(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int k = 0;

        while (k <= j) {
            if (nums[k] == 0) {
                int temp = nums[i];
                nums[i] = 0;
                nums[k] = temp;
                i++;
                k++;
            } else if (nums[k] == 2) {
                int temp = nums[j];
                nums[j] = 2;
                nums[k] = temp;
                j--;
            } else {
                k++;
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = {2,1,2};
        sortColorsSol(nums);
        System.out.println(Arrays.toString(nums));

    }
}
