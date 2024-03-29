package Array;

public class maximumSubArray {

    // Kadane Algo will be used here to optimally find the solution
    // This is the optimized solution
    // Time complexity O(N)
    // Space is constant

    // It covers the iteration when we need to print the number which add upto the sum
    // also covers the negative values
    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int maxi = Integer.MIN_VALUE;
        int start = 0;
        int ansStart = 0;
        int ansEnd = 0;

        for (int i = 0; i < nums.length; i++) {
            if (sum == 0){
                start = i;
            }

            sum = sum + nums[i];
            if (sum > maxi){
                maxi = sum;
                ansStart = start;
                ansEnd = i;
            }

            if (sum < 0){
                sum = 0;
            }
        }
        return maxi;
    }

    public static void main(String[] args) {
        int[] nums = {-2,-1,-3,-4,-1,-2,-1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
