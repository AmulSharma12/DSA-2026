package S003_DP;

import java.util.Arrays;

//https://leetcode.com/problems/edit-distance/
public class PC033_LC72_EditDistance {
    public static void main(String[] args){
        //call from here...
    }

    //Recursive solution
    public static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        return editDistanceR(n-1, m-1, word1, word2);
    }

    private static int editDistanceR(int i, int j, String s1, String s2){
        if(i < 0)   return j + 1;
        if(j < 0)   return i + 1;

        if(s1.charAt(i) == s2.charAt(j))
            return editDistanceR(i-1, j-1, s1, s2);

        return 1 + Math.min(
                editDistanceR(i,j-1,s1,s2),
                Math.min(editDistanceR(i-1, j, s1, s2), editDistanceR(i-1, j-1, s1, s2))
        );
}

    public static int minDistanceM(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] cache = new int[n][m];
        for(int [] cacheRow: cache){
            Arrays.fill(cacheRow, -1);
        }
        return editDistanceM(n-1, m-1, word1, word2, cache);
    }

    private static int editDistanceM(int i, int j, String s1, String s2, int[][] cache){
        if(i < 0)   return j + 1;
        if(j < 0)   return i + 1;
        if(cache[i][j] != -1) return cache[i][j];

        if(s1.charAt(i) == s2.charAt(j))
            return cache[i][j] = editDistanceM(i-1, j-1, s1, s2, cache);

        return cache[i][j] = 1 + Math.min(
                editDistanceM(i,j-1,s1,s2, cache),
                Math.min(editDistanceM(i-1, j, s1, s2, cache), editDistanceM(i-1, j-1, s1, s2, cache))
        );
    }

    //tabulation solution
    private static int editDistanceT(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        //base case
        for(int j = 0; j<=m; j++)   dp[0][j] = j;
        for(int i = 0; i<=n; i++)   dp[i][0] = i;


        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = 1+Math.min(dp[i-1][j-1],Math.min(dp[i][j-1], dp[i-1][j]));
            }
        }

        return dp[n][m];
    }
}
