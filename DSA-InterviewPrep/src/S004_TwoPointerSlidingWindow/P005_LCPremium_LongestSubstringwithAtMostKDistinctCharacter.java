package S004_TwoPointerSlidingWindow;
import java.util.*;
//LeetCode premium
public class P005_LCPremium_LongestSubstringwithAtMostKDistinctCharacter {
    public static void main(String[] args){
        //call from here...
        String s= new String("aaabbccd");
        int k = 2;
        System.out.println(longestSubstringAtMostKOptimised2(s,k));
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


    //Approach 2 - using optimisation with sliding window two pointer
    private static int longestSubstringAtMostKOptimised1(String s, int k){
        int maxLength = 0;
        int l = 0;
        int r = 0;
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();

        while(r < n){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            while(map.size() > k){
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                if(map.get(s.charAt(l)) == 0)     map.remove(s.charAt(l));
                l++;
            }


            if(map.size() <= k)
                maxLength = Math.max(maxLength, r-l+1);
            r++;
        }

        return maxLength;
    }

    //Approach 3 - using optimisation with sliding window two pointer and optimising the shrink logic
    private static int longestSubstringAtMostKOptimised2(String s, int k){
        int maxLength = 0;
        int l = 0;
        int r = 0;
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();

        while(r < n){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            if(map.size() > k){
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                if(map.get(s.charAt(l)) == 0)     map.remove(s.charAt(l));
                l++;
            }


            if(map.size() <= k)
                maxLength = Math.max(maxLength, r-l+1);
            r++;
        }

        return maxLength;
    }
}
