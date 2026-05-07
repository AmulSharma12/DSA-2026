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


    //Approach 2 - using xor approach to cancel out duplicates and only element remaining is the that appear once.
    public static int singleNonDuplicateUsingXOR(int[] nums) {
        int n = nums.length;
        int xor = 0;
        for(int ind = 0; ind < n; ind++){
            xor = xor ^ nums[ind];
        }

        return xor;
    }

    //Approach 3 - using binary search approach
    public static int singleNonDuplicateUsingBinarySearch(int[] nums) {
        int n = nums.length;
        if(n == 1)  return nums[0];

        if(nums[0] != nums[1])  return nums[0];
        if(nums[n-1] != nums[n-2])  return nums[n-1];

        int low = 1;
        int high = n-2;

        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1])    return nums[mid];


            if(mid%2 == 0){
                //mid - even
                if(nums[mid] == nums[mid+1])
                    low = mid + 1;
                else
                    high = mid - 1;
            }else{
                //mid - odd
                if(nums[mid] == nums[mid-1])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }

        return -1;

    }
}
