package BinarySearch;

import java.util.Arrays;

public class firstAndLastPos {
    public static int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int[] ans = {-1, -1};

        // Search for the first occurrence
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                ans[0] = mid;
                high = mid - 1; // Continue searching towards left for first occurrence
            } else if (nums[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        // Search for the last occurrence
        low = 0;
        high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                ans[1] = mid;
                low = mid + 1; // Continue searching towards right for last occurrence
            } else if (nums[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums, target)));

    }
}
