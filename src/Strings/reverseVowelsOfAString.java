package Strings;

import java.util.HashSet;

public class reverseVowelsOfAString {
    public static String reverseVowels(String s) {
        int i = 0;
        int j = s.length() - 1;
        HashSet<Character> hashSet = new HashSet<>();
        hashSet.add('a');
        hashSet.add('e');
        hashSet.add('i');
        hashSet.add('o');
        hashSet.add('u');
        hashSet.add('A');
        hashSet.add('E');
        hashSet.add('I');
        hashSet.add('O');
        hashSet.add('U');

        char[] arr = s.toCharArray();

        while (i < j) {
            if (hashSet.contains(arr[i]) && hashSet.contains(arr[j])) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
            if (!hashSet.contains(arr[i])){
                i++;
            }
            if (!hashSet.contains(arr[j])){
                j--;
            }
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        String s = "IceCreAm";
        System.out.println(reverseVowels(s));
    }
}
