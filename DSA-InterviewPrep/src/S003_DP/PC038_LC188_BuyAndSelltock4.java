package S003_DP;

import java.util.Arrays;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
public class PC038_LC188_BuyAndSelltock4 {
    public static void main(String[] args){
        //call from here...
    }

    public static int maxProfit(int k, int[] prices) {
        int n = prices.length;
        return maxProfitR(0, 1, k, prices);
    }

    //Recursive solution
    private static int maxProfitR(int day, int buy, int transactionLimit, int[] prices){
        //base case
        if(day == prices.length || transactionLimit == 0) return 0;

        //recursive calls
        int profit = 0;
        if(buy == 1){
            return Math.max(
                    -prices[day] + maxProfitR(day+1, 0, transactionLimit, prices),
                    maxProfitR(day+1, 1, transactionLimit, prices)
            );
        }

        return Math.max(
                prices[day] + maxProfitR(day+1, 1, transactionLimit-1, prices),
                maxProfitR(day+1, 0, transactionLimit, prices)
        );
    }

    public static int maxProfitMem(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][k+1];
        for(int day = 0; day < n; day++){
            for(int buy =0; buy<=1; buy++){
                Arrays.fill(dp[day][buy] ,-1);
            }
        }
        return maxProfitM(0, 1, k, prices, dp);
    }

    //Memoization solution
    private static int maxProfitM(int day, int buy, int transactionLimit, int[] prices, int[][][] dp){
        //base case
        if(day == prices.length || transactionLimit == 0) return 0;

        if(dp[day][buy][transactionLimit] != -1)    return dp[day][buy][transactionLimit];

        //recursive calls
        int profit = 0;
        if(buy == 1){
            return dp[day][buy][transactionLimit] = Math.max(
                    -prices[day] + maxProfitM(day+1, 0, transactionLimit, prices, dp),
                    maxProfitM(day+1, 1, transactionLimit, prices, dp)
            );
        }

        return dp[day][buy][transactionLimit] = Math.max(
                prices[day] + maxProfitM(day+1, 1, transactionLimit-1, prices, dp),
                maxProfitM(day+1, 0, transactionLimit, prices, dp)
        );
    }


    //Tabulation solution
    private static int maxProfitT(int[] prices, int k){
        int n = prices.length;
        int[][][] dp = new int[n+1][2][k+1];


        for(int day = n-1; day >= 0 ; day--){
            for(int buy = 0; buy <= 1; buy++){
                for(int limit = 1; limit <= k; limit++){
                    int profit = 0;
                    if(buy == 1){
                        dp[day][buy][limit] = Math.max(
                                -prices[day] + dp[day+1][0][limit],
                                dp[day+1][1][limit]
                        );
                    }else{
                        dp[day][buy][limit] = Math.max(
                                prices[day] + dp[day+1][1][limit-1],
                                dp[day+1][0][limit]
                        );
                    }
                }
            }
        }


        return dp[0][1][k];
    }


    //Space optimization solution
    private static int maxProfitSO(int[] prices, int k){
        int n = prices.length;
        int[][] ahead = new int[2][k+1];


        for(int day = n-1; day >= 0 ; day--){
            int[][] curr = new int[2][k+1];
            for(int buy = 0; buy <= 1; buy++){
                for(int limit = 1; limit <= k; limit++){
                    int profit = 0;
                    if(buy == 1){
                        curr[buy][limit] = Math.max(
                                -prices[day] + ahead[0][limit],
                                ahead[1][limit]
                        );
                    }else{
                        curr[buy][limit] = Math.max(
                                prices[day] + ahead[1][limit-1],
                                ahead[0][limit]
                        );
                    }
                }
            }

            ahead = curr;
        }


        return ahead[1][k];
    }
}
