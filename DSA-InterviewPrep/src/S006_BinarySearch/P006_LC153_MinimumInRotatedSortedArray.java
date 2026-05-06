package S006_BinarySearch;
//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
public class P006_LC153_MinimumInRotatedSortedArray {
    public static void main(String[] args){
        //call from here...
    }

    //Approach 1- using linear search approach
    public static int findMinUsingLinearApproach(int[] nums) {
        int n = nums.length;
        int mini = Integer.MAX_VALUE;

        for(int ind = 0; ind <n ; ind++){
            mini = Math.min(mini, nums[ind]);
        }

        return mini;
    }
    //Approach 2 - using binary search approach
    public static int findMin(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int mini = Integer.MAX_VALUE;

        if(nums[low] < nums[high])  return nums[low];

        while(low <= high){
            int mid = (low + high)/2;
            if(nums[low] <= nums[mid]){
                mini = Math.min(mini, nums[low]);
                low = mid + 1;
            }
            else {
                mini = Math.min(mini, nums[mid]);
                high = mid - 1;
            }

        }

        return mini;
    }
}
