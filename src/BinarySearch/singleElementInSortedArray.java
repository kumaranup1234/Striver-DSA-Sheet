package BinarySearch;

// Time Complexity O(N)

public class singleElementInSortedArray {
    public static int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            if (nums[start] == nums[start + 1]) {
                start = start + 2;
            }
            if (nums[end] == nums[end - 1]) {
                end = end - 2;
            }
        }
        return nums[start];
    }

    // Time Complexity O(logN)
    // https://leetcode.com/problems/single-element-in-a-sorted-array/solutions/3212178/day-52-binary-search-easiest-beginner-friendly-sol/

    public static int singleNonDuplicate2(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid % 2 == 1) mid--; // Ensure mid is even

            if (nums[mid] != nums[mid + 1]) {
                // If mid is not equal to the next one, the single element is on the left
                end = mid;
            } else {
                // If mid is equal to the next one, the single element is on the right
                start = mid + 2;
            }
        }
        return nums[start];
    }


    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(singleNonDuplicate(nums));
        System.out.println(singleNonDuplicate2(nums));
    }
}
