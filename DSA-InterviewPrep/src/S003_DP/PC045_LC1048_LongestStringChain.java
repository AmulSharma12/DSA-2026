package S003_DP;
import java.util.Arrays;
//https://leetcode.com/problems/longest-string-chain/description/
public class PC045_LC1048_LongestStringChain {
    public static void main(String[] args){
        //call from here...
    }

    //Tabulation method to check for the longest string chain just LIS with some adjustments
    public static int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp , 1);
        int maxi = 1;

        for(int ind = 1; ind < n; ind++){
            for(int prevInd = 0; prevInd < ind; prevInd++){
                if(checkPossible(words[ind], words[prevInd]) &&  1+dp[prevInd] > dp[ind]){
                    dp[ind] = 1 + dp[prevInd];
                }
            }

            maxi = Math.max(maxi, dp[ind]);
        }

        return maxi;
    }


    public static boolean checkPossible(String s1, String s2){
        int actualStringLen = s1.length();
        int prevStringLen = s2.length();
        if(actualStringLen != prevStringLen+1)    return false;
        // a ab/ac something this should only pass
        // a abc/axy/ahiy this shoule not even check because there is more than 1 character

        int ind = 0;
        int prevInd = 0;
        while(ind < actualStringLen){
            if(prevInd < prevStringLen && s1.charAt(ind) == s2.charAt(prevInd)){
                ind++;
                prevInd++;
            }
            else{
                ind++;
            }
        }

        if(ind == actualStringLen && prevInd == prevStringLen)  return true;

        return false;
    }
}
