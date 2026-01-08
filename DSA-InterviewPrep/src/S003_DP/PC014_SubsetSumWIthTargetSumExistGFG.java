package S003_DP;
import java.util.Arrays;
//https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1
public class PC014_SubsetSumWIthTargetSumExistGFG {
    public static void main(String[] args){
        //call from here...
    }

    //recursive solution
    static Boolean isSubsetSumR(int[] arr, int sum) {
        int n = arr.length;
        return solveRecursive(n-1, arr, sum);
    }

    static Boolean solveRecursive(int ind, int[] nums, int target){
        if(target == 0) return true;
        if(ind == 0 && nums[0] == target) return true;
        if(ind < 0)   return false;

        boolean notTake;
        notTake = solveRecursive(ind-1, nums, target);

        boolean take = false;
        if(nums[ind] <= target) take = solveRecursive(ind-1, nums, target - nums[ind]);


        return take || notTake;
    }


    static Boolean isSubsetSumM(int arr[], int sum) {
        int n = arr.length;
        int[][] dp = new int[n][sum+1];
        for(int[] dpRow: dp){
            Arrays.fill(dpRow,-1);
        }
        return solveMemoize(n-1, arr, sum, dp);
    }

    static Boolean solveMemoize(int ind, int[] nums, int target, int[][] dp){
        if(target == 0) return true;
        if(ind == 0 && nums[0] == target) return true;
        if(ind < 0)   return false;

        if(dp[ind][target] != -1)   return dp[ind][target] == 0 ? false : true;

        boolean notTake;
        notTake = solveMemoize(ind-1, nums, target, dp);

        boolean take = false;
        if(nums[ind] <= target) take = solveMemoize(ind-1, nums, target - nums[ind], dp);

        dp[ind][target] = take || notTake ? 1 : 0;
        return  take || notTake;
    }
}
