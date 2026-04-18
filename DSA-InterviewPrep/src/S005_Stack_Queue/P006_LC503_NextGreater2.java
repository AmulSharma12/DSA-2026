package S005_Stack_Queue;

import java.util.Arrays;
import java.util.Stack;

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


    //Approach 2 - using optimisation via monotnoic stack pattern
    public static int[] nextGreaterElementsOptimization(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];
        for(int ind = 2*n-1; ind >= 0; ind--){
            while(!st.isEmpty() && st.peek() <= nums[ind%n]) st.pop();

            if(ind < n) nge[ind] = st.isEmpty() ? -1 : st.peek();

            st.push(nums[ind%n]);
        }

        return nge;
    }
}
