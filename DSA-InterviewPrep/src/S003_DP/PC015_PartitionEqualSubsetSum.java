package S003_DP;

public class PC015_PartitionEqualSubsetSum {
    public static void main(String[] args){
        //call from here...
    }

    //Recursive solution
    public static boolean canPartition(int[] nums) {
        int totalSum = 0;
        int n = nums.length;
        for(int element: nums)  totalSum += element;
        if(totalSum %2 != 0)    return false;
        return isTargetSubsetSumExist(n-1, totalSum/2, nums);
    }


    private static boolean isTargetSubsetSumExist(int index, int target, int[] nums){
        if(target == 0)     return true;
        if(index < 0)   return false;
        if(index == 0 && nums[0] == target)     return true;

        boolean notTake = isTargetSubsetSumExist(index-1, target, nums);
        boolean take = false;
        if(nums[index] <= target)
            take = isTargetSubsetSumExist(index-1, target-nums[index], nums);

        return take || notTake;
    }
}
