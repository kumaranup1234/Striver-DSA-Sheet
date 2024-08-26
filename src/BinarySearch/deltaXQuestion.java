package BinarySearch;

import java.util.Arrays;
// bs optimization problem
// bs min max problem
// for th given room numbers and the number of room k
// find the largest minimum distance they need to maintain so that k room can be opened

public class deltaXQuestion {
    public static int binarySearch(int n, int k, int[] arr){
        if(k > n){
            return -1;
        }

        Arrays.sort(arr);
        int left = 1;
        int right = arr[n-1];

        while(left <= right){
            int mid = left + (right - left)/2;
            if (helper(mid, k, arr)){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return right;
    }
    public static boolean helper(int mid, int k, int[] arr){
        int count = 1;
        int position = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - position >= mid){
                count++;
                position = arr[i];
            }
            if (count == k){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        int[] arr = {1,2,4,8,9};
        System.out.println(binarySearch(n, k, arr));
    }
}
