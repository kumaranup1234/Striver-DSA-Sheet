package Array;
import java.util.Arrays;

public class RotateImage {
    // brute force solution
    // Time Complexity O(m*n)
    // Space Complexity O(m*n)
    public static int[][] bruteForce(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] ans = new int[m][n];
        int row;
        int col;

        for (int i = 0; i < m; i++) {
            row = 0;
            col = n-1;
            col = col - i;
            for (int j = 0, k = 0; j < n && k < m; j++, k++) {
                ans[row+k][col] = matrix[i][j];
            }
        }
        return ans;
    }


    /*
    two steps
    1. transpose the matrix
    2. reverse every element of row

    now why transpose -> bcz we can see that 1st column is the 1st row of ans matrix
    so that's why we transposed it.

    and reverse to make it in the order

    Time Complexity O(N*M)
    Space Complexity O(1)
    have done in place
     */

    public static int[][] optimizedApproach(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            // we have to ignore the middle element's, and also we are
            // only traversing the upper part of diagonal
            for (int j = i+1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        System.out.println(Arrays.deepToString(matrix));

        for (int[] row : matrix) {
            reverseArray(row);
        }
        return matrix;
    }

    public static void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}};
        System.out.println(Arrays.deepToString(bruteForce(matrix)));
        System.out.println(Arrays.deepToString(optimizedApproach(matrix)));
    }
}
