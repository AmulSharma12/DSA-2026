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
}
