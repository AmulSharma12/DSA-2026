package S003_DP;
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
}
