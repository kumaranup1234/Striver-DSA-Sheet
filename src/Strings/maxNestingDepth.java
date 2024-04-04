package Strings;

// 1614. Maximum Nesting Depth of the Parentheses

public class maxNestingDepth {
    public static int maxDepth(String s) {
        int count = 0;
        int maxCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
            }

            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
        System.out.println(maxDepth(s));
    }
}
