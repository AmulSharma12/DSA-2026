package S003_DP;

import java.util.Arrays;

public class PC034_LC44_WildCardMatching {
    public static void main(String[] args){
        //call from here...
    }

    //Recursive solution
    public static boolean isMatchREC(String s, String p) {
        int n = s.length();
        int m = p.length();
        return isMatchR(n-1, m-1, s, p);
    }

    private static boolean isMatchR(int i, int j, String s, String p){
        //base case
        if(i<0 && j < 0)    return true;
        if(j<0 && i>=0)     return false;
        if(i<0 && j>=0){
            for(int ind = 0; ind<=j; ind++){
                if(p.charAt(ind) != '*')    return false;
            }
            return true;
        }

        //if equal or ?
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
            return isMatchR(i-1, j-1, s, p);
        if(p.charAt(j) == '*')
            return isMatchR(i, j-1, s, p) || isMatchR(i-1, j, s, p);

        return false;
    }


    //Memoization solution
    public static boolean isMatchM(String s, String p) {
        int n = s.length();
        int m = p.length();
        int[][] cache = new int[n][m];
        for(int[] cacheRow:cache){
            Arrays.fill(cacheRow,-1);
        }
        return isMatchMemoize(n-1, m-1, s, p, cache);
    }

    private static boolean isMatchMemoize(int i, int j, String s, String p, int[][] cache){
        //base case
        if(i<0 && j < 0)    return true;
        if(j<0 && i>=0)     return false;
        if(i<0 && j>=0){
            for(int ind = 0; ind<=j; ind++){
                if(p.charAt(ind) != '*')    return false;
            }
            return true;
        }

        if(cache[i][j] != -1)    return cache[i][j] == 1? true : false;

        //if equal or ?
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            boolean matchingCase = isMatchMemoize(i-1, j-1, s, p, cache);
            cache[i][j] = matchingCase == true ? 1 : 0;
            return matchingCase;
        }

        if(p.charAt(j) == '*'){
            boolean asterickCase = isMatchMemoize(i, j-1, s, p, cache) || isMatchMemoize(i-1, j, s, p,cache);
            cache[i][j]  = asterickCase == true ? 1 : 0;
            return asterickCase;

        }

        cache[i][j] = 0;
        return false;
    }


    //Tabulation solution
    private static boolean isMatchT(int n, int m, String s, String p){
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;

        for(int i = 1; i<=n; i++){
            dp[i][0] = false;
        }

        for(int j = 1; j<=m; j++){
            boolean flag = true;
            for(int ind = 1; ind <= j; ind++){
                if(p.charAt(ind-1) != '*'){
                    flag = false;
                    break;
                }
            }

            dp[0][j] = flag;
        }

        //exploring the states
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=m; j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?')
                    dp[i][j] = dp[i-1][j-1];
                else if(p.charAt(j-1) == '*')
                    dp[i][j] = dp[i][j-1] | dp[i-1][j];
                    // case 1 - if * treat as the empty string  so will look in the remaing pattern
                    //   s ->  abc    p -> x*  then then abc will be compared with x
                    // case 2 - if * treat as one matching string
                else
                    dp[i][j] = false;
            }
        }

        return dp[n][m];
    }
}
