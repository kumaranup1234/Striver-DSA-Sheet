package Recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// T.C O(N!*N) we are trying every possibilities
// S.C O(N*N)

// one optimization is there but this code looks clean
public class nQueen {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        int[] leftRow = new int[n];
        // imp formulas for the size of the required array
        int[] upperDiagonal = new int[2 * n - 1];
        int[] lowerDiagonal = new int[2 * n - 1];
        solve(res, board, 0);
        solveOptimized(res, board, 0, leftRow, upperDiagonal, lowerDiagonal);
        return res;
    }

    public static void solve(List<List<String>> res, char[][] board, int col){
        if(col == board.length){
            res.add(construct(board));
            return;
        }

        for(int row = 0; row < board.length; row++){
            if (validate(board, row, col)){
                board[row][col] = 'Q';
                solve(res, board, col+1);
                board[row][col] = '.';
            }
        }
    }


    // by doing this we saved the tine for running the three loops
    static void solveOptimized(List<List<String>> res, char[][] board, int col, int[] leftRow, int[] upperDiagonal, int[] lowerDiagonal){
        if(col == board.length){
            res.add(construct(board));
            return;
        }
        // here also the formulas for the respective places
        for(int row = 0; row < board.length; row++){
            if(leftRow[row] == 0 && lowerDiagonal[row+col] == 0 && upperDiagonal[board.length - 1 + col - row] == 0){
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row+col] = 1;
                upperDiagonal[board.length - 1 + col - row] = 1;
                solveOptimized(res, board, col+1, leftRow, upperDiagonal, lowerDiagonal);
                board[row][col] = '.';
                leftRow[row] = 0;
                upperDiagonal[board.length - 1 + col - row] = 0;
                lowerDiagonal[row+col] = 0;
            }
        }

    }

    static boolean validate(char[][] board, int row, int col){
        // three possible places to check
        // only need to check till now placed so before as after that queens have not been placed yet
        int dupRow = row;
        int dupCol = col;

        // upper diagonal

        while (row >= 0 && col >= 0){
            if (board[row][col] == 'Q'){
                return false;
            }
            row--;
            col--;
        }

        row = dupRow;
        col = dupCol;
        // straight

        while (col >= 0){
            if (board[row][col] == 'Q'){
                return false;
            }
            col--;
        }

        row = dupRow;
        col = dupCol;
        // lower diagonal

        while (row < board.length && col >= 0){
            if (board[row][col] == 'Q'){
                return false;
            }
            col--;
            row++;
        }
        return true;
    }

    static List <String> construct(char[][] board) {
        List <String> res = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            System.out.println(s);
            res.add(s);
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(solveNQueens(n));
        System.out.println(solveNQueens(n));
    }
}
