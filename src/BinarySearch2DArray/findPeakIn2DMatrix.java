package BinarySearch2DArray;

import java.util.Arrays;

//  see the peak element 1 graph to recall the concept

public class findPeakIn2DMatrix {
    // T.C O(log(m*n)
    public static int[] findPeakGrid(int[][] mat) {
        int[] ans = new int[2];
        int low = 0;
        int high = mat[0].length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int row = findRow(mat, mid);
            int left = mid - 1 >= 0 ? mat[row][mid-1] : -1; // its said
            int right = mid + 1 < mat[0].length ? mat[row][mid+1] : -1;
           if (mat[row][mid] > left && mat[row][mid] > right) {
               ans[0] = row;
               ans[1] = mid;
               return ans;
           } else if (mat[row][mid] < left ) {
               // there can be peak in this direction, so we are going left
               high = mid - 1;
           }else{
               // there can be peak in this direction, so we are going right
               low = mid + 1;
           }
        }
        return ans;
    }

    private static int findRow(int[][] mat, int row) {
        int maxValue = -1;
        int index = -1;
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][row] > maxValue) {
                maxValue = mat[i][row];
                index = i;
            }
        }
        return index;
    }


    public static void main(String[] args) {
        int[][] mat = {{1,4},{3,2}};
        System.out.println(Arrays.toString(findPeakGrid(mat)));
    }
}
