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


    //Tabulation solution
    static Boolean solveTabulation(int[] nums, int k){
        int n = nums.length;
        boolean[][] dp = new boolean[n][k+1];

        //index mapped with target  (for any index target 0 it means there is no target to be looked)
        for(int index = 0; index < n; index++)  dp[index][0] = true;
        //for index 0 if the elment same as target then also its valid true case
        if(nums[0] <= k) dp[0][nums[0]] = true;


        //Looping DP states
        for(int index = 1; index < n; index++){
            for(int target = 1; target <= k; target++){
                boolean notTake = dp[index-1][target];
                boolean take = false;
                if(nums[index] <= target)
                    take = dp[index-1][target-nums[index]];
                dp[index][target] = take | notTake;
            }
        }


        //last cell last row with the target
        return dp[n-1][k];

    }
}
