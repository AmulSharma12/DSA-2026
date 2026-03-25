package S004_TwoPointerSlidingWindow;
import java.util.*;
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


    //Approach 2 - using sliding window
    private static int totalFruitUsingSlidingWindow(int[] fruits) {
        int l = 0;
        int r = 0;
        int maxLength = 0;
        int n = fruits.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        //logic
        while(r < n){
            int key = fruits[r];
            map.put(key, map.getOrDefault(key, 0) + 1);
            if(map.size() > 2){
                while(map.size() > 2){
                    int leftKey = fruits[l];
                    map.put(leftKey, map.get(leftKey) - 1);
                    if(map.get(leftKey) == 0){
                        map.remove(leftKey);
                    }

                    l++;
                }

            }

            if(map.size() <= 2)
                maxLength = Math.max(maxLength , r-l+1);

            r++;
        }

        return maxLength;
    }
}
