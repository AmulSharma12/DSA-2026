package S006_BinarySearch;
//https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
public class P014_LC1283_SmallestDivisionInThreshold {
    public static void main(String[] args){
        //call from here..
    }

    //Approach 1 - using linear search approach
    public static int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int maxValue = Integer.MIN_VALUE;

        for(int ind = 0; ind < n; ind++){
            maxValue = Math.max(maxValue, nums[ind]);
        }


        for(int div = 1; div <= maxValue; div++){
            if(isPossible(nums, div, threshold))    return div;
        }


        return maxValue;
    }

    private static boolean isPossible(int[] nums, int div, int threshold){
        int currThreshold = 0;
        int n = nums.length;
        for(int ind = 0; ind < n; ind++){
            currThreshold += Math.ceil((double)nums[ind]/div);

            if(currThreshold > threshold)   return false;
        }

        return true;
    }
}
