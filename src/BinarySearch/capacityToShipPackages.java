package BinarySearch;

public class capacityToShipPackages {
    public static int shipWithinDays(int[] weights, int days) {
        int min = Integer.MIN_VALUE;
        int max = 0;

        for (int weight : weights) {
            min = Math.max(min, weight);
            max = max + weight;
        }
        int left = min;
        int right = max;

        while (left < right){
            int mid = (right + left) / 2;
            if (isPossible(weights, days, mid)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean isPossible(int[] weights, int days, int capacity) {
        int sum = 0;
        for (int weight : weights) {
            if (sum + weight > capacity) {
                days--;
                sum = 0;
            }
            sum += weight;
            if (days <= 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        System.out.println(shipWithinDays(weights, days));
    }
}
