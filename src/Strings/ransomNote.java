package Strings;

import java.util.HashMap;

public class ransomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> ransomMap = new HashMap<>();
        HashMap<Character, Integer> magazineMap = new HashMap<>();

        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            ransomMap.put(ch, ransomMap.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);
            magazineMap.put(ch, magazineMap.getOrDefault(ch, 0) + 1);
        }

        for (char ch : ransomMap.keySet()) {
            int needed = ransomMap.get(ch);
            int available = magazineMap.getOrDefault(ch, 0);

            if (available < needed) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String ransomNote = "a", magazine = "b";
        System.out.println(canConstruct(ransomNote, magazine));
    }
}
