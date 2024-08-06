package Recursion;

import java.util.ArrayList;
import java.util.List;

public class subsets {
    // iterative sol
    public static List<List<Integer>> subsetsSol(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int n = res.size();
            // The outer loop iterates over each number in nums.
            // For every element num, it creates new subsets by adding num
            // to all existing subsets.

            // The inner loop iterates over the existing subsets in res.
            // For each subset, it creates a new subset by adding the current
            // element num and then adds this new subset back to res.
            for (int j = 0; j < n; j++) {
                List<Integer> subset = new ArrayList<>(res.get(j));
                subset.add(nums[i]);
                res.add(subset);
            }

        }
        return res;
    }
    // can be done using recursion

    public static List<List<Integer>> subsetsSolRecursive(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }

    public static void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, int start) {
        res.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(res, temp, nums, i + 1);
            temp.removeLast();
        }
    }



    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsetsSol(nums));
        System.out.println(subsetsSolRecursive(nums));
    }
}
