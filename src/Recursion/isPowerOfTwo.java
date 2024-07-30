package Recursion;

public class isPowerOfTwo {
    public static boolean isPowerOfTwoSol(int n) {
        if(n == 1){
            return true;
        }else if(n % 2 == 1 || n == 0 || n < 0){
            return false;
        }else if(n % 2 == 0){
            return isPowerOfTwoSol(n/2);
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 16;
        System.out.println(isPowerOfTwoSol(n));
    }
}
