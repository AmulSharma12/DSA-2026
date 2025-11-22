package S003_DP;

import java.util.Arrays;

public class P004_LC1137_TribonacciNumber {
    public static void main(String[] args){
        //call from here...
    }

    //Recursive solution
    public static int tribonacciR(int n) {
        if(n == 0)   return 0;
        if(n <= 2)  return 1;
        return tribonacciR(n-1) + tribonacciR(n - 2) + tribonacciR(n - 3);
    }

    //Memoization solution
    public int tribonacciMemoize(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, - 1);
        return tribonacciM(n, dp);
    }

    private int tribonacciM(int n, int[] dp)
    {
        if(n == 0)  return 0;
        if(n <= 2)  return 1;

        if(dp[n] != - 1)    return dp[n];

        return  dp[n] = tribonacciM(n - 1, dp) + tribonacciM(n - 2, dp) + tribonacciM(n - 3, dp);
    }

    //Tabulation solution
    private int tribonacciUsingTabulation(int n){
        if(n == 0)  return 0;
        if(n <= 2)  return 1;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = dp[2] = 1;

        for(int i = 3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        return dp[n];
    }

    //Space Optimization solution
    private static int tribonacciUsingSO(int n){
        if(n == 0)  return 0;
        if(n <= 2)  return 1;

        int prev = 1;
        int prev2 = 1;
        int prev3 = 0;

        for(int i = 3; i<=n; i++){
            int curr = prev + prev2 + prev3;
            prev3 = prev2;
            prev2 = prev;
            prev = curr;
        }

        return prev;
    }
}
