package Array;

import java.util.Arrays;

public class missingAndRepeating {
    // the optimal approach will include the properties of
    // sum of numbers and the sum of the squares of that numbers
    public static int[] findTwoElement(int arr[], int n) {
        // Calculate the expected sum and sum of squares
        long sumN = (long) n * (n + 1) / 2;
        long sumSquaresN = (long) n * (n + 1) * (2 * n + 1) / 6;

        // Calculate the actual sum and sum of squares from the array
        long sumArr = 0;
        long sumSquaresArr = 0;

        for (int i = 0; i < n; i++) {
            sumArr += arr[i];
            sumSquaresArr += (long) arr[i] * arr[i];
        }

        // Compute S1 and S2
        long S1 = sumArr - sumN; // B - A
        long S2 = sumSquaresArr - sumSquaresN; // B^2 - A^2

        // Calculate B + A using S2 / S1
        long S3 = S2 / S1; // B + A

        // Calculate B and A
        long B = (S1 + S3) / 2;
        long A = (S3 - S1) / 2;

        // Return the result as an array with B (duplicate) first and A (missing) second
        return new int[]{(int) B, (int) A};
    }
    public static void main(String[] args) {
        int[] arr = {1,3,3};
        System.out.println(Arrays.toString(findTwoElement(arr, arr.length)));
    }
}
