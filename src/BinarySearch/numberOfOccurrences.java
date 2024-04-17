package BinarySearch;

public class numberOfOccurrences {
    public static int count(int[] arr, int n, int x) {
        int end = -1;
        int start = -1;
        int low = 0;
        int high = n - 1;

        // Search left
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                start = mid;
                high = mid - 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        low = 0;

        // Search right
        high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                end = mid;
                low = mid + 1;
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if(start != -1){
            return end - start + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 4, 10, 10, 10, 10, 10, 10, 11, 12, 14, 14, 17, 19, 19  };
        int n = arr.length;
        int x = 10;
        System.out.println(count(arr, n, x));
    }
}
