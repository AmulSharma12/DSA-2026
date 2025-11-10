package S002_Recursion;
import java.util.List;
import java.util.ArrayList;

public class P015_LC39_CombinationSum1 {

    public static void main(String[] args){
        //call from here..
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        List<List<Integer>> combinations = new ArrayList<>();
        generateUniqueCombinations(0, new ArrayList<>(), combinations, candidates, 0, target, candidates.length);
        return combinations;
    }

    private static void generateUniqueCombinations(int index, List<Integer> list, List<List<Integer>> combinations, int[] nums,int sum, int target, int size){
        if(index == size){
            if(sum == target){
                combinations.add(new ArrayList<>(list));
            }
            return;
        }

        generateUniqueCombinations(index+1, list, combinations, nums, sum, target, size);


        if(sum + nums[index] <= target){
            list.add(nums[index]);
            sum += nums[index];
            generateUniqueCombinations(index, list, combinations, nums, sum, target, size);
            sum -= nums[index];
            list.remove(list.size() - 1);
        }
    }
}
