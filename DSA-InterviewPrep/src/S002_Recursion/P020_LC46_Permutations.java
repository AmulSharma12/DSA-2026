package S002_Recursion;
import java.util.List;
import java.util.ArrayList;

public class P020_LC46_Permutations {
    public static void main(String[] args){
        //call from here...
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        boolean[] isVisited = new boolean[nums.length];
        permutations(nums, new ArrayList<>(), permutations, nums.length, isVisited);
        return permutations;
    }

    private static void permutations(int[] nums, List<Integer> list, List<List<Integer>> permutations, int size, boolean[] isVisited){
        //base case
        if(list.size() == size){
            permutations.add(new ArrayList<>(list));
            return;
        }
        //trying out all the elements if pickable
        for(int index = 0; index <size; index++){
            if(!isVisited[index]){
                isVisited[index] = true;
                list.add(nums[index]);
                permutations(nums, list, permutations, size,isVisited);
                list.remove(list.size() - 1);
                isVisited[index] = false;
            }
        }

    }
}
