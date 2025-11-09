package S002_Recursion;
import java.util.List;
import java.util.ArrayList;
public class P011_P1Subsequences_PrintAllSubsequences {
    public static void main(String[] args){
        int[] nums = new int[]{1,3,2};
        printAllSubsequences(0, new ArrayList<>(), nums, nums.length);
    }


    private static void printAllSubsequences(int index, List<Integer> list, int[] nums, int size){
        //base case
        if(index == size){
           for(Integer element: list){
                System.out.print(element + " ");
           }

           System.out.println(list.size() == 0 ? "{}" : "");
            return;
        }

        //not pick recursive call
        printAllSubsequences(index+1, list, nums, size);
        //pick recursive  call
        list.add(nums[index]);
        printAllSubsequences(index+1, list, nums, size);
        list.remove(list.size() - 1);

    }
}
