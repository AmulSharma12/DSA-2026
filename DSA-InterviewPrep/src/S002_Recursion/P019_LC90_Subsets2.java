package S002_Recursion;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class P019_LC90_Subsets2 {
    public static void main(String[] args){
        //call from here...
    }
    public static  List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> uniqueSubsets = new ArrayList<>();
        generateUniqueSubsets(0,new ArrayList<>(), uniqueSubsets, nums);
        return uniqueSubsets;
    }

    private static  void generateUniqueSubsets(int index, List<Integer> list, List<List<Integer>> uniqueSubsets, int[] nums){
        //add every list to subsets
        System.out.println(list);
        uniqueSubsets.add(new ArrayList<>(list));

        //at each level of recursion skip the duplicates from index till the n
        for(int currIndex = index; currIndex < nums.length; currIndex++){
            if(currIndex > index && nums[currIndex] == nums[currIndex-1]) continue;

            list.add(nums[currIndex]);
            generateUniqueSubsets(currIndex+1, list, uniqueSubsets, nums);
            list.remove(list.size() - 1);
        }
    }
}
