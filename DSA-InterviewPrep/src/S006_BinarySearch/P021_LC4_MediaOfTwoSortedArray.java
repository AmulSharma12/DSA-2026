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

    //Approach 1 - using merge sort approach
    public static double findMedianSortedArraysUsingMergeSortApproach(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int x = m + n;
        int[] nums = new int[x];
        int currInd = 0;

        int ind1 = 0;
        int ind2 = 0;
        while(ind1 < m && ind2 < n){
            if(nums1[ind1]  < nums2[ind2])
                nums[currInd++] = nums1[ind1++];
            else
                nums[currInd++] = nums2[ind2++];
        }

        while(ind1 < m) nums[currInd++] = nums1[ind1++];
        while(ind2 < n) nums[currInd++] = nums2[ind2++];

        if(x == 1)  return (double)nums[0];
        if(x%2 != 0)    return (double) nums[x/2];      //odd length

        int mid = x/2;
        return (double) (nums[mid]+nums[mid-1])/2;      //even length

    }


    //Approach 3 - optimising space for merge sort solution.
    public double findMedianSortedArraysSpaceOptimizationMergeSort(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int totalLength = m + n;
        int expectedMid = totalLength/2;
        int expectedPrevMid = expectedMid - 1;
        int currentPos = 0;
        int ind1 = 0;
        int ind2 = 0;
        int mid = -1; int prevMid = -1;

        while(ind1 < m && ind2 < n){
            if(nums1[ind1] < nums2[ind2]){
                //nums1 and ind1 are lesser
                if(currentPos == expectedMid)   mid = nums1[ind1];
                if(currentPos == expectedPrevMid)   prevMid = nums1[ind1];
                ind1++;
                currentPos++;
            }else{
                //nums2 and ind2 are lesser
                if(currentPos == expectedMid) mid = nums2[ind2];
                if(currentPos == expectedPrevMid) prevMid = nums2[ind2];
                ind2++;
                currentPos++;
            }
        }

        //fetching out remaining elements if left out
        while(ind1 < m){
            if(currentPos == expectedMid) mid = nums1[ind1++];
            if(currentPos == expectedPrevMid) prevMid = nums1[ind1++];
            else ind1++;
            currentPos++;
        }

        while(ind2 < n){
            if(currentPos == expectedMid) mid = nums2[ind2++];
            if(currentPos == expectedPrevMid) prevMid = nums2[ind2++];
            else ind2++;
            currentPos++;
        }

        if(totalLength%2 != 0)  return mid;

        return (double) (mid + prevMid)/2;

    }
}
