package S003_DP;
import java.util.Arrays;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
public class PC039_LC309_BuyAndSellStockWithCoolDown {
    public static void main(String[] args){
        //call from here...
    }

    //Recursive solution
    public static int maxProfitRec(int[] prices) {
        return maxProfitR(0, 1, prices);
    }

    private static int maxProfitR(int day, int buy, int[] prices){
        //base case
        if(day >= prices.length) return 0;

        //recursive call
        if(buy == 1){
            return Math.max(
                    -prices[day] + maxProfitR(day+1, 0, prices),
                    maxProfitR(day+1, 1, prices)
            );
        }


        return Math.max(
                prices[day] + maxProfitR(day+2, 1, prices),
                maxProfitR(day+1, 0, prices)
        );
    }


    //Memoization solution
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] dpRow: dp){
            Arrays.fill(dpRow,-1);
        }
        return maxProfitM(0, 1, prices, dp);
    }

    private static int maxProfitM(int day, int buy, int[] prices, int[][] dp){
        //base case
        if(day >= prices.length) return 0;

        if(dp[day][buy] != -1)  return dp[day][buy];

        //recursive call
        if(buy == 1){
            return dp[day][buy] = Math.max(
                    -prices[day] + maxProfitM(day+1, 0, prices,dp),
                    maxProfitM(day+1, 1, prices, dp)
            );
        }


        return dp[day][buy] =  Math.max(
                prices[day] + maxProfitM(day+2, 1, prices, dp),
                maxProfitM(day+1, 0, prices, dp)
        );
    }


    //Tabulation solution
    private static int maxProfitT(int[] prices, int n){
        int[][] dp = new int[n+2][2];

        for(int day = n-1; day>=0; day--){
            for(int buy = 0; buy<=1; buy++){
                if(buy == 1){
                    dp[day][buy] = Math.max(
                            -prices[day] + dp[day+1][0],
                            dp[day+1][1]
                    );
                }else{
                    dp[day][buy] = Math.max(
                            prices[day] + dp[day+2][1],
                            dp[day+1][0]
                    );
                }
            }
        }

        return dp[0][1];
    }

    //Space optimization solution
    private  static int maxProfitSO(int[] prices, int n){
        int[] front2 = new int[2];
        int[] front1 = new int[2];

        for(int day = n-1; day>=0; day--){
            int[] curr = new int[2];
            for(int buy = 0; buy<=1; buy++){
                if(buy == 1){
                    curr[buy] = Math.max(
                            -prices[day] + front1[0],
                            front1[1]
                    );
                }else{
                    curr[buy] = Math.max(
                            prices[day] + front2[1],
                            front1[0]
                    );
                }


            }
            front2 = front1;
            front1 = curr;
        }

        return front1[1];
    }
}
