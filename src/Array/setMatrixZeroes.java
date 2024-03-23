package Array;

import java.util.Arrays;

public class setMatrixZeroes {
    public static void setZeroes(int[][] matrix) {


    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,1,1},
                {1,0,1},
                {1,1,1}};
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
