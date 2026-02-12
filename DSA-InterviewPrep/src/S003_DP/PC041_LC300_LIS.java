package S003_DP;
//https://leetcode.com/problems/longest-increasing-subsequence/
public class PC041_LC300_LIS {
    public static void main(String[] args){
        //call from here...
    }

    //Recursive solution
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        return lisRec(0,-1, nums, n);
    }

    private static int lisRec(int ind, int prev_ind, int[] nums, int n){
        if(ind == n)    return 0;

        int notPicked = lisRec(ind+1, prev_ind, nums, n);
        int picked = 0;
        if(prev_ind == -1 || nums[ind] > nums[prev_ind])
            picked = 1 + lisRec(ind+1, ind, nums, n);

        return Math.max(notPicked, picked);
    }
}
