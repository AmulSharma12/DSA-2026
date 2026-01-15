package S003_DP;

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
}
