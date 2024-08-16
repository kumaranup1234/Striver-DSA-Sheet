package Stack;

import java.util.Stack;

public class validParenthesis {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            }
            else if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
                if (stack.empty()) {
                    return false;
                }
                char letter = s.charAt(i);
                    if (letter == ')' && stack.peek() != '(' || letter == '}' && stack.peek() != '{' || letter == ']' && stack.peek() != '[') {
                        return false;
                    }
                stack.pop();
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        String  s = "(}";
        System.out.println(isValid(s));
    }
}
