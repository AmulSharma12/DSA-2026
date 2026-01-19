package S003_DP;
import java.util.Arrays;

//https://leetcode.com/problems/coin-change/description/
public class PC020_LC322_CoinChange {
    public static void main(String[] args){
        //call from here...
    }

    //Recursive solution
    public static int coinChangeR(int[] coins, int amount) {
        int n = coins.length;
        if(amount == 0) return 0;
        int[][] dp = new int[n][amount+1];
        int ans = coinChangeRecursive(n-1, amount, coins);
        if(ans >= Integer.MAX_VALUE/2)  return -1;
        return ans;
    }

    private static int coinChangeRecursive(int index, int amount, int[] coins){
        //base case
        if(index == 0){
            if(amount % coins[0] == 0)
                return amount/coins[0];
            return Integer.MAX_VALUE/2;
        }


        //recursive function
        int notTake = 0 + coinChangeRecursive(index-1, amount, coins);
        int take = Integer.MAX_VALUE;
        if(coins[index] <= amount)
            take = 1 + coinChangeRecursive(index, amount-coins[index], coins);

        return Math.min(take ,notTake);
    }

    //Memoization solution
    public int coinChangeM(int[] coins, int amount) {
        int n = coins.length;
        if(amount == 0) return 0;
        int[][] dp = new int[n][amount+1];
        for(int[] dpRow: dp){
            Arrays.fill(dpRow,-1);
        }
        int ans = coinChangeMemoize(n-1, amount, coins, dp);
        if(ans >= Integer.MAX_VALUE/2)  return -1;
        return ans;
    }

    private int coinChangeMemoize(int index, int amount, int[] coins, int[][] dp){
        //base case
        if(index == 0){
            if(amount % coins[0] == 0)
                return amount/coins[0];
            return Integer.MAX_VALUE/2;
        }

        if(dp[index][amount] != -1) return dp[index][amount];

        //recursive function
        int notTake = 0 + coinChangeMemoize(index-1, amount, coins, dp);
        int take = Integer.MAX_VALUE;
        if(coins[index] <= amount)
            take = 1 + coinChangeMemoize(index, amount-coins[index], coins, dp);

        return dp[index][amount] =  Math.min(take ,notTake);
    }

    //Tabulation solution
    private static int coinChangeTab(int[] coins, int amount, int n){
        int[][] dp = new int[n][amount+1];

        for(int T = 0; T <= amount; T++){
            if(T% coins[0] == 0)    dp[0][T] = T / coins[0];
            else dp[0][T] = Integer.MAX_VALUE /2;
        }


        for(int index = 1; index < n; index++){
            for(int T = 0; T<= amount ; T++){
                int notTake = 0 + dp[index-1][T];
                int take = Integer.MAX_VALUE;
                if(coins[index] <= T)
                    take = 1 + dp[index][T-coins[index]];

                dp[index][T] = Math.min(take , notTake);
            }
        }


        int ans = dp[n-1][amount];
        if(ans >= Integer.MAX_VALUE/2)  return -1;
        return ans;
    }

    //Space optmization solution
    private static int coinChangeSO(int[] coins, int amount, int n){
        if(amount == 0) return 0;
        int[] prev = new int[amount+1];

        for(int T = 0; T <= amount; T++){
            if(T% coins[0] == 0)    prev[T] = T / coins[0];
            else prev[T] = Integer.MAX_VALUE /2;
        }


        for(int index = 1; index < n; index++){
            int[] curr = new int[amount+1];
            for(int T = 0; T<= amount ; T++){
                int notTake = 0 + prev[T];
                int take = Integer.MAX_VALUE;
                if(coins[index] <= T)
                    take = 1 + curr[T-coins[index]];

                curr[T] = Math.min(take , notTake);
            }
            prev = curr;
        }


        int ans = prev[amount];
        if(ans >= Integer.MAX_VALUE/2)  return -1;
        return ans;
    }
}
