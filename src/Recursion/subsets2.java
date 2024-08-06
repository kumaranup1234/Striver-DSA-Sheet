package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsets2 {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }

    public static void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, int start) {
        res.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            backtrack(res, temp, nums, i + 1);
            temp.removeLast();
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsetsWithDup(nums));
    }
}
