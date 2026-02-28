package S003_DP;
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
}
