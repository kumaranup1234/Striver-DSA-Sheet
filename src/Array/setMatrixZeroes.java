package Array;

import java.util.Arrays;

public class setMatrixZeroes {
    // brute force solution

    // Method 1: (Brute force)
    //-using another matrix (let's say it matrix2)
    //
    //we can copy all the elements of given matrix to matrix2
    //while traversing given matrix whenever we encounter 0, we will make the entire row and column of the matrix2 to 0
    //finally we can again copy all the elements of matrix2 to given matrix
    //Time: O((mn)∗(m+n)), Space: O(mn)O
    public static void setZeroesBrute(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] matrix2 = new int[m][n];

        for (int i = 0; i < m; i++) {
            System.arraycopy(matrix[i], 0, matrix2[i], 0, n);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0){
                    for (int k = 0; k < n; k++) {
                        matrix2[i][k] = 0;
                    }
                    for (int k = 0; k < m; k++) {
                        matrix2[k][j] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            System.arraycopy(matrix2[i], 0, matrix[i], 0, n);
        }
    }

    // better approach
    //we can use two separate arrays one for rows (rowsArray) and one for columns (colsArray) and initialize them to 1
    //while traversing the given matrix whenever we encounter 0 at (i,j), we will set rowsArray[i]=0 and colsArray[j]=0
    //After completion of step 2, again iterate through the matrix and for any (i,j), if rowsArray[i] or colsArray[j] is 0 then update matrix[i][j] to 0.
    //Time: O(mn), Space: O(m+n)

    public static void setZeroesBetter(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        int[] row = new int[m];
        int[] col = new int[n];

        Arrays.fill(row, 1);
        Arrays.fill(col, 1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0){
                    row[i] = 0;
                    col[j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] == 0 || col[j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // best approach
    // we can use the 0th row and 0th column of the given matrix itself instead of using
    // two separate arrays
    //first we will traverse the 0th row and 0th column of the given matrix and if
    // we encounter any 0 then we will set the isRow0/isCol0 variable to true which
    // indicates that the 0th row/0th column of the given matrix will become 0
    //next we will traverse the remaining matrix except 0th row and 0th column and
    // if we encounter any 0, we will make the corresponding row no. and column no.
    // equal to 0 in the 0th column and 0th row respectively
    //Now we will update the values of the matrix except first row and first column
    // to 0 if matrix[i][0]=0 or matrix[0][j]=0 for any (i,j).
    //finally we will traverse the 0th row and 0th column and if we find any 0, we will
    // make the whole row and whole column equal to 0
    //Time: O(mn), Space: O(1)

    public static void setZeroesBest(int[][] matrix){
        int m=matrix.length;
        int n=matrix[0].length;
        boolean isRow0=false;
        boolean isCol0=false;

        for(int j=0;j<n;j++){
            if(matrix[0][j]==0)
                isRow0=true;
        }

        for(int i=0;i<m;i++){
            if(matrix[i][0]==0)
                isCol0=true;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[0][j]==0 || matrix[i][0]==0)
                    matrix[i][j]=0;
            }
        }

        if(isRow0){
            for(int j=0;j<n;j++)
                matrix[0][j]=0;
        }

        if(isCol0){
            for(int i=0;i<m;i++)
                matrix[i][0]=0;
        }

    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,1,1},
                {1,0,1},
                {1,1,1}};
        setZeroesBrute(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
