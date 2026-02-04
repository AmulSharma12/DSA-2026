package S003_DP;
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
}}
