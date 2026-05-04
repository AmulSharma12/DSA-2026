package S006_BinarySearch;
//https://leetcode.com/problems/search-insert-position/description/
public class P002_LC35_SearchInsertPosition {
    public static void main(String[] args){
        //call from here....
    }

    //Approach 1 - using linear search approach
    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;

        for(int ind = 0; ind <n; ind++){
            if(nums[ind] >= target)
                return ind;
        }


        return n;
    }


    //Approach 2 - using binary search approach
    public static int searchInsertUsingBinarySearch(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n-1;

        while(low <= high){
            int mid = (low+high)/2;
            if(nums[mid] == target) return mid;
            else if(target > nums[mid])  low = mid + 1;
            else high = mid -1;

        }


        return low;
    }
}
