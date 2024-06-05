package BinarySearch;

public class squareRoot {
    public static long floorSqrt(long x) {
        if (x == 1){
            return x;
        }

        long left = 0;
        long right = x;
        while (left <= right){
            long mid = left + (right - left) / 2;
            if (mid * mid == x){
                return mid;
            } else if (mid * mid < x){
                right = mid - 1;
            } else{
                left = mid + 1;
            }
        }
        return (long) Math.floor(Math.sqrt(x));
    }

    public static void main(String[] args) {
        long x = 5;
        System.out.println(floorSqrt(x));
    }
}
