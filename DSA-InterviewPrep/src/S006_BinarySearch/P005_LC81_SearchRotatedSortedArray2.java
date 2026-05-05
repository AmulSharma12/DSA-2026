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

    //Approach 2 - using binary search algorithim
    public static boolean searchBinarySearch(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n-1;

        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] == target) return true;

            //if all the element at ind - low/mid/high are equal shrink the window
            if(nums[low] == nums[mid] && nums[mid] == nums[high])   {
                low++;
                high--;
                continue;
            }


            if(nums[low] <= nums[mid]){
                //left part sorted
                if(nums[low] <= target && target <= nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }else{
                //right part sorted
                if(nums[mid] <= target && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid -1;
            }
        }


        return false;
    }
}
