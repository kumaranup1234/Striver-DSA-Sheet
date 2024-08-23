package Stack;

import java.util.Arrays;
import java.util.Stack;

public class asteroidCollision {
    public static int[] asteroidCollisionSol(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        int n = asteroids.length;

       for (int i = 0; i < n; i++) {
           boolean alive = true;
           while(alive && !s.empty() && asteroids[i] < 0 && s.peek() > 0){
               if(-asteroids[i] > s.peek()){
                   s.pop();
               } else if (-asteroids[i] == s.peek()) {
                   s.pop();
                   alive = false;
               }else if (-asteroids[i] < s.peek()) {
                   alive = false;
               }
           }
           if (alive){
               s.push(asteroids[i]);
           }
       }

        int[] res = new int[s.size()];
        for (int i = s.size() - 1; i >= 0; i--) {
            res[i] = s.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        // 10
        int[] asteroids = {10, 2, -5};
        System.out.println(Arrays.toString(asteroidCollisionSol(asteroids)));
    }
}
