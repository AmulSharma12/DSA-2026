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


        Arrays.sort(nums);  //sorting to align the element in sorted array

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


    //Approach 4 - Using binary search approach
    public static double findMedianSortedArraysUsingBinarySearchApproach(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n2 < n1) return findMedianSortedArraysUsingBinarySearchApproach(nums2, nums1);
        int n = n1 + n2;
        int leftPart = (n+1)/2;
        int low = 0;
        int high = n1;

        while(low <= high){
            int mid1 = low + (high - low)/2;
            int mid2 = leftPart - mid1;

            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;

            if(mid1 < n1)   r1 = nums1[mid1];
            if(mid2 < n2)   r2 = nums2[mid2];
            if(mid1-1 >= 0) l1 = nums1[mid1-1];
            if(mid2-1 >= 0) l2 = nums2[mid2-1];

            if(l1 <= r2 &&  l2 <= r1){
                if(n%2 != 0)    return (double)Math.max(l1, l2);
                return (double) (Math.max(l1, l2) + Math.min(r1, r2))/2;
            }else if(l1 > r2){
                high = mid1 - 1;
            }else{
                low = mid1 + 1;
            }
        }

        return 0;
    }
}
