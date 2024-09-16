package Strings;

public class longestPalindrome {
    public static int longestPalindromeSol(String s) {
        if (s.length() == 1) {
            return s.length();
        }

        // for handling upper case letter
        int[] charCount = new int[52];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                charCount[c - 'a']++;
            } else if (c >= 'A' && c <= 'Z') {
                charCount[c - 'A' + 26]++;
            }
        }

        int longest = 0;
        boolean hasOdd = false;

        for (int i = 0; i < charCount.length; i++) {
            if (charCount[i] % 2 == 0) {
                longest += charCount[i];
            } else {
                longest += charCount[i] - 1;
                hasOdd = true;
            }
        }
        if (hasOdd) {
            longest += 1;
        }

        return longest;
    }

    public static void main(String[] args) {
        String s = "bananas";
        System.out.println(longestPalindromeSol(s));
    }
}
