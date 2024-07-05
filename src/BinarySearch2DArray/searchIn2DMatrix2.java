package BinarySearch2DArray;

public class searchIn2DMatrix2 {
    // bs approach
    // T.C O(n * log(m))
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        for (int i = 0; i < row; i++) {
            if (binarySearch(matrix, target, i)) {
                return true;
            }
        }
        return false;
    }

    private static boolean binarySearch(int[][] matrix, int target, int ansRow) {
        int low = 0;
        int high = matrix[0].length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (matrix[ansRow][mid] == target) {
                return true;
            } else if (matrix[ansRow][mid] > target) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return false;
    }
    // optimized solution
    // T.C O(n+m)
    public static boolean searchMatrixOptimized(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;
        // we star from the rightmost corner not from the (0,0) bcz from zero
        // both the row and col wise elements is increasing
        // while in the rightmost one side increasing one side decreasing

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            }else{
                row++;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 5;
        System.out.println(searchMatrix(matrix, target));
        System.out.println(searchMatrixOptimized(matrix, target));
    }
}
