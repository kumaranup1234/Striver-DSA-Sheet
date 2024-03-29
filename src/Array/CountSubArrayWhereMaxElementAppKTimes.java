package Array;

public class CountSubArrayWhereMaxElementAppKTimes {
    // Time Complexity O(N)
    // Space Complexity O(1)

    // Sliding Window question
    public static long countSubarrays(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max){
                max = nums[i];
            }
        }
        long count = 0;
        long ans = 0;
        int i = 0;
        int j = 0;

        while (j < nums.length){
            if (nums[j] == max){
                count++;
            }
            while (count >= k && i <= j){
                if (nums[i] == max){
                    count--;
                }
                i++;
                ans = ans + (nums.length- j);
            }
            j++;

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {28,5,58,91,24,91,53,9,48,85,16,70,91,91,47,91,61,4,54,61,49};
        int k = 1;
        // answer will be 187
        System.out.println(countSubarrays(nums, k));
    }
}
