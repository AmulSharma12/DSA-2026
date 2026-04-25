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


    //Approach 2 - using stack in single pass tracking pse and also when popping
    //current element becomes nse of the element which is at st.peek()
    private static int largestRectangleAreaOptimized(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> st = new Stack<>();

        for(int ind = 0; ind <n; ind++){
            while(!st.isEmpty() && heights[st.peek()] > heights[ind]){
                int element = st.peek();
                st.pop();
                int nse = ind;
                int pse = st.isEmpty() ? -1 : st.peek();
                maxArea = Math.max(maxArea, heights[element] * (nse - pse - 1));
            }

            st.push(ind);
        }

        //leftover element will hypothetical nse that would be size i.e. n
        while(!st.isEmpty()){
            int nse = n;
            int element = st.peek(); st.pop();
            int pse = st.isEmpty() ? -1 : st.peek();
            maxArea = Math.max(maxArea, heights[element] * (nse - pse -1));
        }

        return maxArea;
    }
}
