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
}
