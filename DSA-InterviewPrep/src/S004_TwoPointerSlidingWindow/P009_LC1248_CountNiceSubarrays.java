package S004_TwoPointerSlidingWindow;
//https://leetcode.com/problems/count-number-of-nice-subarrays/
public class P009_LC1248_CountNiceSubarrays {
    public static void main(String[] args){
        //call from here...
    }

    //Approach 1 - using brute naive solution - generating all subarrays
    private static int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int cnt = 0;
        for(int i = 0; i<n; i++){
            int oddCount = 0;

            for(int j = i; j<n; j++){
                if(nums[j] % 2 != 0)    oddCount++;

                if(oddCount == k){
                    cnt++;
                }
            }
        }

        return cnt;
    }


    //Approach 2 - using TP-SW and by using maths logic based on previous binary problem
    public static int numberOfSubarraysOptimized(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k-1);
    }

    private static int helper(int[] nums, int k){
        if(k < 0)   return 0;

        int l = 0;
        int r = 0;
        int cnt = 0;
        int sum = 0;
        int n = nums.length;

        while(r < n){
            sum += nums[r]%2 == 0 ? 0 : 1;

            while(sum > k){
                sum -= nums[l]%2 == 0 ? 0 : 1;
                l++;
            }

            cnt += (r-l+1);
            r++;
        }

        return cnt;
    }
}
