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
}
