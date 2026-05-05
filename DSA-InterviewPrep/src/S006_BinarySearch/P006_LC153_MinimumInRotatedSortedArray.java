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
}
