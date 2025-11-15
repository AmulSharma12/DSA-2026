package S002_Recursion;
import java.util.List;
import java.util.ArrayList;

public class P021_LC46_Permutations_Approach2 {
    public static void main(String[] args){
        //call from here..
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        findPermutations(0, nums, nums.length, permutations);
        return permutations;
    }

    private static void findPermutations(int index, int[] nums, int size, List<List<Integer>> result)
    {
        //when you make all the descision index reaches to the size
        if(index == size){
            List<Integer> ds = new ArrayList<>();
            for(Integer element:nums){
                ds.add(element);
            }
            result.add(new ArrayList<>(ds));
            return;
        }

        for(int i = index; i<size; i++){
            swap(nums, index, i);
            findPermutations(index+1, nums, size, result);
            swap(nums, index, i);
        }
    }

    private static void swap(int[] nums, int currIndex, int swapIndex){
        int temp = nums[currIndex];
        nums[currIndex] = nums[swapIndex];
        nums[swapIndex] = temp;
    }
}
