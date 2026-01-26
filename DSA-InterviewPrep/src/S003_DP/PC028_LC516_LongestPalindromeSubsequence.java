package S003_DP;

import java.util.Arrays;

//https://leetcode.com/problems/longest-palindromic-subsequence/description/
public class PC028_LC516_LongestPalindromeSubsequence {
    public static void main(String[] args){
        //call from here...
    }

    //Recursive solution
    public static int longestPalindromeSubseq(String s) {
        StringBuilder rev = new StringBuilder(s);
        return lcsRecursive(s, rev.reverse().toString());
    }

    private static int lcsRecursive(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        return lcsHelper(n-1, m-1, s1, s2);
    }

    private static int lcsHelper(int ind1, int ind2, String s1, String s2){
        //base case
        if(ind1 < 0 || ind2 < 0)    return 0;

        if(s1.charAt(ind1) == s2.charAt(ind2))
            return 1 + lcsHelper(ind1-1, ind2-1, s1, s2);

        return Math.max(
                lcsHelper(ind1, ind2-1, s1, s2),
                lcsHelper(ind1-1, ind2, s1, s2)
        );
    }


    //Memoization solution
    private static int lcsMemoize(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int[][] cache = new int[n][m];
        for(int[] cacheRow: cache){
            Arrays.fill(cacheRow,-1);
        }
        return lcsHelperM(n-1, m-1, s1, s2, cache);
    }

    private static int lcsHelperM(int ind1, int ind2, String s1, String s2, int[][] cache){
        //base case
        if(ind1 < 0 || ind2 < 0)    return 0;

        if(cache[ind1][ind2] != -1)     return cache[ind1][ind2];

        if(s1.charAt(ind1) == s2.charAt(ind2))
            return 1 + lcsHelperM(ind1-1, ind2-1, s1, s2, cache);

        return cache[ind1][ind2] = Math.max(
                lcsHelperM(ind1, ind2-1, s1, s2, cache),
                lcsHelperM(ind1-1, ind2, s1, s2, cache)
        );
    }

    //Tabulation solution
    private static int lcsTabulation(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];

        for(int ind1 = 1; ind1 <= n; ind1++){
            for(int ind2 = 1; ind2 <= m; ind2++){
                if(s1.charAt(ind1 - 1) == s2.charAt(ind2-1))
                    dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
                else
                    dp[ind1][ind2] = Math.max(dp[ind1][ind2-1] , dp[ind1-1][ind2]);
            }
        }

        return dp[n][m];
    }

    //Space optimization solution
    private static int lcsSO(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int[] prev = new int[m+1];

        for(int ind1 = 1; ind1 <= n; ind1++){
            int[] curr = new int[m+1];
            for(int ind2 = 1; ind2 <= m; ind2++){
                if(s1.charAt(ind1 - 1) == s2.charAt(ind2-1))
                    curr[ind2] = 1 + prev[ind2-1];
                else
                    curr[ind2] = Math.max(curr[ind2-1] , prev[ind2]);
            }
            prev = curr;
        }

        return prev[m];
    }

}
