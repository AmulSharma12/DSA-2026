package S004_TwoPointerSlidingWindow;
import java.util.*;
//https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/
public class P006_LC1358_NumberOfSubstringsContainsAll3Character {
    public static void main(String[] args){
        //call from here...
    }

    //Approach 1  - using naive solution
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int numberOfSubstrings = 0;
        for(int l = 0; l<n; l++){
            Set<Character> set = new HashSet<Character>();
            for(int r = l; r<n; r++){
                set.add(s.charAt(r));
                if(set.size() < 3)  continue;
                numberOfSubstrings++;
            }
        }

        return numberOfSubstrings;
    }


    //Approach 2 - optimizattion
    private static int numberOfSubstringsOptimized(String s) {
        int[] lastseen = new int[3];
        Arrays.fill(lastseen,-1);
        int n = s.length();
        int count = 0;
        for(int ind = 0; ind <n; ind++){
            lastseen[s.charAt(ind) - 'a'] = ind;
            if(lastseen[0] != -1 && lastseen[1] !=-1 && lastseen[2] !=-1)
                count += 1 + Math.min(lastseen[0], Math.min(lastseen[1], lastseen[2]));
        }

        return count;
    }
}
