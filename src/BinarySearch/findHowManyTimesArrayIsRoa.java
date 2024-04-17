package BinarySearch;

public class findHowManyTimesArrayIsRoa {
    public static int findKRotation(int []nums){
        int left = 0;
        int right = nums.length - 1;

        // if array in not rotated return 0
        if (nums[left] < nums[right]) {
            return 0;
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

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        System.out.println(findKRotation(nums));
    }
}
