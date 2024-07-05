package BinarySearch2DArray;

public class searchIn2DMatrix {
    // T.C O(n + log(m)
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        int ansRow = -1;
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] <= target && matrix[i][col - 1] >= target) {
                ansRow = i;
                break;
            }
        }
        if (ansRow == -1) {
            return false;
        }

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
    // more optimized bs approach
    // T.C O(log(m*n))

    public static boolean searchMatrixOptimized(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int low = 0;
        // This high will be the last index of the 2d array
        int high = rows * cols - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            // this is the main part the value part
            // the formula for finding the element index in the 2d array
            int midValue = matrix[mid / cols][mid % cols];  // Convert mid-index to 2D indices

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        int [][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        System.out.println(searchMatrix(matrix, target));
        System.out.println(searchMatrixOptimized(matrix, target));
    }
}
