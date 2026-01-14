package S003_DP;
//GFG: https://www.geeksforgeeks.org/problems/minimum-sum-partition3317/1
public class PC016_GFG_MinimumSumPartition {
    public static void main(String[] args){
        //call from here
    }

    //Tabulation solution
    public static int minDifference(int arr[]) {
        int n = arr.length;
        int totalSum = 0;
        for(int i = 0; i<n; i++)    totalSum += arr[i];
        int k = totalSum;

        boolean[][] dp = new boolean[n][k+1];

        for(int i = 0; i<n; i++)    dp[i][0] = true;
        if(arr[0] <= k) dp[0][arr[0]] = true;

        for(int index = 1; index<n; index++){
            for(int target = 1; target <= k; target++){
                boolean notTake = dp[index-1][target];
                boolean take = false;
                if(arr[index] <= target)    take = dp[index-1][target-arr[index]];

                dp[index][target] = take || notTake;
            }
        }


        int mini = Integer.MAX_VALUE;
        // System.out.println(Arrays.toString(dp[n-1]));
        for(int target = 0; target <= totalSum/2; target++){

            if(dp[n-1][target]){
                // System.out.println(target);
                mini = Math.min(mini, Math.abs((totalSum - target) - target));
            }
        }
        return mini;
    }
}
