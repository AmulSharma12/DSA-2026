package S003_DP;
import java.util.Arrays;
//https://leetcode.com/problems/target-sum/description/

public class PC021_LC494_TargetSum {
    public static void main(String[] args){
        //call from here...
    }

    //Recursive solution
    private static int targetSumR(int[] nums, int target){
        int n = nums.length;
        int totalSum = 0;
        for(int element: nums)  totalSum += element;
        if((totalSum - target) < 0 || (totalSum - target)%2 != 0)   return 0;
        int T = (totalSum - target)/2;
        return targetSumRecursive(n-1, nums, T);
    }


    private static int targetSumRecursive(int index, int[] nums, int T){
        if(index == 0){
            if(T == 0 && nums[0] == 0)    return 2;
            if(T == 0) return 1;
            if(nums[0] == T) return 1;
            return 0;
        }

        int notTake = targetSumRecursive(index-1, nums, T);
        int take = 0;
        if(nums[index] <= T)
            take = targetSumRecursive(index-1, nums, T-nums[index]);

        return take + notTake;
    }
}
