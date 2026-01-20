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

    //Memoization solution
    private int targetSumM(int[] nums, int target){
        int n = nums.length;
        int totalSum = 0;
        for(int element: nums)  totalSum += element;
        if((totalSum - target) < 0 || (totalSum - target)%2 != 0)   return 0;
        int T = (totalSum - target)/2;
        int[][] dp = new int[n][T+1];
        for(int[] dpRow: dp){
            Arrays.fill(dpRow,-1);
        }
        return targetSumMemoize(n-1, nums, T, dp);
    }


    private int targetSumMemoize(int index, int[] nums, int T, int[][] dp){
        if(index == 0){
            if(T == 0 && nums[0] == 0)    return 2;
            if(T == 0) return 1;
            if(nums[0] == T) return 1;
            return 0;
        }

        if(dp[index][T] != -1)    return dp[index][T];

        int notTake = targetSumMemoize(index-1, nums, T, dp);
        int take = 0;
        if(nums[index] <= T)
            take = targetSumMemoize(index-1, nums, T-nums[index], dp);

        return dp[index][T] = take + notTake;
    }
}
