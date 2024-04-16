package BinarySearch;

import java.util.Arrays;

public class floorAndCeil {
    public static int[] getFloorAndCeil(int[] arr, int n, int x) {
        int low = 0;
        int high = n - 1;
        int[] ans = {-1, -1};
        boolean ceilUpdated = false;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == x) {
                ans[0] = ans[1] = arr[mid];
                return ans;
            } else if (arr[mid] < x) {
                ans[0] = arr[mid];
                low = mid + 1;
            } else {
                if (!ceilUpdated || arr[mid] < ans[1]) {
                    ans[1] = arr[mid];
                    ceilUpdated = true;
                }
                high = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 7, 8, 8, 10};
        int x = 5;
        int n = arr.length;
        System.out.println(Arrays.toString(getFloorAndCeil(arr, n, x)));
    }
}

