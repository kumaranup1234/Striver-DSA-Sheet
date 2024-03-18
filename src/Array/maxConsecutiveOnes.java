package Array;

public class maxConsecutiveOnes {
    public static int findMaxConsecutiveOnesSol(int[] nums) {
        if (nums.length == 1){
            if (nums[0] == 0){
                return 0;
            }else{
                return 1;
            }
        }
        int prevCount = Integer.MIN_VALUE;
        int currCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1){
                currCount++;
            } else if (nums[i] != 1) {
                currCount = 0;
            }
            if (prevCount < currCount){
                prevCount = currCount;
            }


        }
        return prevCount;

    }

    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnesSol(nums));
    }
}
