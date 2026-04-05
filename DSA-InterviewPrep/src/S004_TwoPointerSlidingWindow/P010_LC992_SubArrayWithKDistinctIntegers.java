package S004_TwoPointerSlidingWindow;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;
//https://leetcode.com/problems/subarrays-with-k-different-integers/
public class P010_LC992_SubArrayWithKDistinctIntegers {
    public static void main(String[] args){
        //call from here...
    }

    //Approach 1 - using brute force - generating all subarray
    public static int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        int cnt = 0;
        for(int i = 0; i<n; i++){
            Set<Integer> set = new HashSet<Integer>();
            for(int j = i; j<n; j++){
                set.add(nums[j]);
                if(set.size() > k)  break;
                if(set.size() == k) cnt++;
            }
        }

        return cnt;
    }


    //Approach 2 - using TP-SW (using maths logic)
    private static  int subarraysWithKDistinctOptimized(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k-1);
    }

    private static int helper(int[] nums, int k){
        int n = nums.length;
        int l = 0;
        int r = 0;
        int cnt = 0;
        if(k < 0)  return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(r < n){
            map.put(nums[r], map.getOrDefault(nums[r], 0)+1);
            while(map.size() > k){
                map.put(nums[l], map.getOrDefault(nums[l],0)-1);
                if(map.get(nums[l]) == 0)
                    map.remove(nums[l]);
                l++;
            }

            if(map.size() <= k)
                cnt += (r-l+1);
            r++;
        }

        return cnt;
    }
}
