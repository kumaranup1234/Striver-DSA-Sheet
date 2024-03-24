import java.util.HashMap;
import java.util.Map;

public class findTheDuplicateNumber {

    // not solved in constant space
    // Time is O(N)
    public static int findDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                return nums[i];
            }else{
                map.put(nums[i], 1);
            }
        }
        return -1;
    }

    //  can be solved in the constant space
    // more of a how we detect cycles in linked list
    // as the number are from 1 to n and n+1 values are there
    // we let value at each index point at another index
    // now use the floyd algo to find the meeting point in the cycle
    // now we will move the one pointer to start and do again this time]
    // increasing the both pointer once only and this time the point at which they meet
    // will be the required element as we are storing the elements in the array as indices

    public static int findDuplicateSpaceOptimized(int[] nums){
        int fast = nums[0];
        int slow = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = nums[0];
        while (fast != slow){
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicate(nums));
        System.out.println(findDuplicateSpaceOptimized(nums));
    }
}
