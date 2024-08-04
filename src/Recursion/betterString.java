package Recursion;

import java.util.HashMap;
import java.util.Map;

public class betterString {
    public static String betterStringSol(String str1, String str2) {
        int count1 = countSubstrings(str1);
        int count2 = countSubstrings(str2);
        if(count1 == count2){
            return str1;
        }
        return count1 > count2 ? str1 : str2;
    }

    public static int countSubstrings(String str) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 1;
        for (int i = 0; i < str.length(); i++) {
            int newCount = 2 * count;

            if (map.containsKey(str.charAt(i))) {
                newCount = newCount - map.get(str.charAt(i));
            }

            map.put(str.charAt(i), newCount);
            count = newCount;
        }
        return count;
    }

    public static void main(String[] args) {
        String str1 = "gfg", str2 = "ggg";
        System.out.println(betterStringSol(str1, str2));
    }
}
