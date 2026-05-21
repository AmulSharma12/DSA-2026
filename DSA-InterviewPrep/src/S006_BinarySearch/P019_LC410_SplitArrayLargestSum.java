package S006_BinarySearch;
//https://leetcode.com/problems/split-array-largest-sum/
public class P019_LC410_SplitArrayLargestSum {
    public static void main(String[] args){
        //call from here..
    }


    //Approach 1 - using linear search approach
    public static int splitArray(int[] nums, int k) {
        int n = nums.length;

        if(k > n)   return -1;

        int max = Integer.MIN_VALUE;
        int totalSum = 0;

        for(int ind = 0; ind < n; ind++){
            max = Math.max(max, nums[ind]);
            totalSum+=nums[ind];
        }


        for(int largestSum = max; largestSum <= totalSum; largestSum++){
            if(isPossibleToSplit(nums, n, largestSum, k))   return largestSum;
        }

        return -1;

    }

    private static boolean isPossibleToSplit(int[] nums, int n, int largestSum, int k){
        int split = 1;
        int sum = 0;
        for(int ind = 0; ind < n; ind++){
            if(sum + nums[ind] <= largestSum)  {
                sum += nums[ind];
            }else{
                split++;
                sum = nums[ind];
            }
        }

        return split <= k;
    }
}
