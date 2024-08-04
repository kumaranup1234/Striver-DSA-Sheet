package Recursion;

public class perfectSumProblem {
    // recursion approach took more give got tle
    // have to optimize it using dp
    public int perfectSum(int[] arr,int n, int sum) {
        return count(arr, sum, n, 0);
    }
    public static int count (int[] arr, int sum, int n, int index){
        if (index == n){
            if (sum == 0){
                return 1;
            }
            return 0;
        }

        int includeCount = count(arr, sum- arr[index], n, index+1);
        int excludeCount = count(arr, sum, n, index+1);
        return includeCount + excludeCount;
    }
}
