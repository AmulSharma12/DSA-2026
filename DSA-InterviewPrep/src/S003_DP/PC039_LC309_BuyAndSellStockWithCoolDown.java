package S003_DP;
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
}
