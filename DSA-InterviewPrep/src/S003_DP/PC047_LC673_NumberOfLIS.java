package S003_DP;
import java.util.Arrays;
//https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/
public class PC047_LC673_NumberOfLIS {
    public static void main(String[] args){
        //call from here...
    }

    //tracking cnt along with LIS
    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int maxi = 1;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(cnt, 1);

        for(int ind = 0; ind < n; ind++){
            for(int prevInd = 0; prevInd < ind; prevInd++){
                if(nums[ind] > nums[prevInd] && 1+dp[prevInd] > dp[ind]){
                    dp[ind] = 1 + dp[prevInd];
                    cnt[ind] = cnt[prevInd];
                }
                else if(nums[ind] > nums[prevInd] && 1 + dp[prevInd] == dp[ind]){
                    cnt[ind] += cnt[prevInd];
                }
            }

            maxi = Math.max(maxi, dp[ind]);
        }

        int totalCount = 0;
        for(int ind = 0; ind < n; ind++){
            if(dp[ind] == maxi)
                totalCount += cnt[ind];
        }

        return totalCount;
    }
}
