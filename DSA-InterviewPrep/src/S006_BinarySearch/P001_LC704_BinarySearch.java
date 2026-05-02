package S006_BinarySearch;
//https://leetcode.com/problems/binary-search/
public class P001_LC704_BinarySearch {
    public static void main(String[] args){
        //call from here...
    }

    //Approach 1 - binary search - Iterative
    public static int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n-1;

        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] == target) return mid;
            else if(target > nums[mid]) low = mid + 1;
            else high = mid - 1;
        }

        return -1;  //not found target
    }


    //Approach 2 - using recursive way
    public static int searchRecursive(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length-1, target);
    }

    private static int binarySearch(int[] nums, int low , int high, int target){
        if(low > high)  return -1;

        int mid = (low + high)/2;
        if(nums[mid] == target)    return mid;
        else if(target > nums[mid]) return binarySearch(nums, mid+1, high, target);
        return binarySearch(nums, low, mid-1, target);
    }
}
