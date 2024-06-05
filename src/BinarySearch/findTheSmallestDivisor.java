package BinarySearch;

public class findTheSmallestDivisor {
    public static int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = 1000000;
        int ans = Integer.MAX_VALUE;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int val = smallest(nums, mid);
            if (val <= threshold) {
                ans = mid;
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private static int smallest(int[] nums, int mid) {
        int sum = 0;
        for (int num : nums) {
            sum += (int) Math.ceil((double) num / mid);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 9};
        int threshold = 6;
        System.out.println(smallestDivisor(nums, threshold));
    }
}
