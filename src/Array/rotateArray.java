package Array;

import java.util.Arrays;


// Medium in leetcode easy in the sheet
// Time Complexity O(N)

public class rotateArray {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        // to handle if k is larger than the array length
        // than we have to change it in the form with same rotation we get the same result
        k = k % n;
        // order of call matters
        // if hindered will produce wrong results
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    public static void reverse(int[] nums, int s ,int e){
        while (s < e) {
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));

    }
}
