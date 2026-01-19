package S003_DP;

public class PC020_LC322_CoinChange {
    public static void main(String[] args){
        //call from here...
    }

    //Recursive solution
    public static int coinChange(int[] coins, int amount) {
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
}
