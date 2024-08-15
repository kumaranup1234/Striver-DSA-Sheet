package Recursion;

import java.util.*;

// using hashset will decrease the time for membership check

public class wordBreak {
    public static boolean wordBreakSol(String s, List<String> wordDict) {
        Map<Integer, Boolean> memo = new HashMap<>();
        Set<String> wordSet = new HashSet<>(wordDict);
        return canBreak2(s, wordSet, 0, memo);
    }

    public static boolean canBreak(String s, List<String> wordDict, int start) {
        if (start == s.length()) {
            return true;
        }

       for (String word : wordDict){
           int end = start + word.length();
           if (end <= s.length() && s.substring(start, end).equals(word)) {
               if(canBreak(s, wordDict, end)){
                   return true;
               }
           }
       }
        return false;
    }

    // memo
    // T.C (m*n) m- no of words in the hashset n-length of string
    // S.c O(n+m)

    public static boolean canBreak2(String s, Set<String> wordSet, int start,  Map<Integer, Boolean> memo) {
        if (start == s.length()) {
            return true;
        }

        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        for (String word : wordSet){
            int end = start + word.length();
            if (end <= s.length() && wordSet.contains(s.substring(start, end))) {
                if(canBreak2(s, wordSet, end, memo)) {
                    memo.put(start, true);
                    return true;
                }
            }
        }
        memo.put(start, false); // no break found
        return false;
    }


    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreakSol(s, wordDict));
    }
}
