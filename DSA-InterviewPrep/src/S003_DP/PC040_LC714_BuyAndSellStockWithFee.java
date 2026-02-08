package S003_DP;
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
}
