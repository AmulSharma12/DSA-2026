package S005_Stack_Queue;

import java.util.Arrays;

//https://leetcode.com/problems/next-greater-element-ii/description/
public class P006_LC503_NextGreater2 {
    public static void main(String[] args){
        //call from here...
    }

    //Approach 1 - using brute force 2 loops
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];
        Arrays.fill(nge,-1);
        for(int ind = 0; ind <n; ind++){
            boolean isCycleCompleted = false;

            for(int j = (ind+1)%n; !isCycleCompleted ; j++){
                j = j%n;
                if(ind == j){
                    isCycleCompleted = true;
                    break;
                }

                if(nums[j] > nums[ind]){
                    nge[ind] = nums[j];
                    break;
                }

            }
        }

        return nge;
    }
}
