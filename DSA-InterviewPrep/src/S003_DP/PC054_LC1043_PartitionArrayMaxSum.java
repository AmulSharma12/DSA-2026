package S003_DP;

import java.util.Arrays;

//https://leetcode.com/problems/partition-array-for-maximum-sum/
public class PC054_LC1043_PartitionArrayMaxSum {
    public static void main(String[] args){
        //call from here...
    }

    //Recursive solution
    public static int maxSumAfterPartitioningR(int[] arr, int k) {
        int n = arr.length;
        return maxSumRec(0, n, arr, k);
    }

    private static int maxSumRec(int ind, int n, int[] nums, int k){
        if(ind == n)    return 0;

        int length = 0;
        int maximum = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;
        for(int j = ind; j<Math.min(n, ind+k); j++){
            length++;
            maximum = Math.max(maximum, nums[j]);
            int summation = (maximum * length) + maxSumRec(j+1, n, nums, k);
            maxSum = Math.max(maxSum, summation);
        }

        return maxSum;
    }


    //Memoization solution
    public static int maxSumAfterPartitioningM(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return maxSumMemoize(0, n, arr, k, dp);
    }

    private  static int maxSumMemoize(int ind, int n, int[] nums, int k, int[] dp){
        if(ind == n)    return 0;

        if(dp[ind] != -1)   return dp[ind];

        int length = 0;
        int maximum = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;
        for(int j = ind; j<Math.min(n, ind+k); j++){
            length++;
            maximum = Math.max(maximum, nums[j]);
            int summation = (maximum * length) + maxSumMemoize(j+1, n, nums, k, dp);
            maxSum = Math.max(maxSum, summation);
        }

        return dp[ind] = maxSum;
    }
}
