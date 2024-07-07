package BinarySearch2DArray;

// the brute will be copy all the elements in an array and then sort
//the directly return the median as It's proved to be odd;

public class matrixMedian {
    // approach
    // The idea is that for a number to be median there should be exactly (n/2)
    // numbers which are less than this number.
    // So, we try to find the count of numbers less than all the numbers.

    // T.C O(log(maxElem−minElem)⋅r * log c)
    public static int median(int[][] matrix, int r, int c) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for(int i = 0; i < matrix.length; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][c-1]);
        }
        int required = ( r * c ) / 2;

        while(low <= high) {
            int mid = (low + high) / 2;
            int smallEqualElements = countElements(matrix, mid, r, c);
            if(smallEqualElements <= required) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return low;
    }

    private static int countElements(int[][] matrix, int element, int row, int col) {
        int count = 0;
        for(int i = 0; i < row; i++) {
            count += upperBound(matrix[i], element, col);
        }
        return count;
    }
    private static int upperBound(int[] matrix, int element, int col) {
        int low = 0;
        int high = col - 1;
        int ans = col;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(matrix[mid] > element) {
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int r = 3, c = 3;
        int[][] matrix = {{1, 3, 5},
                {2, 6, 9},
                {3, 6, 9}};
        System.out.println(median(matrix, r, c));
    }
}
