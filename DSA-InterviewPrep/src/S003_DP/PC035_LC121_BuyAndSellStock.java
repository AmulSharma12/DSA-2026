package S003_DP;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
public class PC035_LC121_BuyAndSellStock {
    public static void main(String[] args){
        //call from here...
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int mini = prices[0];
        int maxProfit = 0;

        for(int ind = 1; ind < n; ind++){
            maxProfit = Math.max(maxProfit,  prices[ind] - mini);
            mini = Math.min(mini, prices[ind]);
        }
        return maxProfit;
    }
}
