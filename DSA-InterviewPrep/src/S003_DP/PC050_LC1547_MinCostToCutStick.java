package S003_DP;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-cost-to-cut-a-stick/description/
public class PC050_LC1547_MinCostToCutStick {
    public static void main(String[] args){
        //call from here...
    }

    //Recursive solution
    public static int minCostRec(int n, int[] cuts) {
        int m = cuts.length;
        int[] arr = new int[m + 2];
        arr[0] = 0;
        arr[m + 1] = n;
        for (int i = 0; i < m; i++) arr[i + 1] = cuts[i];
        Arrays.sort(arr);

        return minCostR(1, m,  arr, n);
    }


    private static int minCostR(int i, int j, int[] cuts, int n){
        if(i > j)   return 0;

        int mini = Integer.MAX_VALUE;
        for(int k = i; k<=j; k++){
            int cost = cuts[j+1] - cuts[i-1] + minCostR(i, k-1, cuts, n) + minCostR(k+1, j,  cuts, n);
            mini = Math.min(mini, cost);
        }

        return mini;
    }


    //Memoization solution
    public static int minCostMem(int n, int[] cuts) {
        int m = cuts.length;
        int[] arr = new int[m + 2];
        arr[0] = 0;
        arr[m + 1] = n;
        for (int i = 0; i < m; i++) arr[i + 1] = cuts[i];
        Arrays.sort(arr);
        int[][] dp = new int[m+1][m+1];
        for(int[] dpRow: dp){
            Arrays.fill(dpRow,-1);
        }
        return minCostM(1, m,  arr, n, dp);
    }


    private static int minCostM(int i, int j, int[] cuts, int n, int[][] dp){
        if(i > j)   return 0;
        if(dp[i][j] != -1)  return dp[i][j];

        int mini = Integer.MAX_VALUE;
        for(int k = i; k<=j; k++){
            int cost = cuts[j+1] - cuts[i-1] + minCostM(i, k-1, cuts, n, dp) + minCostM(k+1, j,  cuts, n, dp);
            mini = Math.min(mini, cost);
        }

        return dp[i][j] = mini;
    }

    //Tabulation solution
    public static int minCostTabulation(int n, int[] cuts) {
        int m = cuts.length;
        int[] nums = new int[m+2];
        nums[0] = 0;
        nums[nums.length-1] = n;
        for(int ind = 0; ind < m; ind++)    nums[ind+1] = cuts[ind];
        Arrays.sort(nums);
        return minCostTabulation(n, m, nums);
    }

    private static int minCostTabulation(int n, int c, int[] cuts){
        int[][] dp = new int[c+2][c+2];

        for(int i = c; i >= 1; i--){
            for(int j = 1; j<=c; j++){
                if(i > j)   continue;
                int mini = Integer.MAX_VALUE;
                for(int ind = i; ind <= j; ind++){
                    int cost = cuts[j+1]-cuts[i-1] + dp[i][ind-1] + dp[ind+1][j];
                    mini = Math.min(mini, cost);
                }

                dp[i][j] = mini;
            }
        }

        return dp[1][c];
    }
}
