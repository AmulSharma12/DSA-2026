package S002_Recursion;
import java.util.List;
import java.util.ArrayList;

public class P013_P1_Subsequences_PrintSingleAnsWhoseSumAsK {
    public static void main(String[] args){
        int[] nums = new int[]{1,2,1};
        printSingleSubsequenceWhoseSumAsK(0, new ArrayList<>(), 0, 2, nums, nums.length);

    }

    private static boolean printSingleSubsequenceWhoseSumAsK(int index, List<Integer> list, int sum, int targetSum, int[] nums, int size)
    {
        //base case
        if(index == size){
            if(sum == targetSum){
                for(Integer element:list){
                    System.out.print(element + " ");
                }
                return true;
            }

            return false;
        }


        //pick call
        list.add(nums[index]);
        sum += nums[index];
        if(printSingleSubsequenceWhoseSumAsK(index+1, list, sum, targetSum, nums, size))    return true;
        sum -= nums[index];
        list.remove(list.size()-1);

        //not pick call
        if(printSingleSubsequenceWhoseSumAsK(index+1, list, sum, targetSum, nums, size))    return true;

        return false; // can't able to find subsequence whose sum as k
    }
}
