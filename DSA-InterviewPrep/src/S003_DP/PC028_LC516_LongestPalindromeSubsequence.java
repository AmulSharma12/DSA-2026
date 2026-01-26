package S003_DP;
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

}
