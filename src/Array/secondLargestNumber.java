package Array;

import java.util.Arrays;

// Easy
// Time Complexity O(N)

public class secondLargestNumber {
    public static int[] getSecondOrderElements(int n, int[] arr) {
        int large = Integer.MIN_VALUE;
        int second_large = Integer.MIN_VALUE;
        int small = Integer.MAX_VALUE;
        int second_small = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] > large)
            {
                second_large = large;
                large = arr[i];
            }
            else if (arr[i] > second_large && arr[i] != large)
            {
                second_large = arr[i];
            }

            if (arr[i] < small)
            {
                second_small = small;
                small = arr[i];
            }
            else if (arr[i] < second_small && arr[i] != small)
            {
                second_small = arr[i];
            }
        }
        return new int[]{second_large, second_small};
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        int n = a.length;
        System.out.println(Arrays.toString(getSecondOrderElements(n, a)));
    }
}
