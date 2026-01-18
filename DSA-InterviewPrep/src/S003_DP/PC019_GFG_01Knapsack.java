package S003_DP;
import java.util.Arrays;
public class PC019_GFG_01Knapsack {
    public static void main(String[] args){
        //call from here...
    }

    //Recursive solution
    public static int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        return knapsackRecursive(n-1, val, wt, W);
    }

    private static int knapsackRecursive(int index, int[] val,int[] wt, int W){
        //base case
        if(index == 0){
            if(wt[0] <= W)   return val[0];
            return 0;
        }

        int notTake = 0 + knapsackRecursive(index-1, val, wt, W);
        int take = Integer.MIN_VALUE;
        if(wt[index]  <= W)
            take = val[index] + knapsackRecursive(index-1, val, wt, W-wt[index]);

        return Math.max(take, notTake);
    }

    //Memoization solution
    public static int knapsackM(int W, int val[], int wt[]) {
        int n = val.length;
        int[][] dp = new int[n][W+1];
        for(int[] dpRow: dp){
            Arrays.fill(dpRow,-1);
        }
        return knapsackMemoize(n-1, val, wt, W, dp);
    }

    private static int knapsackMemoize(int index, int[] val,int[] wt, int W,int[][] dp){
        //base case
        if(index == 0){
            if(wt[0] <= W)   return val[0];
            return 0;
        }
        if(dp[index][W] != -1)  return dp[index][W];


        int notTake = 0 + knapsackMemoize(index-1, val, wt, W, dp);
        int take = Integer.MIN_VALUE;
        if(wt[index]  <= W)
            take = val[index] + knapsackMemoize(index-1, val, wt, W-wt[index], dp);

        return dp[index][W] = Math.max(take, notTake);
    }


    //Tabulation solution
    private int knapsackTabulation(int[] val,int[] wt, int W, int n){
        int[][] dp = new int[n][W+1];

        for(int weight = wt[0]; weight <= W; weight++) dp[0][weight] = val[0];

        for(int index = 1; index < n; index++){
            for(int weight = 1; weight <= W; weight++){

                int notTake = dp[index-1][weight];
                int take = Integer.MIN_VALUE;

                if(wt[index] <= weight){
                    take = val[index] + dp[index-1][weight - wt[index]];
                }

                dp[index][weight] = Math.max(take, notTake);
            }
        }

        return dp[n-1][W];
    }


    //Space Optimisation solution
    private static int knapsackSO(int[] val,int[] wt, int W, int n){
        int[] prev = new int[W+1];

        for(int weight = wt[0]; weight <= W; weight++) prev[weight] = val[0];

        for(int index = 1; index < n; index++){
            int[] curr = new int[W+1];
            for(int weight = 1; weight <= W; weight++){

                int notTake = prev[weight];
                int take = Integer.MIN_VALUE;

                if(wt[index] <= weight){
                    take = val[index] + prev[weight - wt[index]];
                }

                curr[weight] = Math.max(take, notTake);
            }
            prev = curr;
        }

        return prev[W];
    }
}
