package S003_DP;
//https://leetcode.com/problems/longest-common-subsequence/
public class PC025_LC1143_LCS {
    public static void main(String[] args){
        //call from here...
    }

    //Recursive solution
    public static int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        return lcsR(n-1, m-1, text1, text2);
    }

    private static int lcsR(int index1, int index2, String text1, String text2){
        //base case
        if(index1 < 0 || index2 < 0)
            return 0;

        //match and not match cases
        if(text1.charAt(index1) == text2.charAt(index2))
            return 1 + lcsR(index1-1 , index2-1, text1, text2);

        return
                Math.max(lcsR(index1-1, index2, text1, text2),
                        lcsR(index1, index2-1, text1, text2));
    }
}
