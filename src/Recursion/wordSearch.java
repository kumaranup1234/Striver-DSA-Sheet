package Recursion;

import java.util.Objects;

public class wordSearch {
    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    // If the word is found starting from this cell, return true
                    if (recurse(board, word, 0, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean recurse(char[][] board, String word, int index, int i, int j) {
        // match cases
        if (index == word.length()) {
            return true;
        }


        // out of bound cases
        if (i > board.length - 1 || i < 0 || j > board[0].length - 1 || j < 0 || board[i][j] != word.charAt(index)) {
            return false;
        }

        // temporary mark visited

        char temp = board[i][j];
        board[i][j] = '#';

        // calls for right , left, top, bottom
        boolean found = recurse(board, word, index+1, i - 1, j) ||
                recurse(board, word, index+1, i + 1, j) ||
                recurse(board, word, index+1, i, j - 1) ||
                recurse(board, word, index+1, i, j + 1);

        // mark unvisited
        board[i][j] = temp;
        return found;
    }



    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }
}
