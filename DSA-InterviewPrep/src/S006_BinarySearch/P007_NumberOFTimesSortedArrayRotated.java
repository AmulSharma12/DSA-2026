package S006_BinarySearch;
//Question 7 - provided a sorted rotated array how many number of times

public class P007_NumberOFTimesSortedArrayRotated {
    public static void main(String[] args){
        //call from here...
        int[] nums = new int[] {1,2,3,4,5};
        System.out.println(rotationCount(nums, nums.length));
    }

    //Approach 1 - using linear approach
    public static int rotationCount(int[] nums, int n){
        int minIndex = 0;
        for(int ind = 1; ind < n; ind++){
           if(nums[ind] < nums[minIndex]){
               minIndex = ind;
           }
        }

        return minIndex;
    }
}
