package S003_DP;
import java.util.Stack;
//https://leetcode.com/problems/largest-rectangle-in-histogram/description/
public class PC055_LC84_MaxAreaHistogram {
    public static void main(String[] args){
        //call from here...
    }

    //Naive solution
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = Integer.MIN_VALUE;
        for(int ind = 0; ind < n; ind++){

            int height = heights[ind];
            int nsl = ind - 1;
            while(nsl >= 0 && heights[ind] <= heights[nsl])  nsl--;
            int nsr = ind + 1;
            while(nsr < n && heights[ind] <= heights[nsr]) nsr++;

            int width = nsr - nsl - 1;
            int area = width * height;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }


    //Optimized Approach
    public static int largestRectangleAreaOptimised(int[] heights) {
        int n = heights.length;
        int maxArea = Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<>();

        for(int ind = 0; ind < n; ind++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[ind]){
                int elementInd = st.peek();
                st.pop();
                int nse = ind;
                int pse = st.isEmpty() ? -1 : st.peek();
                int area = heights[elementInd] * (nse-pse-1);
                maxArea = Math.max(area, maxArea);
            }

            st.push(ind);
        }

        //if there element remains in the stack
        while(!st.isEmpty()){
            int elementInd = st.peek();
            st.pop();
            int nse = n;
            int pse = st.isEmpty() ? -1 : st.peek();

            int area = heights[elementInd] * (nse - pse - 1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
