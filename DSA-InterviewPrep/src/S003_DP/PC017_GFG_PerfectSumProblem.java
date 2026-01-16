package S003_DP;
import java.util.Arrays;
public class PC017_GFG_PerfectSumProblem {
    public static void main(String[] args){
        //call from here...
    }

    //Recursive solution
    public static int perfectSum(int[] nums, int target) {
        int n = nums.length-1;
        return subsequenceWithTargetR(n, target, nums);

    }

    private static int subsequenceWithTargetR(int index, int target, int[] nums){

        //Base case
        if(index == 0){
            if(target == 0 && nums[0] == 0)  return 2;
            if(target == 0)  return 1;
            if(nums[0] == target)    return 1;
            return 0;
        }


        int notTake = subsequenceWithTargetR(index-1, target, nums);
        int take = 0;
        if(nums[index] <= target)
            take = subsequenceWithTargetR(index-1, target-nums[index], nums);

        return take + notTake;
    }

    //Memoization solution
    public static int perfectSumM(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int [n][target+1];
        for(int[] dpRow: dp){
            Arrays.fill(dpRow,-1);
        }
        return subsequenceWithTargetM(n-1, target, nums, dp);

    }

    private static int subsequenceWithTargetM(int index, int target, int[] nums, int[][] dp){

        //Base case
        if(index == 0){
            if(target == 0 && nums[0] == 0)  return 2;
            if(target == 0)  return 1;
            if(nums[0] == target)    return 1;
            return 0;
        }

        if(dp[index][target] != -1) return dp[index][target];

        int notTake = subsequenceWithTargetM(index-1, target, nums, dp);
        int take = 0;
        if(nums[index] <= target)
            take = subsequenceWithTargetM(index-1, target-nums[index], nums, dp);

        return dp[index][target] = take + notTake;
    }

    //Memoization solution
    private static int subsequenceWithTargetT(int[] nums, int n, int k){
        int[][] dp = new int[n][k+1];

        if(nums[0] <= k) dp[0][nums[0]] = 1;
        dp[0][0] = nums[0] == 0 ? 2 : 1;
        for(int index = 1; index < n; index++){
            for(int target = 0; target <=k; target++){

                int notTake = dp[index-1][target];
                int take = 0;

                if(nums[index] <= target)
                    take = dp[index-1][target-nums[index]];

                dp[index][target] = take + notTake;
            }
        }

        return dp[n-1][k];
    }

    //Space Optimization solution
    private static int subsequenceWithTargetSO(int[] nums, int n, int k){
        int[] prev = new int[k+1];

        if(nums[0] <= k) prev[nums[0]] = 1;
        prev[0] = nums[0] == 0 ? 2 : 1;

        for(int index = 1; index < n; index++){
            int[] curr = new int[k+1];
            for(int target = 0; target <=k; target++){

                int notTake = prev[target];
                int take = 0;

                if(nums[index] <= target)
                    take = prev[target-nums[index]];

                curr[target] = take + notTake;
            }
            prev = curr;
        }


        return prev[k];
    }
}
