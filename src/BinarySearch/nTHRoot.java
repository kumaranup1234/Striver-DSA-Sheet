package BinarySearch;

public class nTHRoot {
    public static int NthRoot(int n, int m) {
        if (m == 1) {
            return 1;
        }

        int left = 1;
        int right = m;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int value = helper(n, mid, m);
            if (value == 0) {
                return mid;
            } else if (value > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static int helper(int n, int mid, int m) {
        long ans = 1;
        for (int i = 0; i < n; i++) {
            ans *= mid;
            if (ans > m) {
                return 1; // mid^n is greater than m
            }
        }
        if (ans == m) {
            return 0; // mid^n is exactly m
        } else {
            return -1; // mid^n is less than m
        }
    }

    public static void main(String[] args) {
        int n = 2;
        int m = 9;
        System.out.println(NthRoot(n, m)); // Expected output is 3
    }
}
