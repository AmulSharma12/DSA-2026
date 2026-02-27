package S003_DP;

import java.util.Arrays;

//https://leetcode.com/problems/palindrome-partitioning-ii/
public class PC053_LC132_PalindromePartition2 {
    public static void main(String[] args){
        //call from here...
    }

    //recursive solution
    public static int minCutR(String s) {
        int n = s.length();
        return minCutRecursive(0, n, s) - 1;
    }

    private static boolean isPalindrome(int i, int j, String s){
        while(i < j)    {
            if(s.charAt(i) != s.charAt(j))  return false;
            i++;
            j--;
        }

        return true;
    }

    private static int minCutRecursive(int ind, int n, String s){
        if(ind == n)    return 0;

        int minCost = Integer.MAX_VALUE;

        for(int j = ind; j < n; j++){
            if(isPalindrome(ind,j, s)){
                int cost = 1 + minCutRecursive(j+1, n, s);
                minCost = Math.min(minCost, cost);
            }
        }

        return minCost;
    }

    //Memoization solution
    public static int minCutMem(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return minCutMemoize(0, n, s, dp) - 1;
    }


    private static int minCutMemoize(int ind, int n, String s, int[] dp){
        if(ind == n)    return 0;
        if(dp[ind] != -1)   return dp[ind];


        int minCost = Integer.MAX_VALUE;

        for(int j = ind; j < n; j++){
            if(isPalindrome(ind,j, s)){
                int cost = 1 + minCutMemoize(j+1, n, s, dp);
                minCost = Math.min(minCost, cost);
            }
        }

        return dp[ind] = minCost;
    }

    //Tabulation solution
    public static int minCutTab(String s) {
        return minCutTabulation(s, s.length());
    }



    private  static int minCutTabulation(String s, int n){
        int[] dp = new int[n+1];

        for(int ind = n-1; ind >= 0; ind--){
            int minCost = Integer.MAX_VALUE;
            for(int j = ind; j < n; j++){
                if(isPalindrome(ind,j, s)){
                    int cost = 1 + dp[j+1];
                    minCost = Math.min(minCost, cost);
                }
            }

            dp[ind] = minCost;
        }

        return dp[0] - 1;
    }
}
