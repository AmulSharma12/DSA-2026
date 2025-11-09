package S002_Recursion;
import java.util.List;
import java.util.ArrayList;

public class P014_P1_Subsequences_CountSubsequenceWhoseSumAsK {
    public static void main(String[] args){
        int[] nums = new int[]{1,2,1};
        System.out.println(countSubsequenceSumAsK(0, new ArrayList<>(), 0, 2, nums, nums.length));
    }

    private static int countSubsequenceSumAsK(int index, List<Integer> list, int sum, int targetSum, int[] nums, int size){
        //base case
        if(index == size){
            if(sum == targetSum) return 1;
            return 0;
        }

        //not pick call
        int notPickCount  = countSubsequenceSumAsK(index + 1,list, sum , targetSum, nums, size);
        //pick call
        list.add(nums[index]);
        sum += nums[index];
        int pickCount  = countSubsequenceSumAsK(index + 1, list, sum, targetSum, nums, size);
        sum -= nums[index];
        list.remove(list.size() -1);


        return pickCount + notPickCount;
    }
}
