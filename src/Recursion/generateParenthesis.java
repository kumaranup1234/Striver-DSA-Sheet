package Recursion;

import java.util.ArrayList;
import java.util.List;

// visit this link for more understanding
// https://leetcode.com/problems/generate-parentheses/solutions/2542620/python-java-w-explanation-faster-than-96-w-proof-easy-to-understand/

public class generateParenthesis {
    public static List<String> generateParenthesisSol(int n) {
        List<String> res = new ArrayList<>();
        reverse(res, 0, 0, "", n);
        return res;
    }
    public static void reverse(List<String> res, int left, int right, String parenthesis, int n) {
        if (parenthesis.length() == n * 2) {
            res.add(parenthesis);
            return;
        }

        if (left < n){
            reverse(res, left + 1, right, parenthesis + '(', n);
        }

        if (right < left){
            reverse(res, left, right + 1, parenthesis + ')', n);
        }

    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println(generateParenthesisSol(n));
    }
}
