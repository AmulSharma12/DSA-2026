package S004_TwoPointerSlidingWindow;
import java.util.*;
//LeetCode premium
public class P005_LCPremium_LongestSubstringwithAtMostKDistinctCharacter {
    public static void main(String[] args){
        //call from here...
        String s= new String("aaabbccd");
        int k = 2;
        System.out.println(longestSubstringAtMostKBrute(s,k));
    }

    //Approach 1 - using naive solution
    private static int longestSubstringAtMostKBrute(String s, int k){
        int maxLength = 0;
        int n = s.length();
        for(int l = 0; l <n;l++){
            Set<Character> set = new HashSet<Character>();
            for(int r = l; r < n; r++){
                set.add(s.charAt(r));
                if(set.size() > k)  break;

                if(set.size() <= k)
                    maxLength = Math.max(maxLength, r-l+1);
            }
        }
        return maxLength;
    }
}
