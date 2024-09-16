package Array;

public class islandPerimeter {
     // Time Complexity O(N*M)
    public static int islandPerimeterSol(int[][] grid) {
        int perimeter = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    perimeter += 4;
                    if (j < m - 1 && grid[i][j + 1] == 1) {
                        perimeter--;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        perimeter--;
                    }
                    if (i < n - 1 && grid[i + 1][j] == 1) {
                        perimeter--;
                    }
                    if (i > 0 && grid[i - 1][j] == 1) {
                        perimeter--;
                    }
                }
            }
        }
        return perimeter;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        // 16
        System.out.println(islandPerimeterSol(grid));
    }
}
