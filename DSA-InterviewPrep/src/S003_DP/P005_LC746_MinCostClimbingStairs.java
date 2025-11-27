package S003_DP;
import java.util.Arrays;

public class P005_LC746_MinCostClimbingStairs {
    public static void main(String[] args){
        //call from here...
    }

    //recursive solution
    public static int minCostClimbingStairsR(int[] cost) {
        int n = cost.length;
        return Math.min(minCostR(0,cost, n), minCostR(1, cost, n));
    }


    private static int minCostR(int index, int[] cost, int n){
        if(index >= n){
            return 0;
        }

        // int cost = cost[index];
        int oneStep = cost[index] + minCostR(index+1, cost, n);
        int twoStep = cost[index] + minCostR(index+2, cost, n);
        return Math.min(oneStep, twoStep);
    }

    //Memoization solution
    public  static int minCostClimbingStairsT(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return Math.min(minCostT(0,cost, n, dp), minCostT(1, cost, n, dp));
    }


    private static int minCostT(int index, int[] cost, int n, int[] dp){
        if(index >= n){
            return 0;
        }
        if(dp[index] != -1) return dp[index];
        System.out.println(index + " ");
        // int cost = cost[index];
        int oneStep = cost[index] + minCostT(index+1, cost, n, dp);
        int twoStep = cost[index] + minCostT(index+2, cost, n, dp);
        return dp[index] = Math.min(oneStep, twoStep);
    }
}


