package S006_BinarySearch;
//Question 7 - provided a sorted rotated array how many number of times

public class P007_NumberOFTimesSortedArrayRotated {
    public static void main(String[] args){
        //call from here...
        int[] nums = new int[] {3,4,5,6,1,2};
        System.out.println(rotationCountBinarySearch(nums, nums.length));
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


    //Approach 2 - using binary search approach
    private static int rotationCountBinarySearch(int[] nums, int n){
        int low = 0;
        int high = n-1;
        int minIndex = 0;
        int mini = Integer.MAX_VALUE;
        if(nums[low] < nums[high])  return 0;

        while(low <= high){
            int mid = (low + high)/2;
            if(nums[low] <= nums[mid]){
                if(nums[low] < mini){
                    mini = nums[low];
                    minIndex = low;
                }
                low = mid + 1;
            }else{
                if(nums[mid] < mini){
                    mini = nums[mid];
                    minIndex = mid;
                }

                high = mid - 1;
            }
        }

        return minIndex;
    }
}
