package Array;

import java.util.Arrays;

public class moveZeroes {
    public static void moveZeroesSol(int[] nums) {
        int index = 0; // Tracks the index to place non-zero elements

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // If the current element is non-zero, move it to the front
            if (nums[i] != 0) {
                nums[index] = nums[i];

                // If index and i are different, it means we have moved a non-zero element
                // So, we need to set nums[i] to zero
                if (index != i) {
                    nums[i] = 0;
                }

                // Increment the index to place the next non-zero element
                index++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroesSol(nums);
        System.out.println(Arrays.toString(nums));
    }
}
