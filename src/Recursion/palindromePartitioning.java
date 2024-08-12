package Recursion;

import java.util.ArrayList;
import java.util.List;

// Time Complexity: O(n * 2^n) O(n) for checking palin and 2^n for partition
public class palindromePartitioning {
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        recurse(s, res, new ArrayList<>(), 0);
        return res;
    }

    public static void recurse(String s, List<List<String>> res, List<String> temp, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            // ony if the current is palin
            if (checkPalindrome(s.substring(start, i + 1))) {
                temp.add(s.substring(start, i + 1));
                recurse(s, res, temp, i + 1);
                //After exploring one partition option, remove the last added substring to backtrack and explore other options.
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static boolean checkPalindrome(String temp) {
        int start = 0;
        int end = temp.length() - 1;
        while (start <= end) {
            if (temp.charAt(start) != temp.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "efe";
        //[["e","f","e"]["efe"]]
        System.out.println(partition(s));
    }
}
