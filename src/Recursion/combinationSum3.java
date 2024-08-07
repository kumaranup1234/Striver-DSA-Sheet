package Recursion;

import java.util.ArrayList;
import java.util.List;

// T.C O(9^k)
// S.C O(k)

public class combinationSum3 {
    public List<List<Integer>> combinationSum3Sol(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combinations(res, list, k, n, 0);
        return res;
    }

    public static void combinations(List<List<Integer>> res, List<Integer> temp, int k, int n, int start) {
        if (temp.size() == k && n == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        if (temp.size() > k || n <= 0) {
            return;
        }

        for (int i = start; i <= 9; i++) {
            temp.add(i);
            combinations(res, temp, k , n - i, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
