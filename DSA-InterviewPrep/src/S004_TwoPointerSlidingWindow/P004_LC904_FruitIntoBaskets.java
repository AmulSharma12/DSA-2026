package S004_TwoPointerSlidingWindow;
import java.util.Set;
import java.util.HashSet;
//https://leetcode.com/problems/fruit-into-baskets/description/
public class P004_LC904_FruitIntoBaskets {
    public static void main(String[] args){
        //call from here...
    }

    //Approach 1 - using brute forces
    private static int totalFruitBrute(int[] fruits) {
        int n = fruits.length;
        int maxLength = 0;
        for(int l = 0; l<n; l++){
            Set<Integer> set = new HashSet<>();
            for(int r = l;r<n;r++){
                set.add(fruits[r]);
                if(set.size() > 2) break;
                maxLength = Math.max(maxLength, r-l+1);
            }
        }
        return maxLength;
    }
}
