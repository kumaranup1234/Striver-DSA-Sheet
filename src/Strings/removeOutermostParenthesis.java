package Strings;

// Primitive string will have equal number of opened and closed parenthesis.
//opened count the number of opened parenthesis.
//Add every char to the result,
//unless the first left parenthesis,
//and the last right parenthesis.
public class removeOutermostParenthesis {
    public static String removeOuterParentheses(String S) {
        StringBuilder s = new StringBuilder();
        int opened = 0;
        for (char c : S.toCharArray()) {
            if(c == '(') {
                if(opened > 0) s.append(c);
                opened++;
            } else {
                if(opened > 1) s.append(c);
                opened--;
            }
        }
        return s.toString();
    }

    public static void main(String[] args) {
       String s = "(()())(())";
        System.out.println(removeOuterParentheses(s));
    }
}
