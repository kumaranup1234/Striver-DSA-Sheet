package TwoPointerAndSliding;

public class removeElement {
    // O(N)
    // Two Pointers
    public static int removeElementSol(int[] nums, int val) {
        int j = 0;

        for (int k = 0; k < nums.length; k++) {
            if(nums[k] != val){
                nums[j] = nums[k];
                j++;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(removeElementSol(nums, val));
    }
}
