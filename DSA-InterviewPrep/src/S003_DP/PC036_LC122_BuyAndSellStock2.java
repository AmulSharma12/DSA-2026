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
}
