package BinarySearch2DArray;

public class rowWithMax1s {
    // T.C O(n * log(m)
    public static int rowWithMax(int[][] arr, int n, int m) {
        int count = 0;
        int currCount = 0;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            currCount = m - helper(arr, i);
            if (currCount > count){
                count = currCount;
                ans = i;
            }
        }
        return ans;
    }

    public static int helper(int[][] arr, int i) {
        int low = 0;
        int high = arr[0].length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[i][mid] == 1){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int n = 4, m = 4;
        int[][] arr = {{0, 1, 1, 1},{0, 0, 1, 1},{1, 1, 1, 1},{0, 0, 0, 0}};
        System.out.println(rowWithMax(arr, n, m));
    }
}
