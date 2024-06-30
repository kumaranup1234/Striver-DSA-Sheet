package BinarySearch;


public class painterPartition {
    // brute force
    public static int findLargestMinDistance(int[] boards, int k) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int i = 0; i < boards.length; i++) {
            low = Math.max(low, boards[i]);
            high = high + boards[i];
        }

        for (int i = low; i <= high; i++) {
            int value = helper(boards, i);
            if (value == k) {
                return i;
            }
        }
        return low;
    }
    // optimized sol
    public static long findLargestMinDistanceOptimized(int[] boards, int k) {
        long low = 0;
        long high = 0;
        for (int i = 0; i < boards.length; i++) {
            low = Math.max(low, boards[i]);
            high = high + boards[i];
        }

        while (low <= high) {
            long mid = low + (high - low) / 2;
            long value = helper(boards, mid);
            if (value > k) {
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return low;
    }


    private static int helper(int[] boards, long time) {
        int painters = 1;
        long sum = 0;
        for (int i = 0; i < boards.length; i++) {
            if (sum + boards[i] <= time) {
                sum += boards[i];
            }else {
                painters++;
                sum = boards[i];
            }
        }
        return painters;
    }

    public static void main(String[] args) {
        int[] boards = new int[]{2,1,5,6,2,3};
        int k = 2;
        System.out.println(findLargestMinDistance(boards, k));
        System.out.println(findLargestMinDistanceOptimized(boards, k));
    }
}
