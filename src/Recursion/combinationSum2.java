package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// T.c O(2^n * k)
// S.C O(K * x) recur. sol not included
public class combinationSum2 {
    public static List<List<Integer>> combinationSum2Sol(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        // we need sorted combi.
        Arrays.sort(candidates);
        combinations(0, target, candidates, res, new ArrayList<>());
        return res;
    }
    public static void combinations(int index, int target, int[] candidates, List<List<Integer>> results, List<Integer> currentList) {

        if (target == 0){
            results.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = index; i < candidates.length; i++){
            // if i is greater and element are same means the element has appeared before so don't pick again
            if (i > index && candidates[i] == candidates[i-1]){
                continue;
            }
            //
            if (candidates[i] > target){
                break;
            }
            currentList.add(candidates[i]);
            combinations(i + 1, target - candidates[i], candidates, results, currentList);
            // backtrack
            currentList.remove(currentList.size() - 1);
        }
    }
    public static void main(String[] args) {
        int[] candidates = {2,5,2,1,2};
        int target = 5;
        List<List<Integer>> results = combinationSum2Sol(candidates, target);

        System.out.println("Combinations that sum up to " + target + ":");
        for (List<Integer> combination : results) {
            System.out.println(combination);
        }
    }
}
