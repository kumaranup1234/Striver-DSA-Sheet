package Recursion;

import java.util.ArrayList;
import java.util.List;

public class combinationSum {
    public static List<List<Integer>> combinationSumSOl(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combinations(0, target, candidates, res, new ArrayList<>());
        return res;
    }

    public static void combinations(int index, int target, int[] candidates, List<List<Integer>> results, List<Integer> currentList) {
        // Base case: If we've reached the end of candidates
        if (index == candidates.length) {
            // If the target is exactly zero, we've found a valid combination
            if (target == 0) {
                results.add(new ArrayList<>(currentList));
            }
            return; // Return as there are no more candidates to explore
        }

        // Explore the current candidate if it's less than or equal to the target
        if (candidates[index] <= target) {
            // Choose the current candidate
            currentList.add(candidates[index]);
            // Recursively explore with the same index (to allow repetition)
            combinations(index, target - candidates[index], candidates, results, currentList);
            // Backtrack by removing the last added candidate
            // will move to previous recursion call where the last value is present
            currentList.remove(currentList.size() - 1);
        }

        // Move to the next candidate (without including current candidate)
        combinations(index + 1, target, candidates, results, currentList);
    }
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> results = combinationSumSOl(candidates, target);

        System.out.println("Combinations that sum up to " + target + ":");
        for (List<Integer> combination : results) {
            System.out.println(combination);
        }
    }
}
