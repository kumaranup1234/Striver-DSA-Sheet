package BinarySearch;

public class kokoEatingBanana {
    public static int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];

        for (int pile : piles) {
            if (pile > max) {
                max = pile;
            }
        }

        int left = 1;
        int right = max;
        while (left < right) {
            int mid = left + (right - left) / 2;
           if (helper(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


    public static boolean helper(int[] piles, int k, int h) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile + k - 1) / k;
            if (hours > h) {
                return false; // Early exit if hours exceed h
            }
        }
        return hours <= h;
    }

    public static void main(String[] args) {
        int[] piles = {312884470};
        int h = 312884469;

        // ans 2
        System.out.println(minEatingSpeed(piles, h));
    }
}
