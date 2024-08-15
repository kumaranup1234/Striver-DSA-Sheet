package Recursion;

import java.util.ArrayList;
import java.util.Collections;

// T.C O(2^(n*n))
// S.C O(n * n)
public class ratInAMaze1 {
    public static ArrayList<String> findPath(int[][] mat) {
        ArrayList<String> res = new ArrayList<>();
        if(mat == null || mat.length == 0 || mat[0][0] == 0) {
            return res;
        }
        int n = mat.length;
        StringBuilder path = new StringBuilder();
        boolean[][] visited = new boolean[n][n];
        path(mat, res, path, visited, 0, 0);
        Collections.sort(res);
        return res;
    }

    public static void path(int[][] mat, ArrayList<String> res, StringBuilder path, boolean[][] visited,  int i, int j) {
        if (i == mat.length - 1 && j == mat.length - 1) {
            res.add(path.toString());
            return;
        }

        visited[i][j] = true;

        // UP
        if (isSafe(mat, visited, i-1, j)) {
            path.append('U');
            path(mat, res, path, visited, i-1, j);
            path.deleteCharAt(path.length()-1);
        }

        // Down

        if (isSafe(mat, visited, i+1, j)) {
            path.append('D');
            path(mat, res, path, visited, i+1, j);
            path.deleteCharAt(path.length()-1);
        }

        // Left

        if (isSafe(mat, visited, i, j-1)) {
            path.append('L');
            path(mat, res, path, visited, i, j-1);
            path.deleteCharAt(path.length()-1);
        }

        // Right

        if (isSafe(mat, visited, i, j+1)) {
            path.append('R');
            path(mat, res, path, visited, i, j+1);
            path.deleteCharAt(path.length()-1);
        }

        visited[i][j] = false;
    }

    public static boolean isSafe(int[][] mat, boolean[][] visited,  int row, int col) {
        int n = mat.length;

        return (row >= 0 && row < n && col >= 0 && col < n && mat[row][col] == 1 && !visited[row][col]);
    }

    public static void main(String[] args) {
        int[][] mat = {
                {0, 1, 1, 1},
                {1, 1, 1, 0},
                {1, 0, 1, 1},
                {0, 0, 1, 1}
                ,};
 // -1
        System.out.println(findPath(mat));
    }
}
