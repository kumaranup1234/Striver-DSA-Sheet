package BinarySearch;

// implement the bs approach

public class KthElementOfArray {
    // T.C O(m+n)
    // can be improved by using the bs approach like of median one but i am not getting that in
    // my mind will visit again
    public static long kthElement(int[] arr1, int[] arr2, int n, int m, int k) {
        int i = 0;
        int j = 0;
        long element = -1;
        long count = 0;
        while (i < n && j < m) {
            if (element != -1) {
                return element;
            }
            if (arr1[i] < arr2[j]) {
                if (count == k-1) {
                    element = arr1[i];
                }
                count++;
                i++;
            } else {
                if (count == k-1) {
                    element = arr2[j];
                }
                count++;
                j++;
            }
        }
        while (i < n){
            if (count == k-1) {
                element = arr1[i];
            }
            count++;
            i++;
        }

        while (j < m){
            if (count == k-1) {
                element = arr2[j];
            }
            count++;
            j++;
        }
        return element;
    }


    public static void main(String[] args) {
        int[] arr1 = {2, 3, 6, 7, 9};
        int[] arr2 = {1, 4, 8, 10};
        int k = 5;
        System.out.println(kthElement(arr1, arr2, arr1.length, arr2.length, k));
    }
}
