package S003_DP;
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
}
