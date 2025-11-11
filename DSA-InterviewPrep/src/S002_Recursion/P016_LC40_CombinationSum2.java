package S002_Recursion;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;

public class P016_LC40_CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> set = new HashSet<>();
        findUniqueCombinations(0, new ArrayList<>(), set, candidates, candidates.length, target);
        List<List<Integer>> uniqueCombinations = new ArrayList<>(set);
        return new ArrayList<>(set);
    }

    private void findUniqueCombinations(int index, List<Integer> list, Set<List<Integer>> combinations, int[] nums, int size, int target){
        //base case
        if(index == size){
            if(target == 0){
                combinations.add(new ArrayList<>(list));
            }
            return;
        }

        //not pick call
        findUniqueCombinations(index + 1, list, combinations, nums, size, target);
        //pick call
        if(nums[index] <= target){
            list.add(nums[index]);
            findUniqueCombinations(index + 1, list, combinations, nums, size, target - nums[index]);
            list.remove(list.size()-1);
        }
    }
}
