package Array;

// easy
// Time Complexity O(N)
public class removeDuplicates {
    public static int removeDuplicatesSol(int[] nums) {
        int k =  1;
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] != nums[i+1]){
                nums[k] = nums[i+1];
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int k = removeDuplicatesSol(nums);
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
