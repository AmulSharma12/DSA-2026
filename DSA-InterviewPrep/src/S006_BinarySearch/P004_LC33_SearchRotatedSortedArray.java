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

    //Approach 2 - using binary search approach
    public static int searchBinarySearch(int[] nums, int target) {
        int n = nums.length;

        int low = 0;
        int high = n-1;

        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] == target)     return mid;

            //left sorted confirmed
            if(nums[low] <= nums[mid]){
                //left part sorted
                if(nums[low] <= target && target <= nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            else{
                //right part sorted

                if(nums[mid] <= target && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }

        return -1;
    }
}
