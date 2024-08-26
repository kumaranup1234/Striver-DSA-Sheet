package Recursion;

import java.util.Arrays;

public class puzzleMasterOfPuzzleVille {
    public static int findMagicNumber(int n, int k, int[] arr) {
        // sort the array
        Arrays.sort(arr);
        return find(k, arr, 0, 0);
    }

    public static int find(int k, int[] arr, int index, int count) {
        // a valid set is found
        if (k == 0){
            return count + 1;
        }

        for (int i = index; i < arr.length; i++) {
            // i, is greater and i and i-1 element same means the number is appeared before
            if (i > index && arr[i] == arr[i-1]) {
                continue;
            }
            // current element exceeds k means we can move forward
            if (arr[i] > k){
                break;
            }
            // increase index and subtract the current element from k
            count = find(k-arr[i], arr, i+1, count);

        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr = {10, 1, 2, 7, 6, 1 ,5};
        int n = arr.length;
        int k = 8;
        System.out.println(findMagicNumber(n, k, arr));

    }
}
