package S003_DP;

import java.util.Arrays;

//https://leetcode.com/problems/distinct-subsequences/description/
public class PC032_LC115_DistinctSubsequences {
    public static void main(String[] args){
        //call from here...
    }

    //Recursive solution
    public static int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        return numDistinctR(n-1, m-1, s, t);
    }

    private static int numDistinctR(int ind1, int ind2, String s, String t){
        if(ind2 < 0)    return 1;
        if(ind1 < 0)    return 0;

        if(s.charAt(ind1) == t.charAt(ind2))
            return numDistinctR(ind1-1, ind2-1, s, t) + numDistinctR(ind1-1, ind2, s, t);

        return numDistinctR(ind1-1, ind2, s, t);
    }


    public int numDistinctM(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n][m];
        for(int[] dpRow: dp){
            Arrays.fill(dpRow,-1);
        }
        return numDistinctM(n-1, m-1, s, t, dp);
    }

    private int numDistinctM(int ind1, int ind2, String s, String t,int[][] dp){
        if(ind2 < 0)    return 1;
        if(ind1 < 0)    return 0;
        if(dp[ind1][ind2] != -1)    return dp[ind1][ind2];

        if(s.charAt(ind1) == t.charAt(ind2))
            return dp[ind1][ind2] = numDistinctM(ind1-1, ind2-1, s, t, dp) + numDistinctM(ind1-1, ind2, s, t, dp);

        return dp[ind1][ind2] = numDistinctM(ind1-1, ind2, s, t, dp);
    }

    //Tabulation solution
    private static int numDistinctT(String s, String t){
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n+1][m+1];

        for(int i = 0; i<=n; i++)    dp[i][0] = 1;

        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=m; j++){
                if(s.charAt(i-1) == t.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][m];
    }
}
