package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class findAllDuplicates {

    // space can be optimized here again
    public static List<Integer> findDuplicates(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                ans.add(nums[i]);
            }else{
                map.put(nums[i], 1);
            }
        }
        return ans;
    }

    //

    public static List<Integer> findDuplicatesSpaceOptimized(int[] nums){
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                ans.add(Math.abs(nums[i]));
            } else {
                nums[index] = -nums[index];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(nums));
        System.out.println(findDuplicatesSpaceOptimized(nums));

    }
}
