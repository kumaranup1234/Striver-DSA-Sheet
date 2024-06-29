package BinarySearch;

public class KthMissingPositive {
    // O(N) sol
    public static int findKthPositive(int[] arr, int k) {
        int j = 0;
        int count = 0;
        for (int i = 1; ; i++) {
            if (count == k) {
                return i - 1;
            }
            if (j < arr.length && i == arr[j]) {
                j++;
            } else {
                count++;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {2,3,4,7,11};
        int k = 5;
        System.out.println(findKthPositive(arr, k));
    }
}
