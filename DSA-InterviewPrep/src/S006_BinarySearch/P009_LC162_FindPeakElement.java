package S006_BinarySearch;
//https://leetcode.com/problems/find-peak-element/
public class P009_LC162_FindPeakElement {
    public static void main(String[] args){
        //call from here...
    }

    //Approach 1 - using linear approach
    public static int findPeakElementUsingLinear(int[] nums) {
        int n = nums.length;
        int peakInd = 0;

        for(int ind = 1; ind < n; ind++){
            if(nums[ind] > nums[ind-1])
                peakInd = ind;
        }

        return peakInd;
    }

    //Approach 2- using binary search problem
    public static int findPeakElementUsingBinarySearch(int[] nums) {
        int n = nums.length;
        if(n == 1)  return 0;
        if(nums[0] > nums[1])   return 0;
        if(nums[n-1] > nums[n-2])   return n-1;

        int low = 1;
        int high = n-2;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1])  return mid;
            if(nums[mid] > nums[mid-1]) low = mid + 1;
            else high = mid - 1;
        }

        return -1;
    }
}
