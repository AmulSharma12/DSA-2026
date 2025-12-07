package S003_DP;
import java.util.Arrays;

public class P008_LC213_HouseRobber2 {
    public static void main(String[] args){
        //call from here...
    }

    //Recursive solution
    public static int robRecursive(int[] nums) {
        int n = nums.length;
        if(n == 1)  return nums[0];
        int part1 = robR(nums, 0, n-2);
        int part2 = robR(nums, 1, n-1);
        return Math.max(part1, part2);
    }

    private static int robR(int[] nums, int low, int high){
        if(low == high) return nums[high];
        if(low > high)  return 0;

        int pick = nums[high] + robR(nums, low, high-2);
        int notPick = 0 + robR(nums, low, high-1);

        return Math.max(pick, notPick);
    }

    //Memoization solution
    public static int rob(int[] nums) {
        int n = nums.length;
        if(n == 1)  return nums[0];
        int[] dp = new int[n];

        Arrays.fill(dp , -1);
        int part1 = robR(nums, 0, n-2, dp);
        Arrays.fill(dp,-1);
        int part2 = robR(nums, 1, n-1, dp);
        return Math.max(part1, part2);
    }

    private static int robR(int[] nums, int low, int high, int[] dp){
        if(low == high) return nums[high];
        if(low > high)  return 0;
        if(dp[high] != -1)  return dp[high];

        int pick = nums[high] + robR(nums, low, high-2, dp);
        int notPick = 0 + robR(nums, low, high-1, dp);

        return dp[high] = Math.max(pick, notPick);
    }
}
