package S003_DP;
import java.util.Arrays;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
public class PC037_LC123BuyAndSellStock3 {
    public static void main(String[] args){
        //call from here...
    }

    //Recursive solution
    public static int maxProfitRec(int[] prices) {
        return maxProfitR(0,1,2, prices);
    }

    private static int maxProfitR(int ind, int buy, int limit,int[] prices ){
        if(ind == prices.length || limit == 0)  return 0;

        if(buy == 1){
            return Math.max(
                    -prices[ind] + maxProfitR(ind+1, 0, limit, prices),
                    maxProfitR(ind+1, 1, limit, prices)
            );
        }

        return Math.max(
                prices[ind] + maxProfitR(ind+1, 1, limit-1, prices),
                maxProfitR(ind+1, 0, limit, prices)
        );
    }

    //Memoization solution
    public static int maxProfitMemoize(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        for(int ind = 0; ind <n; ind++){
            for(int buy = 0; buy<=1; buy++){
                Arrays.fill(dp[ind][buy], -1);
            }
        }
        return maxProfitM(0,1,2, prices, dp);
    }

    private static int maxProfitM(int ind, int buy, int limit,int[] prices , int[][][] dp){
        if(ind == prices.length || limit == 0)  return 0;

        if(dp[ind][buy][limit] != -1)   return dp[ind][buy][limit];

        if(buy == 1){
            return dp[ind][buy][limit] =  Math.max(
                    -prices[ind] + maxProfitM(ind+1, 0, limit, prices, dp),
                    maxProfitM(ind+1, 1, limit, prices, dp)
            );
        }

        return dp[ind][buy][limit] = Math.max(
                prices[ind] + maxProfitM(ind+1, 1, limit-1, prices, dp),
                maxProfitM(ind+1, 0, limit, prices, dp)
        );
    }
}
