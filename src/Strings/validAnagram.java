package Strings;

public class validAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] characters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            characters[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            characters[t.charAt(i) - 'a']--;
        }

        for (int character : characters) {
            if (character != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ac", t = "bb";
        // false
        System.out.println(isAnagram(s, t));
    }
}
