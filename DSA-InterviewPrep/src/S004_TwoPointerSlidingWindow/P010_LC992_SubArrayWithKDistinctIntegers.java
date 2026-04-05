package S004_TwoPointerSlidingWindow;
import java.util.Set;
import java.util.HashSet;
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
}
