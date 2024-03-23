package Array;

// Leaders in an array problem in the sde sheet


import java.util.ArrayList;
import java.util.List;

public class superiorElements {
    public static List< Integer > superiorElementsSol(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int max = 0;
        for (int i = nums.length-1; i >= 0; i--) {
            if (nums[i] > max){
                ans.add(nums[i]);
            }
            max = Math.max(max, nums[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2};
        System.out.println(superiorElementsSol(nums));
    }
}
