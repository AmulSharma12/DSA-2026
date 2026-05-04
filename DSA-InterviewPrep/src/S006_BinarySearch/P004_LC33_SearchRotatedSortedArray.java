package S006_BinarySearch;
//https://leetcode.com/problems/search-in-rotated-sorted-array/description/
public class P004_LC33_SearchRotatedSortedArray {
    public static void main(String[] args){
        //call from here...
    }

    //Approach 1 - using linear search approach
    public static int searchLinear(int[] nums, int target) {
        int n = nums.length;

        for(int ind = 0; ind < n; ind++){
            if(nums[ind] == target) return ind;
        }

        return -1;
    }
}
