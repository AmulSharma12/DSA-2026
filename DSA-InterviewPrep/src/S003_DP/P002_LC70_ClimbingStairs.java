package S003_DP;
import java.util.Arrays;
public class P002_LC70_ClimbingStairs {
    public static void main(String[] args){
        //call from here..
    }

    //recursive way - TLE
    public static int climbStairsRecursive(int n) {
        if(n == 0)  return 1;
        if(n < 0)   return 0;

        int oneStep = climbStairsRecursive(n - 1);
        int twoStep = climbStairsRecursive(n - 2);

        return oneStep + twoStep;
    }

    //Memoize way
    public static int climbStairsM(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return climbStairsUsingMemoization(n, dp);
    }

    public static int climbStairsUsingMemoization(int n,int[] dp) {
        if(n == 0)  return 1;
        if(n < 0)   return 0;

        if(dp[n] != -1)  return dp[n];
        int oneStep = climbStairsUsingMemoization(n - 1, dp);
        int twoStep = climbStairsUsingMemoization(n - 2, dp);

        return dp[n] = oneStep + twoStep;
    }
}
