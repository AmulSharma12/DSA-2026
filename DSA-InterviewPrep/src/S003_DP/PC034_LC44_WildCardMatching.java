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
}
