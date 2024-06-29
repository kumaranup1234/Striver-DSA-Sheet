package BinarySearch;

import java.util.Arrays;


public class aggressiveCows {
    // linear search sol
    // Time Complexity O(NLogN) + O(N *(max(stalls[])-min(stalls[])))
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int limit = stalls[n-1] - stalls[0];
        for (int i = 0; i <= limit; i++) {
            if (!isPossible(i, k, stalls)){
                return i- 1;
            }
        }
        return limit;
    }
    private static boolean isPossible(int dist, int cows, int[] stalls) {
       int n = stalls.length;
       int cowsCount = 1;
       int last = stalls[0];
        for (int j = 0; j < n; j++) {
            if (stalls[j] - last >= dist){
                cowsCount++;
                last = stalls[j];
            }
        }
        if (cowsCount >= cows){
            return true;
        }
        return false;
    }

    // binary search sol
    // Time Complexity O(NlogN) + O(N * log(max(stalls[])-min(stalls[])))
    public static int binarySol(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int right = stalls[n-1] - stalls[0];
        int left = 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (isPossible(mid, k, stalls)){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return right;
    }


    public static void main(String[] args) {
        int[] stalls = {1 ,2, 4, 8, 9};
        int k = 3;
        int n = stalls.length;
        System.out.println(solve(n, k, stalls));
        System.out.println(binarySol(n, k, stalls));
    }
}
