package S003_DP;
import java.util.List;
import java.util.ArrayList;
//https://leetcode.com/problems/longest-increasing-subsequence/description/

public class PC043_LC300_LIS_UsingBinarySearch {
    public static void main(String[] args){
        //call from here...
    }

    //LIS using binary search
    public static int lengthOfLISUsingBinarySearch(int[] nums) {
        int n = nums.length;

        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        int length = 1;
        for(int ind = 1; ind <n; ind++){
            if(nums[ind]  > list.get(list.size()-1)){
                list.add(nums[ind]);
                length++;
            }
            else{
                int expectedInd = lowerBound(0, list.size(), list, nums[ind]);
                list.set(expectedInd, nums[ind]);

            }
        }


        return length;
    }

    private static int lowerBound(int low, int high, List<Integer> list, int target){
        while(low <= high){
            int mid = low + (high-low)/2;
            int element = list.get(mid);
            if(element == target)   return mid;
            else if(element > target)   high = mid - 1;
            else low = mid + 1;
        }

        return low;
    }
}
