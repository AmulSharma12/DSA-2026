package S005_Stack_Queue;
import java.util.Stack;
//https://leetcode.com/problems/largest-rectangle-in-histogram/
public class P012_LC84_LargestRectangleInHistogram {
    public static void main(String[] args){
        //call from here...
    }

    //Approach 1 - brute force or naive approach - precomputing and prestoring the nse and pse
    public static int largestRectangleAreaBrute(int[] heights) {
        int maxArea = 0;
        int n = heights.length;
        int[] pse = findPSE(heights, n);
        int[] nse = findNSE(heights, n);
        for(int ind = 0; ind <n; ind++){
            System.out.println(pse[ind] + " " + nse[ind]);
            maxArea = Math.max(maxArea, heights[ind] * (nse[ind] - pse[ind] - 1));
        }

        return maxArea;
    }


    private static int[] findPSE(int[] nums, int n){
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int ind = 0; ind < n; ind++){
            while(!st.isEmpty() && nums[st.peek()] >= nums[ind]) st.pop();
            pse[ind] = st.isEmpty() ? -1 : st.peek();
            st.push(ind);
        }
        return pse;
    }

    private static int[] findNSE(int[] nums, int n){
        Stack<Integer> st = new Stack<>();
        int[] nse = new int[n];

        for(int ind = n-1 ; ind >= 0; ind--){
            while(!st.isEmpty() && nums[st.peek()] >= nums[ind]) st.pop();
            nse[ind] = st.isEmpty() ? n : st.peek();
            st.push(ind);
        }

        return nse;
    }
}
