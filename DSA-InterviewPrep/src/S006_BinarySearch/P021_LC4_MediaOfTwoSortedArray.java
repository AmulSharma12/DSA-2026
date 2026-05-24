package S006_BinarySearch;
import java.util.Arrays;
//https://leetcode.com/problems/median-of-two-sorted-arrays/description/
public class P021_LC4_MediaOfTwoSortedArray {
    public static void main(String[] args){
        //call from here...
    }


    //Approach 1 - using brute force approac
    public static double findMedianSortedArraysUsingBrute(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int x = m + n;
        int[] nums = new int[x];
        int currInd = 0;
        for(int ind = 0; ind <m; ind++){
            nums[currInd++] = nums1[ind];
        }

        for(int ind = 0; ind < n; ind++){
            nums[currInd++] = nums2[ind];
        }


        Arrays.sort(nums);  //sorting to align the elemnet in sorted array

        if(x == 1)  return (double)nums[0];
        if(x%2 != 0)    return (double) nums[x/2];

        int mid = x/2;
        return (double) (nums[mid]+nums[mid-1])/2;

    }
}
