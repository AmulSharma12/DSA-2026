package S003_DP;
//https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1
public class PC014_SubsetSumWIthTargetSumExistGFG {
    public static void main(String[] args){
        //call from here...
    }

    static Boolean isSubsetSum(int[] arr, int sum) {
        int n = arr.length;
        return solveRecursive(n-1, arr, sum);
    }

    static Boolean solveRecursive(int ind, int[] nums, int target){
        if(target == 0) return true;
        if(ind == 0 && nums[0] == target) return true;
        if(ind < 0)   return false;

        boolean notTake;
        notTake = solveRecursive(ind-1, nums, target);

        boolean take = false;
        if(nums[ind] <= target) take = solveRecursive(ind-1, nums, target - nums[ind]);


        return take || notTake;
    }
}
