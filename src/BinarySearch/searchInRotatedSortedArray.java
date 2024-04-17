package BinarySearch;

// Input: nums = [4,5,6,7,0,1,2], target = 0
// Output: 4

public class searchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int pivotIndex = pivot(nums);
        int ans;
        if (nums[pivotIndex] == target) {
            System.out.println(pivotIndex);
            ans = pivotIndex;
        } else if (target >= nums[0]) {
           ans = binarySearch(nums, target, 0, pivotIndex - 1);
        } else {
            ans = binarySearch(nums, target, pivotIndex, nums.length - 1);
        }
        return ans;
    }
    public static int pivot(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // if array in not rotated return last element
        if (nums[left] < nums[right]) {
            return right;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    public static int binarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,3};
        int target =  3;
        System.out.println(search(nums, target));
    }
}
