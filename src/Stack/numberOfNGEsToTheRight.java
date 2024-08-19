package Stack;

import java.util.Arrays;

// T.C O(n * queries)

public class numberOfNGEsToTheRight {
    public static int[] count_NGEs(int N, int[] arr, int queries, int[] indices) {
        int[] res = new int[queries];
        for (int i = 0; i < queries; i++) {
            res[i] = 0;
            int count = 0;
            int element = arr[indices[i]];
            for (int j = indices[i]; j < arr.length; j++) {
                if (element < arr[j]) {
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 7, 5, 8, 10, 6};
        int[] indices = {0, 5};
        int queries = 2;
        int n = arr.length;
        System.out.println(Arrays.toString(count_NGEs(n, arr, queries, indices)));

    }
}
