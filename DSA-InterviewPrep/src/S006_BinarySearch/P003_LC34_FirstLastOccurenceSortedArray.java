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
}
