package S003_DP;
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
}
