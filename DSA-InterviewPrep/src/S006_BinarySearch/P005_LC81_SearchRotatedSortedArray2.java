package S006_BinarySearch;
//https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
public class P005_LC81_SearchRotatedSortedArray2 {
    public static void main(String[] args){
        //call from here...
    }

    //Approach 1 - using linear search approach
    public static boolean searchUsingLinearApproach(int[] nums, int target) {
        int n = nums.length;
        for(int ind = 0; ind < n; ind++){
            if(nums[ind] == target) return true;
        }

        return false;
    }
}
