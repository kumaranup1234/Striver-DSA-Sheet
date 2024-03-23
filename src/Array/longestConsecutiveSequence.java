package Array;


import java.util.HashSet;

// idea is to first add all the elements or convert them into stream of numbers
// so that we can check whether the number we encountered is the starting of streak or not
// we can check whether a number is starting of a streak by checking if x - 1 exists or not
// if not we can check for x+!, x+2, x+3, x+4 and so on while maintaining the count of the longest
// subsequence

// Time Complexity O(N) bcz at max we will be traversing whole array once only
// Space Complexity O(N)
public class longestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        int currCount;
        int maxCount = 0;
        int next;

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int i = 0; i < nums.length; i++) {
            currCount = 0;
            if (!set.contains(nums[i]-1)){
                next = nums[i];
                while (set.contains(next)){
                    currCount++;
                    next = next + 1;
                }
            }
            maxCount = Math.max(maxCount, currCount);
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }
}
