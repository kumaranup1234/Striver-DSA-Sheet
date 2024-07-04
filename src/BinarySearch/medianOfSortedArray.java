package BinarySearch;

public class medianOfSortedArray {
    // T.C O(m+n)
    // not the optimized one
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int i = 0;
        int j = 0;
        int length = m + n;
        int ind2 = length / 2;
        int ind1 = ind2 - 1;
        int ind1El = -1;
        int ind2El = -1;
        int count = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                if (count == ind1) {
                    ind1El = nums1[i];
                }
                if (count == ind2) {
                    ind2El = nums1[i];
                }
                count++;
                i++;
            } else {
                if (count == ind2) {
                    ind2El = nums2[j];
                }
                if (count == ind1) {
                    ind1El = nums2[j];
                }
                count++;
                j++;
            }
        }
        while (i < m){
            if (count == ind1) {
                ind1El = nums1[i];
            }
            if (count == ind2) {
                ind2El = nums1[i];
            }
            count++;
            i++;
        }

        while (j < n){
            if (count == ind2) {
                ind2El = nums2[j];
            }
            if (count == ind1) {
                ind1El = nums2[j];
            }
            count++;
            j++;
        }
        if (length % 2 == 1){
            return ind2El;
        }
        return (double)(ind1El + ind2El) / 2.0;
    }
    // optimized sol using bs
    

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 7};
        int[] nums2 = {2, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
