package Queue;

public class theCelebrityProblem {
    public static int celebrity(int mat[][]) {
        int n = mat.length;

        // find the candidate for celebrity
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            if (mat[candidate][i] == 1) {  // Candidate knows i, so i could be a celebrity
                candidate = i;
            }
        }

        // verify the candidate
        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                // Check if candidate knows no one, and everyone knows the candidate
                if (mat[candidate][i] == 1 || mat[i][candidate] == 0) {
                    return -1;
                }
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        int mat[][] = {
                {0, 1, 0},
                {0, 0, 0},
                {0, 1, 0}
        };

        int result = celebrity(mat);
        if (result == -1) {
            System.out.println("No celebrity found.");
        } else {
            System.out.println("Celebrity found at index: " + result);
        }
    }
}
