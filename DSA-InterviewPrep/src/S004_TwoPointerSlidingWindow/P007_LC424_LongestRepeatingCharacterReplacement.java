package S004_TwoPointerSlidingWindow;
import java.util.*;
//https://leetcode.com/problems/longest-repeating-character-replacement/description/
public class P007_LC424_LongestRepeatingCharacterReplacement {
    public static void main(String[] args){
        //call from here...
    }

    //Approach 1-using brute
    private static int characterReplacementBrute(String s, int k) {
        int n = s.length();
        int maxLength = 0;
        int maxF = 0;

        for(int i = 0; i<n; i++){
            int[] hash = new int[26];
            for(int j = i; j<n; j++){
                hash[s.charAt(j) - 'A']++;
                maxF = Math.max(maxF, hash[s.charAt(j) - 'A']);
                if((j-i+1) - maxF <= k)
                    maxLength = Math.max(maxLength, j-i+1);
                else break;
            }
        }


        return maxLength;
    }


    //Approach 2 - using optimization two pointer and sliding window
    private static int characterReplacementOptimized(String s, int k) {
        int n = s.length();
        int l = 0;
        int r = 0;
        int maxFreq = 0;
        int maxLen = 0;
        int[] hash = new int[26];

        while(r < n){
            hash[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq, hash[s.charAt(r)-'A']);
            while((r-l+1) - maxFreq > k){
                hash[s.charAt(l)-'A']--;
                maxFreq = 0;
                for(int ind = 0; ind < 26; ind++){
                    maxFreq = Math.max(maxFreq, hash[ind]);
                }
                l++;
            }

            if((r-l+1)-maxFreq <= k)
                maxLen = Math.max(maxLen, (r-l+1));

            r++;
        }

        return maxLen;
    }
}
