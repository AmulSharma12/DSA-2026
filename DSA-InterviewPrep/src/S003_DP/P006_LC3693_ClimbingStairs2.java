package S003_DP;
import java.util.Arrays;
public class P006_LC3693_ClimbingStairs2 {
    public static void main(String[] args){
        //call from here...
    }

    //Recursive solution
    public static int climbStairsRecursive(int n, int[] costs) {
        if(n == 0)   return 0;

        int oneStepJumpCost = costs[n - 1] + 1 +  climbStairsRecursive(n-1, costs);
        int twoStepJumpCost=Integer.MAX_VALUE, threeStepJumpCost = Integer.MAX_VALUE;
        if(n-2 >= 0) twoStepJumpCost = costs[n - 1] + 4 + climbStairsRecursive(n-2, costs);
        if(n-3>=0) threeStepJumpCost = costs[n - 1] + 9 + climbStairsRecursive(n -3, costs);

        return Math.min(oneStepJumpCost, Math.min(twoStepJumpCost, threeStepJumpCost));
    }

    //Memoization solution
    public static int climbStairsM(int n, int[] costs) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return climbStairsMemoize(n, costs, dp);
    }

    public static int climbStairsMemoize(int n, int[] costs, int[] dp) {
        if(n == 0)   return 0;
        if(dp[n] != -1)  return dp[n];
        int oneStepJumpCost = costs[n - 1] + 1 +  climbStairsMemoize(n-1, costs, dp);
        int twoStepJumpCost=Integer.MAX_VALUE, threeStepJumpCost = Integer.MAX_VALUE;
        if(n-2 >= 0) twoStepJumpCost = costs[n - 1] + 4 + climbStairsMemoize(n-2, costs, dp);
        if(n-3>=0) threeStepJumpCost = costs[n - 1] + 9 + climbStairsMemoize(n -3, costs, dp);

        return dp[n] = Math.min(oneStepJumpCost, Math.min(twoStepJumpCost, threeStepJumpCost));
    }


    //Tabulation solution
    public static int climbStairsTabulation(int n, int[] costs) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        int minCost = Integer.MAX_VALUE;
        for(int index = 1; index<=n; index++){
            int oneStepCost = Integer.MAX_VALUE,twoStepCost = Integer.MAX_VALUE, threeStepCost = Integer.MAX_VALUE;
            if(index-1 >= 0) oneStepCost = 1 + costs[index-1] + dp[index-1];
            if(index-2 >= 0) twoStepCost = 4 + costs[index-1] + dp[index-2];
            if(index-3 >= 0) threeStepCost = 9 + costs[index-1] + dp[index-3];
            dp[index] = Math.min(oneStepCost, Math.min(twoStepCost, threeStepCost));
        }

        return dp[n];

    }
}
