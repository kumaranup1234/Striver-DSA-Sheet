package Strings;

public class rotateString {
    public static boolean rotateStringSol(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        String concat = goal + goal;
        return concat.contains(s);
    }

    public static void main(String[] args) {
        String s = "abcde", goal = "cdeab";
        System.out.println(rotateStringSol(s, goal));
    }
}
