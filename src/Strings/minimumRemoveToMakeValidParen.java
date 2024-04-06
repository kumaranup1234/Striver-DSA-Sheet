package Strings;

import java.util.Stack;

// Time and Space are O(N)

public class minimumRemoveToMakeValidParen {
    public static String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        boolean[] removeIndices = new boolean[s.length()];

        // 1st pass: Identify unnecessary closing brackets
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    // Mark unnecessary closing brackets for removal
                    removeIndices[i] = true;
                }
            }
        }

        // Mark unmatched opening brackets for removal
        while (!stack.isEmpty()) {
            removeIndices[stack.pop()] = true;
        }

        // 2nd pass: Build result string excluding unnecessary brackets
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!removeIndices[i]) {
                ans.append(s.charAt(i));
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";
        System.out.println(minRemoveToMakeValid(s));
    }
}
