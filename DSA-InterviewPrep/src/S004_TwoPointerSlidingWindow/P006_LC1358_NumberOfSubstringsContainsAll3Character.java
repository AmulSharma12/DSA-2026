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
}
