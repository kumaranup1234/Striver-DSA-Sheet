package BinarySearch;

import java.util.ArrayList;

public class bookAllocation {
    // Brute Sol Linear search one
    // T.C O(n*(sum-max-1))
    public static int findPagesBrute(ArrayList<Integer> arr, int n, int m) {
        if(m > n){
            return -1;
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr.get(i);
            max = Math.max(max, arr.get(i));
        }

        for (int i = max; i <= sum; i++) {
            if (helper(arr, i) == m){
                return i;
            }
        }
        return -1;
    }
    // optimized
    // Binary search one
    // T.C O(log(sum-max+1)*O(N))
    public static int findPagesOptimized(ArrayList<Integer> arr, int n, int m) {
        if(m > n){
            return -1;
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr.get(i);
            max = Math.max(max, arr.get(i));
        }
        int right = sum;
        int left = max;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (helper(arr, mid) > m){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }
    private static int helper(ArrayList<Integer> arr, int pages) {
        int student = 1;
        int pageCount = 0;

        for (int i = 0; i < arr.size(); i++) {
            if (pageCount + arr.get(i) <= pages) {
                pageCount += arr.get(i);
            }else{
                student++;
                pageCount = arr.get(i);
            }
        }
        return student;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(12);
        arr.add(34);
        arr.add(67);
        arr.add(90);
        int n = arr.size();
        int m = 2;
        System.out.println(findPagesBrute(arr, n, m));
        System.out.println(findPagesOptimized(arr, n, m));
    }
}
