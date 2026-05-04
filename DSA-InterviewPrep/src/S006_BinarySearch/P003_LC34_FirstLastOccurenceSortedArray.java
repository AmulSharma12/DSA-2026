package S006_BinarySearch;
//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
public class P003_LC34_FirstLastOccurenceSortedArray {
    public static void main(String[] args){
        //call from here...
    }

    //Approach 1 - using linear approach
    public int[] searchRangeLinearApproach(int[] nums, int target) {
        int n  = nums.length;
        int first = -1;
        int last = -1;

        for(int ind = 0; ind <n; ind++){
            if(nums[ind] == target){
                if(first == -1){
                    first = last = ind;
                }else{
                    last = ind;
                }
            }
        }

        return new int[] {first, last};
    }


    //Approach 2 - using binary search
    public static int[] searchRangeBinarySearch(int[] nums, int target) {
        int n = nums.length;
        int firstOccurence = findFirstOccurence(nums, target, n);
        int lastOccurence = findLastOccurence(nums,target, n);
        return new int[] {firstOccurence, lastOccurence};
    }

    private static int findFirstOccurence(int[] nums, int target, int n){
        int low = 0;
        int high = n-1;

        while(low <= high){
            int mid = (low + high)/2;

            if(nums[mid] >= target)     high = mid - 1;
            else low = mid + 1;
        }


        if(low < n && nums[low] == target)  return low;
        return -1;
    }

    private static int findLastOccurence(int[] nums, int target, int n){
        int low = 0;
        int high = n-1;

        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] <= target)  low = mid + 1;
            else high = mid - 1;
        }

        if(high >= 0 && nums[high] == target)    return high;
        return -1;
    }
}
