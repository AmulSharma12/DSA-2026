package S003_DP;
import java.util.Arrays;

public class P001_LC509_Fibbonaci {
    public static void main(String[] args){

    }

    //recursive way
    public static int fib(int n) {
        if(n <= 1)   return n;
        return fib(n - 1) + fib(n - 2);
    }

    //Memoize way
    public int fibMemoize(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return fibbonaci(n, dp);
    }

    private int fibbonaci(int n , int[] dp){
        if(n <= 1)   return n;
        if(dp[n] != -1)   return dp[n];
        System.out.println(n + "----------");
        return dp[n] =  fibbonaci(n-1, dp) + fibbonaci(n -2 , dp);
    }


    //Tabulation way
    public int fibWithTabulation(int n) {
        if(n <= 1)  return n;
        int[] dp = new int[n+1];

        dp[0] = 0; dp[1] = 1;
        for(int i = 2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    //space optimization way
    public int fibWithSpaceOptimization(int n) {
        if(n<=1) return n;
        int prev2 = 0;
        int prev = 1;

        for(int i = 2; i<=n; i++){
            int curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
