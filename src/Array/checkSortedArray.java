package Array;

// Easy
// Array is in non-decreasing order
// Time Complexity O(N)

public class checkSortedArray {
    public static int isSorted(int n, int []arr) {
        if (n == 0){
            return 1;
        }
        for (int i = 0, k = 0; i < n - 1 && k < n -1; i++, k++) {
            if (arr[i+1] < arr[k]){
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,2,4,5};
        int n = arr.length;
        System.out.println(isSorted(n, arr));
    }
}
