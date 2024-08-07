package Recursion;

import java.util.ArrayList;
import java.util.List;

// T.C O(4^N) where
//n is the length of the input string digits
// bcz for 7 and 8 there are 4 letters

public class LetterCombinationOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        // Handle the edge case where the input is empty
        if (digits == null || digits.isEmpty()) {
            return ans;
        }

        StringBuilder output = new StringBuilder();
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        solve(digits, output, 0, ans, mapping);
        return ans;
    }

    private void solve(String digits, StringBuilder output, int index, List<String> ans, String[] mapping) {
        // Base case: if index reaches the length of digits, add output to the answer list
        if (index >= digits.length()) {
            ans.add(output.toString());
            return;
        }

        // Get the digit and map it to the corresponding string
        int number = digits.charAt(index) - '0';
        String letters = mapping[number];

        // Iterate over the mapped string and recurse
        for (int i = 0; i < letters.length(); i++) {
            output.append(letters.charAt(i)); // Append a single character
            solve(digits, output, index + 1, ans, mapping);
            output.deleteCharAt(output.length() - 1); // Backtrack
        }
    }

    public static void main(String[] args) {
        LetterCombinationOfAPhoneNumber obj = new LetterCombinationOfAPhoneNumber();
        String input = "23"; // Example input
        List<String> result = obj.letterCombinations(input);

        // Print the result
        System.out.println("Letter combinations for input " + input + ": " + result);
    }
}
