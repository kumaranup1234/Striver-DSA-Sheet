package BinarySearch;

public class minimumDaysToMakeMBouquets {
    public static int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if ((long) m * k > n) {
            return -1; // Not enough flowers to make m bouquets
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int j : bloomDay) {
            if (j > max) {
                max = j;
            } else if (j < min) {
                min = j;
            }
        }

        int left = min;
        int right = max;

        while (left < right){
            int mid = (right + left) / 2;
            if (canMakeBouquets(bloomDay, m, k, mid)){
                right = mid;
            }else{
               left = mid + 1;
            }
        }
        return left;
    }

    private static boolean canMakeBouquets(int[] bloomDay, int m, int k, int day) {
        int bouquets = 0; // Number of bouquets made
        int flowers = 0;  // Number of consecutive bloomed flowers counted for the current bouquet

        // Loop through each flower in the bloomDay array
        for (int i = 0; i < bloomDay.length; i++) {
            // Check if the flower has bloomed by the given day
            if (bloomDay[i] <= day) {
                flowers++; // Increment the count of consecutive bloomed flowers

                // If we have enough flowers to make a bouquet
                if (flowers == k) {
                    bouquets++; // Increment the count of bouquets made
                    flowers = 0; // Reset the count for the next bouquet

                    // If we have made the required number of bouquets, return true
                    if (bouquets == m) {
                        return true;
                    }
                }
            } else {
                // If the current flower has not bloomed, reset the count of consecutive bloomed flowers
                // the sequence of adjacent bloomed flower is broken
                flowers = 0;
            }
        }

        // After the loop, check if we have made at least the required number of bouquets
        return bouquets >= m;
    }


    public static void main(String[] args) {
        int[] bloomDay = {1,10,3,10,2};
        int m = 3;
        int k = 2;
        // ans -1
        System.out.println(minDays(bloomDay, m, k));
    }
}
