package S004_TwoPointerSlidingWindow;

import java.util.Arrays;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class P002_LC3_LongestSubstringWithoutRepeatingChar {
    public static void main(String[] args){
        //call from here...
    }

    private static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] hash = new int[256];
        Arrays.fill(hash, -1);
        int l = 0;
        int r = 0;
        int maxLength = Integer.MIN_VALUE;

        while(r < n){
            int asci = s.charAt(r);
            if(hash[asci] != -1){
                //means checking for duplicate exist in current window of l....r
                if(hash[asci] >= l){
                    l = hash[asci] + 1;
                }
            }

            //now computing current window length and updating maxLength
            maxLength = Math.max(maxLength , r-l+1);
            hash[asci] = r;
            r++;
        }

        return maxLength;
    }
}
