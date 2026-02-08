package S003_DP;
import java.util.Arrays;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
public class PC040_LC714_BuyAndSellStockWithFee {
    public static void main(String[] args){
        //call from here...
    }

    //Recursive solution
    public static int maxProfit(int[] prices, int fee) {
        return maxProfitR(0, 1, prices, fee);
    }

    private static int maxProfitR(int day, int buy, int[] prices, int fee){
        if(day == prices.length)    return 0;

        if(buy == 1){
            return Math.max(
                    -prices[day] + maxProfitR(day+1, 0, prices, fee),
                    maxProfitR(day+1, 1, prices, fee)
            );
        }


        return Math.max(
                prices[day] - fee + maxProfitR(day+1, 1, prices, fee),
                maxProfitR(day+1, 0, prices, fee)
        );
    }


    //Memoization  solution
    public static int maxProfitMem(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] dpRow: dp){
            Arrays.fill(dpRow,-1);
        }
        return maxProfitM(0, 1, prices, fee, dp);
    }

    private static int maxProfitM(int day, int buy, int[] prices, int fee, int[][] dp){
        if(day == prices.length)    return 0;

        if(dp[day][buy] != -1)  return dp[day][buy];

        if(buy == 1){
            return dp[day][buy] = Math.max(
                    -prices[day] + maxProfitM(day+1, 0, prices, fee, dp),
                    maxProfitM(day+1, 1, prices, fee, dp)
            );
        }


        return dp[day][buy] = Math.max(
                prices[day] - fee + maxProfitM(day+1, 1, prices, fee, dp),
                maxProfitM(day+1, 0, prices, fee, dp)
        );
    }
}
