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


    //Approach  2 - using TP-SW using some maths logic
    public static int numSubarraysWithSumOptimized(int[] nums, int goal) {
        return helper(nums, goal) - helper(nums, goal-1);
    }

    private static int helper(int[] nums, int goal){
        if(goal < 0)    return 0;

        int l = 0;
        int r = 0;
        int cnt = 0;
        int sum = 0;
        int n = nums.length;
        while(r < n){
            sum += nums[r];

            while(sum > goal){
                sum -= nums[l];
                l++;
            }

            cnt += (r-l+1);
            r++;
        }

        return cnt;
    }
}
