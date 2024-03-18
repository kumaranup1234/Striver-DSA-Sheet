package Array;

public class missingNumber {
    public static int missingNumberSol(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
        }
        int requiredSum = (n * (n+1)) / 2;
        return requiredSum - sum;
    }

    public static void main(String[] args) {
        int[] nums = {3,0,1};
        System.out.println(missingNumberSol(nums));
    }
}
