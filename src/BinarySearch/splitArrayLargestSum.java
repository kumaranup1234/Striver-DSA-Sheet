package BinarySearch;

public class splitArrayLargestSum {
    // brut sol
    public static int splitArray(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            max = Math.max(max, nums[i]);
        }

        for (int i = max; i <= sum; i++) {
            if (helper(nums, i) == k){
                return i;
            }
        }
        return max;
    }
    // binary search sol
    // T.C O(log(sum - max + 1) * N)

    private static int splitArrayOptimized(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            max = Math.max(max, nums[i]);
        }
        int low = max;
        int high = sum;

        while (low <= high){
            int mid = low + (high - low) / 2;
            if (helper(nums, mid) > k){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return low;
    }

    private static int helper(int[] arr, int max) {
        int partition = 1;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] <= max) {
                sum += arr[i];
            }else{
                partition++;
                sum = arr[i];
            }
        }
        return partition;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,1,1,1};
        int k = 5;
        System.out.println(splitArray(nums, k));
        System.out.println(splitArrayOptimized(nums, k));
    }
}
