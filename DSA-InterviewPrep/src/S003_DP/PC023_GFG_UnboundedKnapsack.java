package S003_DP;

import java.util.Arrays;

//https://www.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1
public class PC023_GFG_UnboundedKnapsack {
    public static void main(String[] args){
        //call from here...
    }

    //Recursive solution
    public static int knapSackR(int val[], int wt[], int capacity) {
        int n = val.length;
        return unboundedKnapSackR(n-1, capacity, wt, val);
    }

    private static int unboundedKnapSackR(int index, int maxWeight, int[] wt, int[] val){
        //base case
        if(index == 0){
            return (maxWeight/wt[0]) * val[0];
        }

        //fill the knapsack
        int excluded = unboundedKnapSackR(index-1, maxWeight, wt, val);
        int included = Integer.MIN_VALUE;
        if(wt[index] <= maxWeight)
            included = val[index] + unboundedKnapSackR(index, maxWeight-wt[index], wt, val);

        return Math.max(excluded, included);
    }


    //Memoization solution
    public static int knapSackM(int val[], int wt[], int capacity) {
        int n = val.length;
        int[][] dp = new int[n][capacity+1];
        for(int[] dpRow: dp){
            Arrays.fill(dpRow,-1);
        }
        return unboundedKnapSackM(n-1, capacity, wt, val, dp);
    }

    private static int unboundedKnapSackM(int index, int maxWeight, int[] wt, int[] val, int[][] dp){
        //base case
        if(index == 0){
            return (maxWeight/wt[0]) * val[0];
        }

        //if already computed then return
        if(dp[index][maxWeight] != -1)  return dp[index][maxWeight];

        //fill the knapsack
        int excluded = unboundedKnapSackM(index-1, maxWeight, wt, val, dp);
        int included = Integer.MIN_VALUE;
        if(wt[index] <= maxWeight)
            included = val[index] + unboundedKnapSackM(index, maxWeight-wt[index], wt, val, dp);

        return dp[index][maxWeight] = Math.max(excluded, included);
    }
}
