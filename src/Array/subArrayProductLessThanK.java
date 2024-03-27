package Array;

public class subArrayProductLessThanK {

    // Brute force solution
    // Time Complexity O(N^2)
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = i; j < nums.length; j++) {
                product *= nums[j];
                if (product < k) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    // can be optimized
    // sliding window approach
    // as we move right in the array the product will increase only

    // this is the standard template for two pointer
    public static int OptimizedSol(int[] nums, int k){
        if (k == 0 || k == 1){
            return 0;
        }
        int product = 1;
        int i = 0;
        int j = 0;
        int count = 0;

        while (j < nums.length){
            product = product * nums[j];

            while (product >= k){
                product = product / nums[i];
                i++;
            }
            count = count +  (j -i) + 1;
            j++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {10,5,2,6};
        int k = 100;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }
}
