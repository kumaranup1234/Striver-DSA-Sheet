package BinarySearch;

public class findPeakElement {
    // the brute sol will be the linear search by checking the left and right
    /*
    for(int i = 0; i < nums.length; i++){
    if((i == 0 || arr[i-1) < arr[i]) && (i == nums.length -1 || arr[i+1) < arr[i])){
    return true;
    }
    return -1;
     */

    // think of like this
    // -infinity [1, 3, 4, 5] - infinity
    public static int findPeak(int[] nums) {
        // if only one element is present
        if (nums.length == 0){
            return 0;
        }

        // other edge case
        // where 0th element is greater than the 1st element
        if (nums[0] > nums[1]){
            return 0;
            // or the last element is greater than its previous element
            // as there are many peak we want only one
        }else if (nums[nums.length - 1] > nums[nums.length - 2]){
            return nums.length - 1;
        }

        int low  =1;
        int high = nums.length-2;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] > nums[mid - 1]) {
                low = mid + 1;
            } else if (nums[mid] > nums[mid + 1]) {
                high = mid - 1;
            }else{
                // we can do anything either go left or right
                low = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(findPeak(nums));
    }
}
