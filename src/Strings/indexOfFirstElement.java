package Strings;

public class indexOfFirstElement {
    // brute approach
    // O(m*n)
    public static int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (helper(haystack, needle, i)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static boolean helper(String haystack, String needle, int start) {
        if (start + needle.length() > haystack.length()) {
            return false;
        }
        int j = 0;
        for (int i = start; i < start + needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            } else {
                return false;
            }
        }
        return true;
    }

    // KMP will be used to optimize the complexity to
    // O(m+n)

    public static int kmpSearch(String haystack, String needle) {
        int[] lps = buildLps(needle);
        int i = 0; // index for haystack
        int j = 0; // index for needle
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            if (j == needle.length()) {
                return (i - j);
            }
            // Mismatch after j matches
            if (i < haystack.length() && haystack.charAt(i) != needle.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];  // Use the LPS array to skip unnecessary comparisons
                } else {
                    i++;
                }
            }
        }
        return -1;
    }

    public static int[] buildLps(String needle) {
        int[] lps = new int[needle.length()];
        int len = 0;
        int i = 1;

        while (i < needle.length()) {
            // If characters match, extend the current longest prefix suffix
            if (needle.charAt(i) == needle.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len > 0) {
                    // If a mismatch occurs, reduce `len` to the previous valid LPS length
                    len = lps[len - 1];
                } else {
                    // // If `len` is 0, set lps[i] to 0 and move to the next character
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        String haystack = "sadbutsad", needle = "sad";
        System.out.println(strStr(haystack, needle));
        System.out.println(kmpSearch(haystack, needle));
    }
}
