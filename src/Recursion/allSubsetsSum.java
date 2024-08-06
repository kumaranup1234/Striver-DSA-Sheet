package Recursion;

import java.util.ArrayList;
import java.util.List;

//Expected Time Complexity: O(2^n * n)
//Expected Auxiliary Space: O(2^n)

public class allSubsetsSum {
    public static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        backtrack(arr, ans, new ArrayList<>() , 0);
        return ans;
    }

    public static void backtrack(ArrayList<Integer> arr,ArrayList<Integer> ans, List<Integer> temp, int start) {
        int sum = 0;
        for(int i = 0; i < temp.size(); i++) {
            sum = sum + temp.get(i);
        }
        ans.add(sum);
        for (int i = start; i < arr.size(); i++) {
            temp.add(arr.get(i));
            backtrack(arr, ans, temp ,i+1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(3);
        System.out.println(subsetSums(arr, arr.size()));
    }
}
