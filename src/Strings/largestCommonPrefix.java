package Strings;

import java.util.Arrays;

public class largestCommonPrefix {
    // T.C O(nlog(n) + O(min(first.length, second.length))
    public static String longestCommon(String[] strs) {
        Arrays.sort(strs);
        String first = strs[0];
        String second = strs[strs.length - 1];
        int i = 0;
        int j = 0;
        while (i < first.length() && j < second.length()) {
            if (first.charAt(i) == second.charAt(j)) {
                i++;
                j++;
            }else{
                break;
            }

        }
        return first.substring(0, j);
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommon(strs));
    }
}
