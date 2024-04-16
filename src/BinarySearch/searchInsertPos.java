package BinarySearch;

public class searchInsertPos {
    public static int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int ans = nums.length;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] < target) {
                start = mid + 1;
            }else{
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 5;
        System.out.println(searchInsert(nums, target));
    }
}
