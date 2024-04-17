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

    // So, in the binary search approach
    // If nums[mid] is equal to nums[mid + 1], it means that all pairs up to
    // the index mid are complete, and the single non-duplicate number is
    // somewhere to the right. So, we update start to mid + 2.

    // If nums[mid] is not equal to nums[mid + 1], it means that the pair
    // for the number at mid is incomplete, and hence, the single
    // non-duplicate number must be somewhere to the left. So, we update end to mid.

    // this is the reason why we are keeping mid even
    // By ensuring that mid is always even, we’re always
    // comparing with the first element of a pair.

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
