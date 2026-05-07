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
}
