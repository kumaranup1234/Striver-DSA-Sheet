package Strings;

import java.util.Stack;

// Time Complexity O(N)
// Space Complexity O(N)

public class makeStringGreat {
    public static String makeGood(String s) {
        Stack<Character> stack = new Stack<>();


        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (!stack.empty() && Math.abs(c - stack.peek()) == 32) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        StringBuilder ans = new StringBuilder();
        while (!stack.empty()) {
            // ans character are present in reverse order
            ans.insert(0, stack.pop());
        }
        return ans.toString();
    }
}
