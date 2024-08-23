package Stack;

import java.util.Stack;

public class removeKDigits {
    // T.C O(N)
    // S.C O(n)
    public static String removeKdigitsSol(String num, int k) {
        if (k == num.length()) {
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        int count = k;

        for (int i = 0; i < num.length(); i++) {
            while (!stack.isEmpty() && count > 0 && stack.peek() > num.charAt(i)) {
                stack.pop();
                count--;
            }
                stack.push(num.charAt(i));
        }

        while (count > 0) {
            stack.pop();
            count--;
        }

        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        res.reverse();

        while (res.length() > 0 && res.charAt(0) == '0'){
            res.deleteCharAt(0);
        }
        return res.length() == 0 ? "0" : res.toString();
    }

    public static void main(String[] args) {
        String s = "10";
        int k = 1;
        System.out.println(removeKdigitsSol(s, k));
    }
}
