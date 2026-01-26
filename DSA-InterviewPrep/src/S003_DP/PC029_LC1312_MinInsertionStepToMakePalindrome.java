package S003_DP;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
public class PC029_LC1312_MinInsertionStepToMakePalindrome {
    public static void main(String[] args){
        //call from here..
    }

    //Recursive solution
    public static int minInsertions(String s) {
        StringBuilder s2 = new StringBuilder(s);
        return minInsertionsR(s, s2.reverse().toString());
    }

    private static int minInsertionsR(String s1, String s2){
        int n = s1.length();
        int m = s2.length();

        int lps = lcsR(n-1, m-1, s1, s2);
        return n - lps;
    }

    private static int lcsR(int index1, int index2, String s1, String s2){
        //base case
        if(index1 < 0 || index2 < 0)    return 0;


        if(s1.charAt(index1) == s2.charAt(index2))
            return 1 + lcsR(index1-1 , index2 - 1, s1, s2);

        return Math.max(lcsR(index1, index2-1, s1, s2), lcsR(index1-1, index2, s1, s2));
    }

    //Memoization solution
    private static int minInsertionsM(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int[][] cache = new int[n][m];
        for(int[] cacheRow:cache){
            Arrays.fill(cacheRow,-1);
        }
        int lps = lcsM(n-1, m-1, s1, s2, cache);
        return n - lps;
    }

    private static int lcsM(int index1, int index2, String s1, String s2, int[][] cache){
        //base case
        if(index1 < 0 || index2 < 0)    return 0;
        if(cache[index1][index2] != -1)     return cache[index1][index2];

        if(s1.charAt(index1) == s2.charAt(index2))
            return cache[index1][index2] = 1 + lcsM(index1-1 , index2 - 1, s1, s2, cache);

        return cache[index1][index2] = Math.max(
                lcsM(index1, index2-1, s1, s2,cache), lcsM(index1-1, index2, s1, s2,cache)
        );
    }

    //Tabulation solution
    private static int minInsertionsTabulation(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int[][] cache = new int[n+1][m+1];

        for(int ind1 = 1; ind1 <=n; ind1++){
            for(int ind2 = 1; ind2 <= m ;ind2 ++){
                if(s1.charAt(ind1-1) == s2.charAt(ind2-1))
                    cache[ind1][ind2] = 1 + cache[ind1-1][ind2-1];
                else
                    cache[ind1][ind2] = Math.max(cache[ind1][ind2-1], cache[ind1-1][ind2]);
            }
        }

        int lps = cache[n][m];
        return n - lps;
    }
}
