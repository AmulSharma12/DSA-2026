package S003_DP;

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
}
