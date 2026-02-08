package S003_DP;
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
}
