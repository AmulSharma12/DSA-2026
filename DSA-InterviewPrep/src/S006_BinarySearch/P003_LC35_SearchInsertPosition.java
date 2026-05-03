package S006_BinarySearch;
//https://leetcode.com/problems/search-insert-position/description/
public class P003_LC35_SearchInsertPosition {
    public static void main(String[] args){
        //call from here....
    }

    //Approach 1 - using linear search approach
    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;

        for(int ind = 0; ind <n; ind++){
            if(nums[ind] >= target)
                return ind;
        }


        return n;
    }
}
