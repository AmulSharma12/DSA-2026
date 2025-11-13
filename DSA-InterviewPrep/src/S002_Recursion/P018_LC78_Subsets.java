package S002_Recursion;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class P018_LC78_Subsets {
    public static void main(String[] args){
        //call from here
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        generatePowerSet(0, new ArrayList<>(), subsets, nums);
        return subsets;
    }

    private static void generatePowerSet(int index, List<Integer> list, List<List<Integer>> subsets, int[] nums){
        //base case
        if(index == nums.length){
            subsets.add(new ArrayList<>(list));
            return;
        }

        //not pick call
        generatePowerSet(index+1, list, subsets, nums);

        //pick call
        list.add(nums[index]);
        generatePowerSet(index+1, list, subsets, nums);
        list.remove(list.size() - 1);
    }

}
