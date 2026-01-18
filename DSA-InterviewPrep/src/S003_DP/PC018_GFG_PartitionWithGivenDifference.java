package S003_DP;
import java.util.Arrays;
//https://www.geeksforgeeks.org/problems/partitions-with-given-difference/1
public class PC018_GFG_PartitionWithGivenDifference {
    public static void main(String[] args){
        //call from here..
    }

    //Recursive solution
    public static int countPartitionsR(int[] arr, int diff) {
        int n = arr.length;
        int totalSum = 0;
        for(int index = 0; index < n; index++) totalSum += arr[index];

        if((totalSum - diff < 0) || (totalSum - diff) % 2 != 0) return 0;
        return countPartitionRecursiveR(n-1, arr, (totalSum-diff)/2);

    }


    private static int countPartitionRecursiveR(int index, int[] nums, int target){

        if(index == 0){
            if(target == 0 && nums[0] == 0)  return 2;
            if(target == 0 || nums[0] == target)  return 1;
            return 0;
        }

        int notTake = countPartitionRecursiveR(index-1, nums, target);
        int take = 0;
        if(nums[index] <= target)
            take = countPartitionRecursiveR(index-1, nums, target-nums[index]);

        return take + notTake;
    }

    //Memoization solution
    public int countPartitionsM(int[] arr, int diff) {
        int n = arr.length;
        int totalSum = 0;
        for(int index = 0; index < n; index++) totalSum += arr[index];
        if((totalSum - diff < 0) || (totalSum - diff) % 2 != 0) return 0;
        int target = (totalSum-diff)/2;
        int[][] dp = new int[n][target+1];
        for(int[] dpRow: dp){
            Arrays.fill(dpRow,-1);
        }
        return countPartitionMemoize(n-1, arr, target, dp);

    }


    private int countPartitionMemoize(int index, int[] nums, int target, int[][] dp){

        if(index == 0){
            if(target == 0 && nums[0] == 0)  return 2;
            if(target == 0 || nums[0] == target)  return 1;
            return 0;
        }

        if(dp[index][target] != -1) return dp[index][target];

        int notTake = countPartitionMemoize(index-1, nums, target, dp);
        int take = 0;
        if(nums[index] <= target)
            take = countPartitionMemoize(index-1, nums, target-nums[index], dp);

        return dp[index][target] = take + notTake;
    }

    //Tabulation solution
    public int countPartitionsT(int[] arr, int diff) {
        int n = arr.length;
        int totalSum = 0;
        for(int index = 0; index < n; index++) totalSum += arr[index];
        if((totalSum - diff < 0) || (totalSum - diff) % 2 != 0) return 0;
        int target = (totalSum-diff)/2;

        return countPartitionTabulation(arr, target);

    }


    private int countPartitionTabulation(int[] nums, int k){
        int n = nums.length;
        int[][] dp = new int[n][k+1];

        if(nums[0] <= k) dp[0][nums[0]] = 1;
        if(nums[0] == 0) dp[0][0] = 2;
        else dp[0][0] = 1;


        for(int index = 1; index < n; index++){
            for(int target = 0; target <= k ; target++){
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
    private static int countPartitionSO(int[] nums, int k){
        int n = nums.length;
        int[] prev = new int[k+1];

        if(nums[0] <= k) prev[nums[0]] = 1;
        if(nums[0] == 0) prev[0] = 2;
        else prev[0] = 1;


        for(int index = 1; index < n; index++){
            int[] curr = new int[k+1];
            for(int target = 0; target <= k ; target++){
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
