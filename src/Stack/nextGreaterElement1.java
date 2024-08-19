package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// https://leetcode.com/problems/next-greater-element-i/solutions/1579935/java-easy-solution-brute-and-optimal-stack-diagrammatic-explanation/
// if not able to think sol when revisiting then visit this link

// we are adding the elements in the stack
// till we the element which is greater than the top of the stack
// then we pop that element from the stack make the entry for that element as that will be
// the next greater for that element

// and at last for the nums1 we extract the mapping from the map for the element in the num1 and
// for the element for which mapping is not present we add -1
public class nextGreaterElement1 {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            while (!s.isEmpty() && s.peek() < nums2[i]) {
                map.put(s.pop(), nums2[i]);
            }
            s.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }
}
