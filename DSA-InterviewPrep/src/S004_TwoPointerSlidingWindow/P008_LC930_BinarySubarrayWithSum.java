package S004_TwoPointerSlidingWindow;
//https://leetcode.com/problems/binary-subarrays-with-sum/
public class P008_LC930_BinarySubarrayWithSum {
    public static void main(String[] args){
        //call from here...
    }

    //Approach 1 - using brute - generating all subarrays
    private static int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int cnt = 0;
        for(int i = 0; i<n; i++){
            int sum = 0;
            for(int j = i; j<n; j++){
                sum += nums[j];
                if(sum > goal)  break;
                if(sum == goal) cnt++;
            }
        }

        return cnt;
    }
}
