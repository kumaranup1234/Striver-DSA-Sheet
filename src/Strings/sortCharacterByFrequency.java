package Strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class sortCharacterByFrequency {
    public static String frequencySort(String s) {
        // Step 1: Count the frequency of each character
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        // Step 2: Create an array of characters sorted by frequency
        Character[] characters = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            characters[i] = s.charAt(i);
        }
        //System.out.println(Arrays.toString(characters));
        // lambda expression (a, b) -> { ... } compares two characters a and b.

        // If the frequencies are equal (freqCompare == 0), return a.compareTo(b); sorts a and b alphabetically.
        //Otherwise, return freqCompare; sorts based on frequency in descending order.

        Arrays.sort(characters, (a, b) -> {
            int freqCompare = map.get(b).compareTo(map.get(a));
            if (freqCompare == 0) {
                return a.compareTo(b);
            }
            return freqCompare;
        });
        //System.out.println(Arrays.toString(characters));

        // Step 3: Build the result string
        StringBuilder sb = new StringBuilder();
        for (Character c : characters) {
            sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s));
    }
}
