package S003_DP;
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
}
