package S003_DP;

import java.util.Arrays;

//https://leetcode.com/problems/longest-increasing-subsequence/
public class PC041_LC300_LIS {
    public static void main(String[] args){
        //call from here...
    }

    //Recursive solution
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        return lisRec(0,-1, nums, n);
    }

    private static int lisRec(int ind, int prev_ind, int[] nums, int n){
        if(ind == n)    return 0;

        int notPicked = lisRec(ind+1, prev_ind, nums, n);
        int picked = 0;
        if(prev_ind == -1 || nums[ind] > nums[prev_ind])
            picked = 1 + lisRec(ind+1, ind, nums, n);

        return Math.max(notPicked, picked);
    }

    //Memoization
    public static int lengthOfLISM(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int[] dpRow: dp){
            Arrays.fill(dpRow,-1);
        }
        return lisMem(0,-1, nums, n, dp);
    }

    private static int lisMem(int ind, int prev_ind, int[] nums, int n, int[][] dp){
        if(ind == n)    return 0;

        if(dp[ind][prev_ind+1] != -1) return dp[ind][prev_ind+1];

        int notPicked = lisMem(ind+1, prev_ind, nums, n, dp);
        int picked = 0;
        if(prev_ind == -1 || nums[ind] > nums[prev_ind])
            picked = 1 + lisMem(ind+1, ind, nums, n, dp);

        return dp[ind][prev_ind+1] = Math.max(notPicked, picked);
    }

    //Tabulation solution
    private static int lisTabulation(int[] nums){
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];

        for(int ind = n-1; ind>=0; ind--){
            for(int prev_ind = ind-1; prev_ind >=-1; prev_ind--){
                int notPicked = dp[ind+1][prev_ind+1];
                int picked = 0;
                if(prev_ind == -1 || nums[ind] > nums[prev_ind])
                    picked = 1 + dp[ind+1][ind+1];

                dp[ind][prev_ind+1] = Math.max(picked, notPicked);
            }
        }

        return dp[0][-1 +1];
    }


    //Space optimization solution
    private static int lisSpaceOptimizatoin(int[] nums){
        int n = nums.length;
        int[] ahead = new int[n+1];

        for(int ind = n-1; ind>=0; ind--){
            int[] curr = new int[n+1];
            for(int prev_ind = ind-1; prev_ind >=-1; prev_ind--){
                int notPicked = ahead[prev_ind+1];
                int picked = 0;
                if(prev_ind == -1 || nums[ind] > nums[prev_ind])
                    picked = 1 + ahead[ind+1];

                curr[prev_ind+1] = Math.max(picked, notPicked);
            }
            ahead = curr;
        }


        return ahead[-1 +1];
    }
}
