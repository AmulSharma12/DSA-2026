package S002_Recursion;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class P017_LC40_CombinationSum2Optimised {

    public static void main(String[] args){
        //call from here..
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> uniqueCombinations = new ArrayList<>();
        generateUniqueCombinations(0, new ArrayList<>(), uniqueCombinations, candidates, candidates.length, target);
        return uniqueCombinations;
    }

    private static void generateUniqueCombinations(int index, List<Integer> list, List<List<Integer>> combinations, int[] nums, int size, int target){
        //base case
        if(target == 0){
            System.out.println(list.toString());
            combinations.add(new ArrayList<>(list));
            return;
        }

        //for every index we have to pick unique combinations
        //skip duplicates & element can exceeds target
        for(int i = index; i<size; i++){
            if(i > index && nums[i-1] == nums[i]) continue;
            if(nums[i] > target) break;

            list.add(nums[i]);
            generateUniqueCombinations(i+1, list, combinations, nums, size, target - nums[i]);
            list.remove(list.size() - 1);
        }


    }
}
