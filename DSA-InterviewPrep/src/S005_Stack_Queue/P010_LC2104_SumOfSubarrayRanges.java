package S005_Stack_Queue;
//https://leetcode.com/problems/sum-of-subarray-ranges/description/

public class P010_LC2104_SumOfSubarrayRanges {
    public static void main(String[] args){
        //call from here...
    }


    //Approach 1 - using brute/naive approach generating all subarray from every element
    public static long subArrayRanges(int[] nums) {
        long sum = 0;
        int n = nums.length;

        for(int i = 0; i<n; i++){
            int largest = nums[i];
            int smallest = nums[i];
            for(int j = i+1; j<n; j++){
                largest = Math.max(largest, nums[j]);
                smallest = Math.min(smallest, nums[j]);

                sum = sum + (largest - smallest);
            }
        }

        return sum;
    }
}
