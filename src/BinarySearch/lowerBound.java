package BinarySearch;

public class lowerBound {
    public static int lowerBoundSol(int[] arr, int n, int x) {
        int low = 0;
        int high = n - 1;
        int ans = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int upperBoundSol(int[] arr, int n, int x) {
        int low = 0;
        int high = n - 1;
        int ans = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= x) {
                low = mid + 1;
            } else if (arr[mid] > x){
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3};
        int n = arr.length;
        int x = 0;
        System.out.println(lowerBoundSol(arr, n, x));
    }
}
