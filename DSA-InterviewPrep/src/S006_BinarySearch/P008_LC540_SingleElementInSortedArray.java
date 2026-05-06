package S006_BinarySearch;
//https://leetcode.com/problems/single-element-in-a-sorted-array/description/
public class P008_LC540_SingleElementInSortedArray {
    public static void main(String[] args){
        //call from here...
    }

    //Approach 1 - using linear approach
    public static int singleNonDuplicateUsingLinearApproach(int[] nums) {
        int n = nums.length;

        for(int ind = 0; ind < n; ind+=2){
            if(ind + 1 == n)    return nums[ind];
            if(nums[ind] != nums[ind+1])    return nums[ind];
        }

        return nums[0];
    }
}
