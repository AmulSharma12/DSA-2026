package S003_DP;
//https://leetcode.com/problems/delete-operation-for-two-strings/description/
public class PC030_LC583_DeleteOperationTwoStrings {
    public static void main(String[] args){
        //call from here...
    }

    //Recursive solution
    public static int minDistance(String word1, String word2) {
        return minDistanceR(word1, word2);
    }

    private static  int minDistanceR(String word1, String word2){
        int n = word1.length();
        int m = word2.length();
        int lcs = minDistanceHelperR(n-1, m-1, word1, word2);

        //minDeletion step for both the string to make same
        int minDeletionStepForS1 = n - lcs;
        int minDeletionStepForS2 = m - lcs;
        return minDeletionStepForS1 + minDeletionStepForS2;
    }

    private static int minDistanceHelperR(int ind1, int ind2, String s1, String s2){
        if(ind1 < 0 || ind2 < 0)    return 0;

        if(s1.charAt(ind1) == s2.charAt(ind2))
            return 1 + minDistanceHelperR(ind1-1, ind2-1, s1, s2);

        return Math.max(minDistanceHelperR(ind1, ind2-1, s1, s2), minDistanceHelperR(ind1-1, ind2, s1, s2));
    }
}
