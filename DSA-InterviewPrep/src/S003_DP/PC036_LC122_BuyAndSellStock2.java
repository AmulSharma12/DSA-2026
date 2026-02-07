package S003_DP;

import java.util.Arrays;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
public class PC036_LC122_BuyAndSellStock2 {
    public static void main(String[] args){
        //call from here..
    }

    //Recursive solution
    public static int maxProfitRec(int[] prices) {
        return maxProfitR(0,1, prices);
    }

    private static int maxProfitR(int ind,int buy, int[] prices){
        if(ind == prices.length)    return 0;

        int profit = Integer.MIN_VALUE;
        if(buy == 1){
            profit = Math.max(
                    -prices[ind] + maxProfitR(ind+1, 0, prices),
                    0 + maxProfitR(ind+1, 1, prices)
            );

        }else{
            profit = Math.max(
                    prices[ind] + maxProfitR(ind+1, 1, prices),
                    0 + maxProfitR(ind+1, 0, prices)
            );
        }

        return profit;
    }


    //Memoization solution
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] cache = new int[n][2];
        for(int[] cacheRow:cache){
            Arrays.fill(cacheRow,-1);
        }
        return maxProfitM(0,1, prices, cache);
    }

    private int maxProfitM(int ind,int buy, int[] prices, int[][] cache){
        if(ind == prices.length)    return 0;

        if(cache[ind][buy] != -1)   return cache[ind][buy];
        int profit = Integer.MIN_VALUE;
        if(buy == 1){
            profit = Math.max(
                    -prices[ind] + maxProfitM(ind+1, 0, prices, cache),
                    0 + maxProfitM(ind+1, 1, prices, cache)
            );

        }else{
            profit = Math.max(
                    prices[ind] + maxProfitM(ind+1, 1, prices, cache),
                    0 + maxProfitM(ind+1, 0, prices, cache)
            );
        }

        return cache[ind][buy] = profit;
    }


    //Tabulation solution
    private static int maxProfitT(int[] prices){
        int n = prices.length;

        int[][] dp = new int[n+1][2];
        dp[n][0] = dp[n][1] = 0;

        for(int ind = n-1 ; ind >= 0 ; ind--){
            for(int buy = 0; buy <= 1 ; buy++){
                int profit = 0;
                if(buy == 1){
                    profit = Math.max(
                            -prices[ind] + dp[ind+1][0],
                            dp[ind+1][1]
                    );
                }else{
                    profit = Math.max(
                            prices[ind] + dp[ind+1][1],
                            dp[ind+1][0]
                    );
                }

                dp[ind][buy] = profit;
            }
        }

        return dp[0][1];
    }

    //Space optimization
    private static int maxProfitSO(int[] prices){
        int n = prices.length;

        int[] ahead = new int[2];
        ahead[0] = ahead[1] = 0;

        for(int ind = n-1 ; ind >= 0 ; ind--){
            int[] curr = new int[2];
            for(int buy = 0; buy <= 1 ; buy++){
                int profit = 0;
                if(buy == 1){
                    profit = Math.max(
                            -prices[ind] + ahead[0],
                            ahead[1]
                    );
                }else{
                    profit = Math.max(
                            prices[ind] + ahead[1],
                            ahead[0]
                    );
                }

                curr[buy] = profit;
            }

            ahead = curr;
        }

        return ahead[1];
    }
}
