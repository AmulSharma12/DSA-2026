package S003_DP;
import java.util.Arrays;
//https://leetcode.com/problems/coin-change-ii/description/
public class PC022_LC518_CoinChange2 {
    public static void main(String[] args){
        //call from here...
    }

    //Recursive solution
    public static int changeR(int amount, int[] coins) {
        int n = coins.length;
        return coinChangeR(n-1, amount, coins);
    }

    private static int coinChangeR(int index, int target, int[] coins){
        if(target == 0) return 1;
        if(index == 0){
            if(target == coins[0]) return 1;
            if(target % coins[0] == 0)  return 1;
            return 0;
        }


        int notTake = coinChangeR(index-1, target, coins);
        int take = 0;
        if(coins[index] <= target)
            take = coinChangeR(index, target - coins[index], coins);

        return notTake + take;
    }

    //Memoization solution
    public static int changeM(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] dpRow:dp)
            Arrays.fill(dpRow,-1);
        return coinChangeM(n-1, amount, coins, dp);
    }

    private static int coinChangeM(int index, int target, int[] coins, int[][] dp){
        if(target == 0) return 1;
        if(index == 0){
            if(target % coins[0] == 0)  return 1;
            return 0;
        }

        if(dp[index][target] != -1) return dp[index][target];

        int notTake = coinChangeM(index-1, target, coins, dp);
        int take = 0;
        if(coins[index] <= target)
            take = coinChangeM(index, target - coins[index], coins, dp);

        return dp[index][target] = notTake + take;
    }

    //Tabulation solution
    private static int coinChangeT(int amount, int[] coins){
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        for(int target = 0; target <= amount; target++){
            if(target%coins[0] == 0) dp[0][target] = 1;
        }

        for(int index = 1; index < n; index++){
            for(int target = 0; target<= amount; target++){
                int notTake = dp[index-1][target];
                int take = 0;
                if(coins[index] <= target)
                    take = dp[index][target-coins[index]];

                dp[index][target] = take + notTake;
            }
        }

        return dp[n-1][amount];
    }

    //space optimization solution
    private static int coinChangeSO(int amount, int[] coins){
        int n = coins.length;
        int[] prev = new int[amount+1];


        for(int target = 0; target <= amount; target++){
            if(target%coins[0] == 0) prev[target] = 1;
        }

        for(int index = 1; index < n; index++){
            int[] curr = new int[amount+1];
            for(int target = 0; target<= amount; target++){
                int notTake = prev[target];
                int take = 0;
                if(coins[index] <= target)
                    take = curr[target-coins[index]];

                curr[target] = take + notTake;
            }
            prev = curr;
        }

        return prev[amount];
    }
}
