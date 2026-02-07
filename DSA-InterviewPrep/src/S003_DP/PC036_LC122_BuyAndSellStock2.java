package S003_DP;
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
}
