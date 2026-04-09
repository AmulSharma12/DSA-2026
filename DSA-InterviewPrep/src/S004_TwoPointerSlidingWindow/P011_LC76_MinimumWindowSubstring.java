package S004_TwoPointerSlidingWindow;
//https://leetcode.com/problems/minimum-window-substring/description/
public class P011_LC76_MinimumWindowSubstring {
    public static void main(String[] args){
        //call from here...
    }


    //Approach 1 - using brute force - generating all the subarrays.
    public static String minWindowBrute(String s, String t) {
        int n = s.length();
        int m = t.length();
        int startInd = -1;
        int minLength = Integer.MAX_VALUE;
        if(n < m)   return "";
        for(int i = 0; i<n; i++){
            int cnt = 0;
            int[] hash = new int[256];
            for(int j = 0; j<m; j++)    hash[t.charAt(j)]++;
            for(int j = i; j<n; j++){
                if(hash[s.charAt(j)] > 0)   cnt++;
                hash[s.charAt(j)]--;

                if(cnt == m){
                    if(j-i+1 < minLength){
                        minLength = j-i+1;
                        startInd = i;
                        break;
                    }
                }
            }
        }

        //System.out.println(startInd + " " + minLength);
        return minLength == Integer.MAX_VALUE ? "" : s.substring(startInd, startInd + minLength);
    }
}
