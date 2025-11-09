package S002_Recursion;
import java.util.List;
import java.util.ArrayList;

public class P012_P1_Subsequences_PrintSubsequenceWhoseSumAsK {
    public static void main(String[] args){
        int[] nums = new int[]{1,2,1};
        printSingleSubsequence(0,new ArrayList<>(), 0, 2, nums, nums.length);
    }


    private static void printSingleSubsequence(int index, List<Integer> list, int sum, int targetSum,int[] nums, int size){
        //base case
        if(index == size){
            if(sum == targetSum){
                for(Integer element: list){
                    System.out.print(element + " ");
                }
                System.out.println();
            }
            return;
        }
        //not pick call
        printSingleSubsequence(index+1, list, sum, targetSum,nums, size);

        //pick call
        list.add(nums[index]);
        sum += nums[index];
        printSingleSubsequence(index + 1,list, sum, targetSum, nums, size);
        sum -= nums[index];
        list.remove(list.size() -1 );
    }
}
